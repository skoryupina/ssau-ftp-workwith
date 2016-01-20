/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workwithftp;
import java.io.*;
import java.net.*;
import java.util.*;
 
/**
 *
 * @author Катя
 */
public class ConnectionFTP {
    private String url;
    private String user;
    private String password;
    
    private Socket socket = null;
    private Socket addsocket = null;
    private BufferedReader reader;
    private BufferedWriter writer;
    private boolean wait;
    private String file_answer = ".\\answer.txt";
    private static final int FTP_PORT = 21;
    private myList structure;
    private LinkedHashMap<String,Integer> typeAndSize;
    private int sum;
    
    public Socket getSocket(){
        return socket;
    }
    
    public int getSize(){
        return sum;
    }
    
    public myList getStructure(){
        return structure;
    }
    
    public LinkedHashMap<String,Integer> getTypeAndSize(){
        return typeAndSize;
    }
    
    public ConnectionFTP(String url, String user,String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        socket = null;
        reader = null;
        writer = null;
        wait = false;
        typeAndSize = new LinkedHashMap<>();
    }
    
    public boolean getConnection() throws Exception {
        boolean result = false;
        socket = new Socket(url, FTP_PORT);
        if (socket.isConnected()){
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            String answerOfServer = checkAnswerOfServer();
            if (answerOfServer.startsWith("220")){
                answerOfServer = sendCommand("USER " + user);
                if (answerOfServer.startsWith("331")){
                    answerOfServer = sendCommand("PASS " + password);
                    if (answerOfServer.startsWith("230")){
                        result = true;
                    }
                    else{
                        throw new IOException("Неверный пароль: " + answerOfServer);
                    }
                }
                else{
                   throw new IOException("Неизвестный пользователь: " + answerOfServer);  
                }
            }
            else{
                throw new IOException("Ошибка при подключении к серверу: " + answerOfServer);
            }
        }
        else{
            throw new Exception ("Соединение не установлено");
        }
        return result;
    }
     
    public String checkAnswerOfServer() throws IOException{
        String answerOfServer = recognizeAnswer(reader.readLine());
        if (answerOfServer != null){
            String codeOfAnswer = answerOfServer.substring(0, 3);
            char isHyphen = answerOfServer.charAt(3);
            String next = null;
            if (isHyphen=='-'){
                String tester = codeOfAnswer + " ";
                boolean done = false;
                while (!done){
                    next = reader.readLine();
                    while (next.equals("")||next.equals(" ")){
                        next=reader.readLine();
                    }
                    if (next.substring(0, 4).equals(tester)){
                        done = true;
                    }
                }
                return next;
            }
            else{
                return answerOfServer;
            }
        }
        else{
            return null;
        }
    }
    
    private String recognizeAnswer(String line){
        char first = line.charAt(0);
        switch (first){
            case '1' :{
                wait = true;
            }break;
            case '2' :{
                wait = false;
            }break;
            case '3' :
            case '4' :
            case '5' :{
                //распознанный ответ
            }break;
            default: line = null;
        }
        return line;
    }
    
    //отправляет команду и возвращает ответ сервера
    public String sendCommand(String cmd) throws IOException{
        if (wait){
            String line = reader.readLine();
            wait = false;
        }
        writer.write(cmd+ "\r\n");
        writer.flush();
        String response = checkAnswerOfServer();
        return response;
    }
        
    public boolean closeConnection() throws Exception{
        boolean result = false;
        try{
            if (socket.isConnected()){
                sendCommand("QUIT");
                result = true;
            }
        }
        finally{
            socket.close();
            reader.close();
            writer.close();
            if (addsocket != null && addsocket.isConnected()){
                addsocket.close();
            }
        }
        return result;
    }
    
    public void mainGetList() throws Exception{
        String dir = "/";
        structure = getList(dir);
        if(structure.getSize()!=0){
            int i = 0;
            myList.Node node;
            node = structure.getFirst();
            while (i < structure.getSize())
            {
                if (node.getType().equals("dir")){
                    myList addList = getList(node.getName());
                    node.setList(addList);
                    dirSum(node.getList());
                    sendCommand("CDUP");
                }
                else{
                    sum +=Integer.parseInt(node.getSize());
                }
                i++;
                if (node.getNext() != null){
                    node = node.getNext();
                }
            }
        }
    }
    
    public void dirSum(myList list){
         if(list.getSize()!=0){
            int i = 0;
            myList.Node node;
            node = list.getFirst();
            while (i < list.getSize())
            {
                sum +=Integer.parseInt(node.getSize());
                i++;
                if (node.getNext()!=null){
                    node = node.getNext();
                }
            }
    }
    }
    
    public myList getList(String dir) throws Exception { 
        myList structure1 = new myList();
        setDirectory(dir);
        setTransferType('A');
        openNewConnection();
        if (addsocket.isConnected()){
            InputStream is = addsocket.getInputStream();
            sendCommand("LIST");
            String contents = getAsString(is,structure1);
        }
        return structure1;
    }
    
    private String getAsString(InputStream is,myList structure) throws Exception{
        String content=null;
        byte buf[] = new byte[64*1024];
        int size = is.read(buf);
        content = new String(buf,0,size);
        String[] linesOfContent = content.split("\r\n");
        
        for (String line : linesOfContent){
            analyseLine(line,structure);
        }
        return content;
    }
    
    private void analyseLine(String line,myList structure){
        String name=null,size=null,type = null;
        if (line.charAt(0) == 'd' ){
            type = "dir";
        }
        int index = 0;
        for (int i = 1; i < 9; i++){
            index = line.indexOf(" ",index+1);
            while (line.charAt(index) == ' '){
                index++;
            }
            if (i == 4){
                size = line.substring(index, line.indexOf(" ",index));
            }
            if (i == 8){
                name = line.substring(index);
            }
            
        }
        if (type == null){
            index = name.indexOf(".");
            type = name.substring(index);
        }
        //structure.addToTail(name, size, type);
        
        if (!name.equals("..")&& !name.equals(".")){
            structure.addToTail(name, size, type);
            if (!type.equals("dir")){
                if (typeAndSize.containsKey(type)){
                    int prev = typeAndSize.get(type);
                    int current = Integer.parseInt(size) + prev;
                    typeAndSize.put(type, current);
                }
                else{
                    typeAndSize.put(type, Integer.parseInt(size));
                }
            }
        }
    }
    
    private void setDirectory(String dir) throws IOException { 
        sendCommand("CWD "+dir);
    }
    
    private void setTransferType(char type) throws IOException {
        sendCommand("TYPE "+type);
    } 
     
     public void openNewConnection() throws Exception{
           String answerOfServer = sendCommand("PASV");
           StringTokenizer st = new StringTokenizer(answerOfServer,",");
           String[] parts = new String[6];
           int i = 0;
           while (st.hasMoreElements()){
               parts[i] = st.nextToken();
               i++;
           }
           //из ответа на пассивную передачу данных извлекается ip
           String[] possNum = new String[3];
           for (int j=0;j<possNum.length;j++){
               possNum[j]=parts[0].substring(parts[0].length()-(j+1), parts[0].length()-j);
               if (!Character.isDigit(possNum[j].charAt(0))){
                   possNum[j]="";
               }
           }
           
           parts[0]=possNum[2]+possNum[1]+possNum[0];
           int braket = parts[5].indexOf(")");
           parts[5]=parts[5].substring(0, braket);
          /* String[] porties = new String[3];
           for (int k=0;k<3;k++){
               if((k+1)<=parts[5].length()){
                   int braket = parts[5].indexOf(")");
                   porties[k]=parts[5].substring(0, braket);
                   //porties[k]=parts[5].substring(k, k+1);
               }
               else{
                   porties[k]="FOOBAR";
               }
               if (!Character.isDigit(porties[k].charAt(0))){
                   porties[k]="";
               }
           }
           parts[5]=porties[0]+porties[1]+porties[2];*/
           String ip = parts[0]+"."+parts[1]+"."+parts[2]+"."+parts[3];
           int port = -1;

           int big = Integer.parseInt(parts[4])<<8; 
           int small=Integer.parseInt(parts[5]);
           port = big + small;

           if (ip!=null && port != -1){
               addsocket = new Socket(ip,port);
           }
       }
       
}

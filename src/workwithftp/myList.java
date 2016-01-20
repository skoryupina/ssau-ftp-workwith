package workwithftp;

public class myList {
    private Node head;
    private Node last;
    private int size = 0;
    public myList(){
        head = new Node("","","");//создание головы списка, не хранящей значения
        last=head;
    }
    
    public void addToTail(String name,String size, String type){
        Node item = new Node(name,size,type);
        last.next = item;
        last = item;
        this.size++;
    }
    
    public int getSize(){
        return size;
    }
    
    public Node getFirst(){
        return head.next;
    }
    
    public class Node{
        private Node next = null;
        private String name;
        private String size;
        private String type;
        private myList list;
        
        public String getName(){
            return name;
        }
        
        public String getSize(){
            return size;
        }
        
        public String getType(){
            return type;
        }
        
        public myList getList(){
            return list;
        }
        
        public void setList(myList list){
            this.list = list;
        }
        
        public Node getNext(){
            return next;
        }
        
        private Node (String name,String size,String type){
            this.next = null;
            this.name = name;
            this.size = size;
            this.type = type;
            if (type.equals("dir")){
                this.list = new myList();
        }
    }
       
    }
}

   
            


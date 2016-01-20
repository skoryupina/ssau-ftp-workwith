
package workwithftp;

import javax.swing.*;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class IndexForm extends javax.swing.JFrame {
    
    public ConnectionFTP handler;
    public Thread act;
    public Actions actFrame;
    
    public IndexForm() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        InstructionLabel = new javax.swing.JLabel();
        OK = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        urlLabel = new javax.swing.JLabel();
        urlField = new javax.swing.JTextField();
        userLabel = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        portLabel1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jMenuBar2 = new javax.swing.JMenuBar();
        Close = new javax.swing.JMenu();
        Close1 = new javax.swing.JMenu();
        Close2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Работа с FTP-сервером");
        setBackground(new java.awt.Color(255, 255, 153));
        setName("Соединение с сервером"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        InstructionLabel.setBackground(new java.awt.Color(255, 255, 255));
        InstructionLabel.setText("Введите необходимые данные для корректной работы программы.");

        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(244, 244, 244));

        urlLabel.setBackground(new java.awt.Color(255, 255, 255));
        urlLabel.setText("Адрес FTP-сервера:");

        urlField.setText("www.ssau.ru");
        urlField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlFieldActionPerformed(evt);
            }
        });

        userLabel.setBackground(new java.awt.Color(255, 255, 255));
        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userLabel.setText("Пользователь:");

        userField.setText("test16_guest");

        portLabel1.setBackground(new java.awt.Color(255, 255, 255));
        portLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        portLabel1.setText("Пароль");

        jPasswordField1.setText("12345");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(portLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(urlLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(urlField)
                            .addGap(9, 9, 9))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urlLabel)
                    .addComponent(urlField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel)
                    .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portLabel1)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(InstructionLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(InstructionLabel)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OK)
                .addGap(5, 5, 5))
        );

        Close.setText("О программе");
        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseMouseClicked(evt);
            }
        });
        jMenuBar2.add(Close);

        Close1.setText("Об авторе");
        Close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Close1MouseClicked(evt);
            }
        });
        jMenuBar2.add(Close1);

        Close2.setText("Закрыть");
        Close2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Close2MouseClicked(evt);
            }
        });
        jMenuBar2.add(Close2);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void urlFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urlFieldActionPerformed

    private void createOutput(HashMap<String,Integer> list_and_size)
                throws IOException {
        //подсчет общего размера файлов
        int sum = 0;
        Collection<Integer> sizes = list_and_size.values();
        //берем итератор коллекции
        Iterator<Integer> iterator = sizes.iterator();
        while(iterator.hasNext()){
            sum +=iterator.next();
        }
        
       /*запись в символьный поток*/
        FileWriter out = null;
        PrintWriter pout = null;
        try{
            out = new FileWriter(".\\results.txt");
            pout = new PrintWriter(out);
            pout.println("Всего файлов:  " + list_and_size.size());
            pout.println("Общий размер:  " + sum);
            pout.println("\n");
            
            //записываем список
            //обходя коллекцию улучшенным for
            for (Map.Entry<String,Integer> entry : list_and_size.entrySet()){            
                pout.print(entry.getKey() + "   -    ");
                pout.println(entry.getValue());
            }
            pout.flush();
        }
        catch (IOException e) {
            throw  new IOException("Ошибка при записи результатов в файл");
        }
        finally{
            out.close();
            pout.close();
        }
    }
    
    
    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
       String url=null,user=null,password=null;
     
        try{
           
            if (handler!=null && handler.getSocket().isConnected()){
                handler.closeConnection();
            }
            //чтение введенных данных
            url =urlField.getText();
            user = userField.getText();
            password = new String(jPasswordField1.getPassword());
            if (url!=null && user!=null&& password!=null){
               handler = new ConnectionFTP(url, user, password);
               boolean connection = handler.getConnection();
               if (connection){
                    if (act!=null /*&& act.isAlive()*/){
                        actFrame.setHandler(handler);
                    }
                    else{
                        actFrame = new Actions(handler);
                        act = new Thread(actFrame);
                        act.start();
                    }
               }
            }
            else
            {
                throw new Exception("Требуется заполнить все поля");
            }
        /*
        JOptionPane.showMessageDialog(null, "Работа программы успешно завершена");
      /*  
        //добавляем результаты в файл
        createOutput(list_and_size);
        
        JOptionPane.showMessageDialog(null, "Результаты записаны в файл - results.txt");*/
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }//GEN-LAST:event_OKActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try{
            if (handler!= null && handler.getSocket().isConnected()){
               handler.closeConnection();
            }
        }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }//GEN-LAST:event_formWindowClosed

    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        JOptionPane.showMessageDialog(null, "Лабораторная работа № 3. Исследование структуры FTP - сервера.\n"
                + "---Выполняется анализ содержимого и вывод его в пользовательском интерфейсе---");
    }//GEN-LAST:event_CloseMouseClicked

    private void Close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Close1MouseClicked
          JOptionPane.showMessageDialog(null, "Выполнила студентка группы 631\n"
                  + "Екатерина Скорюпина\n"
                  + "--\n"
                  + "10 - 14 ноября 2013 года");
    }//GEN-LAST:event_Close1MouseClicked

    private void Close2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Close2MouseClicked
         this.dispose();
    }//GEN-LAST:event_Close2MouseClicked

 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IndexForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndexForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndexForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndexForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndexForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Close;
    private javax.swing.JMenu Close1;
    private javax.swing.JMenu Close2;
    private javax.swing.JLabel InstructionLabel;
    private javax.swing.JButton OK;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel portLabel1;
    private javax.swing.JTextField urlField;
    private javax.swing.JLabel urlLabel;
    private javax.swing.JTextField userField;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
   
}

package workwithftp;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class JTreeTest extends JFrame{

    private static final long serialVersionUID = 1L;
    private JTree tree;

    public JTreeTest(ConnectionFTP handler) {
       Container c = getContentPane(); 
       c.setLayout(new BorderLayout()); 
       DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
       root = createNodes(root,handler.getStructure());
       tree = new JTree(root);
       c.add(new JScrollPane(tree));
       // настройка окна
       setTitle("Структура каталогов FTP-сервера ssau.ru"); 
       setPreferredSize(new Dimension(400, 250));
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       pack(); // устанавливаем размеры
       setVisible(true); 
    }

    private DefaultMutableTreeNode createNodes(DefaultMutableTreeNode top,myList structure) {
            DefaultMutableTreeNode folder = null;
            DefaultMutableTreeNode item = null;
           
            if (structure!= null){
                myList.Node node = structure.getFirst();
                while (node !=null){
                    if (node.getType().equals("dir")){
                        folder = new DefaultMutableTreeNode(node.getName());
                        top.add(folder);
                        createNodes(folder,node.getList());
                    }
                    else
                    {
                        item = new DefaultMutableTreeNode(node.getName());
                        top.add(item);
                    }
                    node = node.getNext();
                }
            }
            return top;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFrame;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author HP-PC
 */
public class MyFrame extends JFrame {
        public MyFrame(){
            super("Test Frame2");
            setSize(300, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new FlowLayout());
            this.add(new JLabel(" Hello "));
            //JPanel p=new JPanel();
            //p.setBackground(Color.red);
            //p.setPreferredSize(new Dimension(150,100));//?
            //f.add(p);
        }
        public static void main(String[] args) {
            MyFrame f = new MyFrame();
           
           
           f.getContentPane().setBackground(Color.yellow);
          
           // f.setSize(300, 200);
           // f.setBackground(Color.red);
            f.setVisible(true);
        }
    
}

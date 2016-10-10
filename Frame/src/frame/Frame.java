/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 /**
 *
 * @author HP-PC
 */
public class Frame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame=new JFrame ("Test Frame");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setBackground(Color.yellow);
        
        //frame.setLayout(new FlowLayout());//FlowLayout从左往右，从上向下；BorderLayout东南西北中，Layout
        frame.add(new JLabel(" Hello "),BorderLayout.NORTH);//JLabel是一个标签；
        frame.getContentPane().setBackground(Color.yellow);// 取内容窗格再设背景色，不然就再给容器
        
        JPanel p=new JPanel();
        p.setBackground(Color.blue);
        p.setPreferredSize(new Dimension(640,480));//设置Jpanel的大小
        JLabel l1 = new JLabel("Hello");
        JButton b=new JButton("PUSH"+l1);
        b.add(new PushCounterPanel());
        p.add(l1);
        p.add(b);
        frame.add(p);
        frame.pack();//根据p的大小设置frame的大小
        
        frame.setVisible(true);
    }
    
}

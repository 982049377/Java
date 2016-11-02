/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author HP-PC
 */
public class ThreadTest {
    public static void main(String[] args) {
        JFrame JF=new JFrame("ThreadTest");
        JF.setLayout(new FlowLayout());
        JF.setSize(300, 300);
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel b=new  TestPanel();
        //b.setPreferredSize(new Dimension(150,100));
        JF.add(b);
       // JF.pack();
        JF.setVisible(true);
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;
import javax.swing.JFrame;
import javax.swing.*; 
import java.awt.*;


/**
 *
 * @author HP-PC
 */
public class Text {

    /**
     * @param args the command line arguments
     */
    //void setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) 
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Frame"); 
        frame.setSize(1280, 960);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout()); 
        frame.add(new JLabel("Hello")); 
        frame.setVisible(true); 
    }
    
}

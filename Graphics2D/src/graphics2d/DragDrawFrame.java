/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics2d;
import javax.swing.*;
/**
 *
 * @author HP-PC
 */
public class DragDrawFrame  extends JFrame {

    public DragDrawFrame(){ 
        setTitle("DragDraw"); 
        DragDrawPanel panel = new DragDrawPanel(); 
        add(panel); 
    }
    public static void main(String args[]) { 
        DragDrawFrame frame = new DragDrawFrame(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(300, 300); 
        frame.setVisible(true); 
    }

}

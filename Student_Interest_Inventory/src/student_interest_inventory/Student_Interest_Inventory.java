/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_interest_inventory;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author HP-PC
 */
public class Student_Interest_Inventory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame JF=new JFrame();
        JF.setSize(300, 200);
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel b=new Panel();
        b.setPreferredSize(new Dimension(150,100));
        JF.add(b);
        JF.setVisible(true);
    }
    
}

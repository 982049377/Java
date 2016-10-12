/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author HP-PC
 */
public class Guess {
      public static void main(String[] args) {
            JFrame JF=new JFrame("Guess number");
            JF.setSize(300, 200);
            JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel b=new Panel();
            JF.add(b);
           // JF.pack();
            JF.setVisible(true);
          
      }
}

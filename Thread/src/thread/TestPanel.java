/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
// java.lang.Math.random();
import java.util.ArrayList;

/**
 *
 * @author HP-PC
 */
public class TestPanel extends JPanel{
    private ArrayList<Ball> Balllist;
    public TestPanel(ArrayList<Ball> bl) {
        Balllist=bl;
        setPreferredSize(new Dimension(400, 100));  
        setBackground(Color.yellow);
    }
    public void paintComponent (Graphics g){
         super.paintComponent (g); 
            for(Ball i:Balllist){
                i.draw(g);
                //System.out.println(i);
        }          
    }


}

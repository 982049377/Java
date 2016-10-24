/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawline;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

/**
 *
 * @author HP-PC
 */
public class DrawLine extends JPanel{
    private int x1,y1,x2,y2;   
    public DrawLine() { 
        x1 = y1 = x2 = y2 = 0;    
        addMouseListener (  new MouseChange()); 
        addMouseMotionListener (  new MouseMotion());
        setPreferredSize (new Dimension (400 ,200));
    }
    public void paintComponent (Graphics g){ 
        super.paintComponent (g); 
       // g.setColor (Color.red);    
     //   g.drawLine (x1,y1,x2,y2);                       
    }
    private class MouseChange extends MouseAdapter{     
        public void mousePressed (MouseEvent e){ 
            x1 = e.getX(); 
            y1 = e.getY();
        }             
    } 
    private class MouseMotion extends MouseMotionAdapter{
        public void mouseDragged (MouseEvent e){ 
            //repaint (); 
            Graphics g =  getGraphics();
            x2 = e.getX(); 
            y2 = e.getY(); 
            g.drawLine(x1, y1, x2, y2); 
            x1 = x2; 
            y1 = y2;
            g.dispose();

        }     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame JF=new JFrame();
        JF.setSize(1400, 800);
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel b=new DrawLine();
        JF.add(b);
        JF.setVisible(true);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics2d;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.awt.geom.*;

/**
 *
 * @author HP-PC
 */
public class DragDrawPanel  extends JPanel {
    int x1, y1, x2, y2; 
    public DragDrawPanel() { 
        addMouseMotionListener(new MouseMotion());
        addMouseListener(new MouseChange()); 
    }
    private class MouseChange extends MouseAdapter { 
        public void mousePressed(MouseEvent e) { 
            x1 = e.getX();
            y1 = e.getY(); 
        } 
    }

    private class MouseMotion extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e) {
            Graphics2D g = (Graphics2D) getGraphics();
            x2 = e.getX(); 
            y2 = e.getY(); 
            g.draw(new Line2D.Double(x1, y1, x2, y2)); 
            x1 = x2;
            y1 = y2; 
            g.dispose(); 
        } 
    }
//    private class MouseMotion extends MouseMotionAdapter { 
//        public void mouseDragged(MouseEvent e) { 
//            Graphics g =  getGraphics();
//            x2 = e.getX(); 
//            y2 = e.getY(); 
//            g.drawLine(x1, y1, x2, y2); 
//            x1 = x2;
//            y1 = y2;
//            g.dispose(); 
//        } 
//    }
}
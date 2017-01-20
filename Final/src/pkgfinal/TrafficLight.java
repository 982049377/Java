/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author HP-PC
 */
public class TrafficLight extends JPanel{
    private int i;
    public TrafficLight(int width,int height){
        setPreferredSize(new Dimension(width, height));  
        setBackground(Color.BLACK);
        i=0;
    }
    public void seti(int ii){
        i=ii;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.getWidth()>this.getHeight()){
            switch(getI()){
                case 1 :
                    g.setColor(Color.yellow);
                    g.fillOval(this.getWidth()/3, 0, this.getWidth()/3,this.getWidth()/3);
                    break;
                case 2 :
                    g.setColor(Color.green);
                    g.fillOval(this.getWidth()/3*2, 0, this.getWidth()/3,this.getWidth()/3);
                    break;
                case 0 :
                    g.setColor(Color.red);
                    g.fillOval(0, 0,this.getWidth()/3, this.getWidth()/3);
                    break;
            }    
        }
        if(this.getWidth()<=this.getHeight()){
            switch(getI()){
                case 1 :
                    g.setColor(Color.yellow);
                    g.fillOval(0, this.getHeight()/3, this.getHeight()/3,this.getHeight()/3);
                    break;
                case 2 :
                    g.setColor(Color.green);
                    g.fillOval(0,this.getHeight()/3*2, this.getHeight()/3,this.getHeight()/3);
                    break;
                case 0 :
                    g.setColor(Color.red);
                    g.fillOval(0, 0,this.getHeight()/3, this.getHeight()/3);
                    break;
            }    
        }
    }

    /**
     * @return the i
     */
    public int getI() {
        return i;
    }
}

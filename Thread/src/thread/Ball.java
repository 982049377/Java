/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author HP-PC
 */
public class Ball {
    private int Size;
    private Color color;
    private int x;
    private int y;
    private int degree=30;
    private int xoffset=5;
    private int yoffset=5;
    public Ball(int sz,Color color){
        //x=xx;
        //y=yy;
        Size=sz;
        this.color=color;
    }
    public void move(){
        x+=xoffset;
        y+=yoffset;
        
        degree-=3;
        if(degree<0)
             degree=30;
    }
    public void Bouned(int width,int height){
        Random rand=new Random();
        int i=rand.nextInt(2);
        int ii=rand.nextInt(2);
        ii*=-1;
        xoffset=xoffset+i+ii;
        yoffset=yoffset+i+ii;
        if(xoffset<0&&x<0)
            xoffset*=-1;
        if(xoffset>0&&x>width)
            xoffset*=-1;
        if(yoffset<0&&y<0)
            yoffset*=-1;
        if(yoffset>0&&y>height)
            yoffset*=-1;   
        //System.out.println(i);
        //System.out.println("ii"+ii);
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillArc(x,y,Size,Size,360,360-degree);
    }
}

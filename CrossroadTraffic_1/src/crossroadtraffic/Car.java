/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossroadtraffic;

import java.awt.Color;
import java.awt.Graphics;

enum Carhead{
    SouthToNorth,
    EastToWest,
    NorthToSouth,
    WestToEast
}

public class Car {
    private int Width,Height;
    private Color color;
    public int x,y;
    private int xoffset=5,yoffset=5;
    
    public Carhead head;
    public boolean Canrun=true;
    private final static int space=25;
    public Car(int w,int h,Color color,int speed){
        Width = w;
        Height = h;
        this.color=color;
        xoffset*=speed;
        yoffset*=speed;
    }
    public void Move(){
        if(Canrun==true){
            if(head==Carhead.NorthToSouth)
                y +=yoffset;
            if(head==Carhead.SouthToNorth)
                y -= yoffset;
            if(head==Carhead.EastToWest)
                x -= xoffset;
            if(head==Carhead.WestToEast)
                x += xoffset;
        }
    }
    
    public void CollisionDetection(Car a){
//↓
        if(head==Carhead.NorthToSouth){
            if(y+Height<a.y+space){
                xoffset=5;
                yoffset=5;
                Canrun=false;
            }
        }
//↑
        if(head==Carhead.SouthToNorth){
            if(y<a.y+a.getHeight()+space){
                xoffset=5;
                yoffset=5;
                Canrun=false;
            }
        }
//←
        if(head==Carhead.EastToWest){
            if(x<a.x+a.getWidth()+space){
                xoffset=5;
                yoffset=5;
                Canrun=false;
            }
        }
//→
        if(head==Carhead.WestToEast){
            if(x+Width<a.x+space){
                xoffset=5;
                yoffset=5;
                Canrun=false;
            }
        }
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, getWidth(), getHeight());
    }
    public int getWidth() {
        return Width;
    }
    public int getHeight() {
        return Height;
    }
   
}

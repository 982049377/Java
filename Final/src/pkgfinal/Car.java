/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author HP-PC
 */
enum Carhead{
    SouthToNorth,
    EastToWest,
    NorthToSouth,
    WestToEast
}

public class Car {
    private int Width,Height;
    private Color color;
    private int x;
    private int y;
    private int xoffset=5;
    private int yoffset=5;
    private Carhead head;
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
            if(this.getHead()==Carhead.NorthToSouth)
                setY(y + yoffset);
            if(this.getHead()==Carhead.SouthToNorth)
                setY(y - yoffset);
            if(this.getHead()==Carhead.EastToWest)
                setX(x - xoffset);
            if(this.getHead()==Carhead.WestToEast)
                setX(x + xoffset);
        }
    }
    
    public void CollisionDetection(Car a){
//↓
        if(this.getHead()==Carhead.NorthToSouth){
            if(y+Height<a.getY()+space){
                xoffset=5;
                yoffset=5;
                Canrun=false;
            }
        }
//↑
        if(this.getHead()==Carhead.SouthToNorth){
            if(y<a.getY()+a.getHeight()+space){
                xoffset=5;
                yoffset=5;
                Canrun=false;
            }
        }
//←
        if(this.getHead()==Carhead.EastToWest){
            if(x<a.getX()+a.getWidth()+space){
                xoffset=5;
                yoffset=5;
                Canrun=false;
            }
        }
//→
        if(this.getHead()==Carhead.WestToEast){
            if(x+Width<a.getX()+space){
                xoffset=5;
                yoffset=5;
                Canrun=false;
            }
        }
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Carhead getHead() {
        return head;
    }
    public void setHead(Carhead head) {
        this.head = head;
    }
    public int getWidth() {
        return Width;
    }
    public int getHeight() {
        return Height;
    }
   
}

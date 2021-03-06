/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossroadtraffic;

import java.awt.Color;
import java.awt.Graphics;

enum Carhead {
    SouthToNorth,
    EastToWest,
    NorthToSouth,
    WestToEast
}

public class Car {

    public int carid;
    private int Width, Height;
    private Color color;
    public int x, y;
    private int xoffset = 5, yoffset = 5;
    public int road;

    public Carhead head;
    public boolean Canrun = true;
    private final static int space = 50;

    public Car(int w, int h, Color color, float speed, int road, int id) {
        Width = w;
        Height = h;
        this.color = color;
        xoffset *= speed;
        yoffset *= speed;
        this.road = road;
        carid = id;
    }

    public void Move() {
        if (Canrun == true) {
            if (head == Carhead.NorthToSouth) {
                y += yoffset;
//                System.out.println("车辆移动"+y);
//                 System.out.println("yoffset"+yoffset);
            }
            if (head == Carhead.SouthToNorth) {
                y -= yoffset;
            }
            if (head == Carhead.EastToWest) {
                x -= xoffset;
            }
            if (head == Carhead.WestToEast) {
                x += xoffset;
            }
        }

    }

    public void CollisionDetection(Car a) {
//↓
        if (head == Carhead.NorthToSouth) {
            if (a.head == Carhead.NorthToSouth && (a.y < y + Height || y<a.y+a.getHeight())) {
                Canrun = false;
            }
            if (a.head == Carhead.NorthToSouth && y + Height + space > a.y) {
                xoffset = 5;
                yoffset = 5;
                Canrun = a.Canrun;
                System.out.println("↓与同方向前方车碰撞");
            }
            if (a.head == Carhead.NorthToSouth && y < a.y + a.getHeight() + space) {
                a.Canrun = a.Canrun;
                System.out.println("↓与同方向后方车碰撞");
            }
            if (a.head != Carhead.NorthToSouth && y + Height > a.y + space && a.x + a.getHeight() > x && a.x < x + Width) {
                xoffset = 5;
                yoffset = 5;
                Canrun = a.Canrun;
                //System.out.println("y" + y + "Hegight" + Height + "a.y" + a.y);
                System.out.println("↓与其他方向车碰撞");
            }
        }
//↑
        if (head == Carhead.SouthToNorth) {
            if (a.head == Carhead.SouthToNorth && y + space < a.y + a.getHeight()) {
                xoffset = 5;
                yoffset = 5;
                Canrun = a.Canrun;
                System.out.println("↑与同方向前方车碰撞");
            }
            if (a.head == Carhead.SouthToNorth && y + Height + space < a.y) {
                a.Canrun = a.Canrun;
                System.out.println("↑与同方向后方车碰撞");
            }
            if (a.head != Carhead.SouthToNorth && y > a.y + a.getWidth() + space && a.x + a.getHeight() > x && a.x < x + Width) {
                xoffset = 5;
                yoffset = 5;
                Canrun = a.Canrun;
                System.out.println("↑与其他方向车碰撞");
            }
        }
//←
        if (head == Carhead.EastToWest) {
            if (a.head == Carhead.EastToWest && x + space < a.x + a.getHeight()) {
                xoffset = 5;
                yoffset = 5;
                Canrun = a.Canrun;
                System.out.println("←与同方向前方车碰撞");
            }
            if (a.head == Carhead.EastToWest && x + Height + space < a.x) {
                a.Canrun = a.Canrun;
                System.out.println("←与同方向后方车碰撞");
            }
            if (a.head != Carhead.EastToWest && x > a.x + a.getWidth() + space && a.y + a.getHeight() > y && a.y < y + Height) {
                xoffset = 5;
                yoffset = 5;
                Canrun = a.Canrun;
                System.out.println("←与其他方向车碰撞");
            }
        }
//→
        if (head == Carhead.WestToEast) {
             if (a.head == Carhead.WestToEast && (a.x < x + Height || x<a.x+a.getHeight())) {
                Canrun = false;
            }
//            if (x - a.x < Height) {
//                xoffset = 0;
//                yoffset = 0;
//                Canrun = false;
//            }
            if (a.head == Carhead.WestToEast && x + Height + space > a.x) {
                xoffset = 5;
                yoffset = 5;
                Canrun = a.Canrun;
                System.out.println("→与同方向前方车碰撞");
            }
            if (a.head == Carhead.WestToEast && x < a.x + a.getHeight() + space) {
                a.Canrun = a.Canrun;
                System.out.println("→与同方向后方车碰撞");
            }
            if (a.head != Carhead.WestToEast && x + Width > a.x + space && a.y + a.getHeight() > y && a.y < y + Width) {
                xoffset = 5;
                yoffset = 5;
                Canrun = a.Canrun;
                //System.out.println("x + Width " + x + "..." + Width + "a.y + a.getHeight()" + a.y + "..." + a.getHeight() + "a.x" + a.x);
                System.out.println("→与其他方向车碰撞");
            }
        }
    }

    public void draw(Graphics g) {
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

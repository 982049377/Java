/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossroadtraffic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

enum Roadhead {
    SouthToNorth,
    EastToWest,
    NorthToSouth,
    WestToEast
}

public class OneRoad {
    public int x, y;
    private int roadlong;
    public Roadhead head;
    public OneRoad(int x,int y,int roadlong,Roadhead head) {
        this.x=x;
        this.y=y;
        this.roadlong=roadlong;
        this.head=head;
    }
    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        int width = 50;
        switch (head) {
            case NorthToSouth:
                g.fillRect(x, y, width, roadlong);
                //System.out.println("NorthToSouth.width"+width);
                break;
            case SouthToNorth:
                g.fillRect(x, y, width, roadlong);
                //System.out.println("SouthToNorth.width"+width);
                break;
            case EastToWest:
                g.fillRect(x, y, roadlong, width);
                //System.out.println("EastToWest.width"+width);
                break;
            case WestToEast:
                g.fillRect(x, y, roadlong, width);
                //System.out.println("WestToEast.width"+width);
                break;
        }
        //System.out.println("123456");
    }
    public int getroadlong() {
        return roadlong;
    }
    public void setroadlong(int roadlong) {
        this.roadlong = roadlong;
    }
}

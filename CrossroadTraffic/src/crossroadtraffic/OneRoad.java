/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossroadtraffic;

import static crossroadtraffic.CrossroadTraffic.roadside1;
import static crossroadtraffic.CrossroadTraffic.roadside2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

enum Roadhead {
    SouthToNorth,
    EastToWest,
    NorthToSouth,
    WestToEast
}

public class OneRoad {

    private ArrayList<Car> Carlist=new ArrayList<Car>();
    public int x, y;
    private int roadlong;
    public Roadhead head;
    private Timer timer;

    public OneRoad(int x,int y,int roadlong,Roadhead head) {
        this.x=x;
        this.y=y;
        this.roadlong=roadlong;
        this.head=head;
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AutoCarRun();//自动添加车辆
                MoveCar();
                //RemoveCar();
                //this.repaint();
            }
        });
        timer.start();
    }
    public void MoveCar(){
        for(Car i:Carlist){
           i.Move();
        }
    }
  
    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        int width=50;
        switch(head){
            case  NorthToSouth:
                g.fillRect(x, y, width, roadlong);
                //System.out.println("NorthToSouth.width"+width);
                break;
            case  SouthToNorth:
                g.fillRect(x, y, width, roadlong);
                //System.out.println("SouthToNorth.width"+width);
                break;
            case  EastToWest:
                g.fillRect(x, y, roadlong,width);
                //System.out.println("EastToWest.width"+width);
                break;
            case   WestToEast:
                g.fillRect(x, y, roadlong,width);
                //System.out.println("WestToEast.width"+width);
                break;
        }
        for(Car i:Carlist){
                i.draw(g);
                //System.out.println(i.getX());
        }  
    }

    Car lastcar;
    private void AutoCarRun() {
        Random rand = new Random();
        int carwidth = rand.nextInt(10) + 10;
        int carheight = rand.nextInt(20) + 20;
        int speed = rand.nextInt(2) + 2;
        int rgb = rand.nextInt();
        Color color = new Color(rgb);
        Car b = new Car(carheight, carwidth, color, speed);
        int loca = 0;
        switch (head) {
            case WestToEast:
                loca = y;
                //上一辆车的位置
                if (lastcar != null) {
                    if (loca + carheight > lastcar.x + 10) {
                        //System.out.println("不能在Y相同位置添加");
                        return;
                    }
                }
                lastcar = b;
                loca -= carwidth / 2;
                b.y = loca;
                b.head = Carhead.WestToEast;
                break;
            case EastToWest:
                loca = y;
                //上一辆车的位置
                if (lastcar != null) {
                    if (loca < lastcar.x + lastcar.getHeight() + 10) {
                        //System.out.println("不能在Y相同位置添加");
                        return;
                    }
                }
                loca -= carwidth / 2;
                b.y = loca;
                lastcar = b;
                b.head = Carhead.EastToWest;
                break;
            case NorthToSouth://↓
                loca = x;
                //上一辆车的位置
                if (lastcar != null) {
                    if (loca + carheight > lastcar.y + 10) {
                        //System.out.println("不能在Y相同位置添加");
                        return;
                    }
                }
                lastcar = b;
                loca -= carwidth / 2;
                b.x = loca;
                b.head = Carhead.NorthToSouth;
                break;
            case SouthToNorth://↑
                loca = x;
                //上一辆车的位置
                if (lastcar != null) {
                    if (loca < lastcar.y + lastcar.getHeight() + 10) {
                        //System.out.println("不能在Y相同位置添加");
                        return;
                    }
                }
                lastcar = b;
                loca -= carwidth / 2;
                b.x = loca;
                b.head = Carhead.SouthToNorth;
                break;
        }
        Carlist.add(b);
    }

    private void RemoveCar() {
        int c;
        int n = Carlist.size();
        switch (head) {
            case WestToEast://→
                for (c = 0; c < n; c++) {
                    if (Carlist.get(n).x > roadlong) {
                        Carlist.remove(c);
                    }
                }
                break;
            case EastToWest://←
                for (c = 0; c < n; c++) {
                    if (Carlist.get(n).x < 0) {
                        Carlist.remove(c);
                    }
                }
                break;
            case NorthToSouth://↓
                for (c = 0; c < n; c++) {
                    if (Carlist.get(n).y > roadlong) {
                        Carlist.remove(c);
                    }
                }
                break;
            case SouthToNorth://↑
                for (c = 0; c < n; c++) {
                    if (Carlist.get(n).y < 0) {
                        Carlist.remove(c);
                    }
                }
                break;
        }
    }
    public int getroadlong() {
        return roadlong;
    }
    public void setroadlong(int roadlong) {
        this.roadlong =roadlong;
    }
}

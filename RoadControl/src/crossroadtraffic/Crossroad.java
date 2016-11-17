/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossroadtraffic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author HP-PC
 */
public class Crossroad extends JPanel {

    private ArrayList<Car> Carlist;
    public TrafficLight South, East;
    Timer timer;
    private ArrayList<OneRoad> Roadlist = new ArrayList<OneRoad>();
    final static int roadside1 = 150;
    final static int roadside2 = 400;

//    public Crossroad(ArrayList<Car> cl,ArrayList<OneRoad> Rl){
    public Crossroad(ArrayList<OneRoad> Rl) {
        Carlist = new ArrayList<>();
        setLayout(null);
//        Carlist=cl;
        Roadlist = Rl;
        setPreferredSize(new Dimension(400, 100));
        setBackground(Color.LIGHT_GRAY);
        South = new TrafficLight(180, 60);
        East = new TrafficLight(60, 180);
        add(South);
        add(East);
        South.seti(2);
        East.seti(0);
        South.setBounds(140, 400, 180, 60);
        East.setBounds(400, 140, 60, 180);
        int t = 0;
        timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                turn();
            }
        });
        timer.start();
        Timer timer2 = new Timer(1000, (ActionEvent e) -> {
            AutoCarRun();
        });
        timer2.start();
        Timer timer3 = new Timer(50, (ActionEvent e) -> {
            MoveCar();
        });
        timer3.start();
    }

    public void call(ArrayList<OneRoad> Rl) {
        Roadlist.clear();;
        Roadlist = Rl;
    }

    private void AutoCarRun() {
        Random rand = new Random();
        int carwidth = rand.nextInt(10) + 10;
        int carheight = rand.nextInt(20) + 20;
        int speed = rand.nextInt(2);
        int rgb = rand.nextInt();
        Color color = new Color(rgb);
        int index = rand.nextInt(Roadlist.size());
//        if (start[index] == true) {
//            return;
//        }
//        System.out.println(index);
        Car b = null;
        switch (Roadlist.get(index).head) {
            case WestToEast://→
                int loca = Roadlist.get(index).y + carwidth / 2 + 12;
                b = new Car(carheight, carwidth, color, speed);
                b.y = loca;
                b.head = Carhead.WestToEast;
                break;
            case EastToWest://← 
                loca = Roadlist.get(index).y - carwidth / 2 + 12;
                b = new Car(carheight, carwidth, color, speed);
                b.y = loca;
                b.head = Carhead.EastToWest;
                break;
            case NorthToSouth://↓
                loca = Roadlist.get(index).x - carwidth / 2 + 25;
                b = new Car(carwidth, carheight, color, speed);
                b.x = loca;
                b.head = Carhead.NorthToSouth;
                break;
            case SouthToNorth://↑
                loca = Roadlist.get(index).x + carwidth / 2 + 25;
                b = new Car(carwidth, carheight, color, speed);
                b.x = loca;
                b.head = Carhead.SouthToNorth;
                break;
        }
//        start[index] = true;
        Carlist.add(b);
    }

    private void MoveCar() {
        for (Car i : Carlist) {
            switch (i.head) {
                case NorthToSouth:
                    CanCarRun(i, South);

                    break;
                case WestToEast:
                    CanCarRun(i, East);
                    break;
            }
        }
    }

    private void CanCarRun(Car i, TrafficLight light) {
        Car tempcar = new Car(0, 0, Color.red, 0);//前一辆车
        //对所有车辆进行碰撞检测
//        for (Car s : Carlist) {
//            i.CollisionDetection(s);
//        }
        //绿灯或是黄灯移动
        if (light.getI() == 2 || light.getI() == 1) {
            i.Canrun = true;
            i.Move();
        }
        //红灯停止
        if (light.getI() == 0) {
            if (i.head == Carhead.NorthToSouth) {
                if (i.y + i.getHeight() > roadside1) {
                    i.Canrun = true;
                    i.Move();
                    // System.out.println("红灯run");
                }
                if (roadside1 - i.y - i.getHeight() < 10) {
                    i.Canrun = false;;
                    tempcar = i;
                    // System.out.println("红灯第一辆车");
                }
                if (i.y + i.getHeight() < tempcar.y) {
                    i.Move();
                    i.CollisionDetection(tempcar);
                    //tempcar=i;
                    // System.out.println("红灯后面的车");
                }
                if (i.Canrun == false) {
                    tempcar = i;
                }
            }
        }
    }

//    private void RemoveCar() {
//        int c;
//        //int n = Carlist.size();
//        for (c = 0; c < Carlist.size(); c++) {
//            if (c >= Carlist.size()) {
//                c = 0;
//            }
//            if (Carlist.get(c).x > RightPanel.getWidth() || Carlist.get(c).x < 0 || Carlist.get(c).y > RightPanel.getHeight() || Carlist.get(c).y < 0) {
//                Carlist.remove(c);
//            }
//        }
//    } 
//有黄变绿和有黄变红的区别量
    private int su = 1;
//红绿灯的变化

    public void turn() {
        if (su == 0 && South.getI() == 1 && East.getI() == 1) {
            South.seti(2);
            East.seti(0);
            su = 1;
            return;
        }
        if (South.getI() == 2 && East.getI() == 0) {
            South.seti(1);
            East.seti(1);
            return;
        }
        if (South.getI() == 0 && East.getI() == 2) {
            South.seti(1);
            East.seti(1);
            return;
        }
        if (South.getI() == 1 && East.getI() == 1 && su == 1) {
            South.seti(0);
            East.seti(2);
            su = 0;
            return;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(0, 0, 150, 150);
        g.fillRect(400, 0, 600, 150);
        g.fillRect(0, 400, 150, 600);
        g.fillRect(400, 400, 600, 600);
        for (OneRoad i : Roadlist) {
            i.draw(g);
        }
        for (Car i : Carlist) {
            i.draw(g);
        }
//        System.out.println("OneRoadlist.length" + OneRoadlist.size());

    }

}

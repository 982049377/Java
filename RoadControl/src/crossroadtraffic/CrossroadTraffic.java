/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossroadtraffic;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author HP-PC
 */
public final class CrossroadTraffic {

    /**
     * @param args the command line arguments
     */
    JPanel leftPanel;
    JButton thirdrun, thirdstop;
    private ArrayList<Car> Carlist;
    private ArrayList<OneRoad> Roadlist = new ArrayList<>();
    Timer timer;
    Timer timer2;
    Crossroad RightPanel;
    boolean SouthToNorth;
    int WestEastroads = 1, NorthSouthroads = 1;
    JRadioButton WestEastone, WestEasttwo, WestEastthree;
    JRadioButton NorthSouthone, NorthSouthtwo, NorthSouththree;
    final static int roadside1 = 150;
    final static int roadside2 = 400;

    public CrossroadTraffic() {
        Carlist = new ArrayList<>();
        JFrame JF = new JFrame("交通示意图");
        JF.setLayout(new BorderLayout());
        JF.setSize(640, 640);
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3, 1));
        leftPanel.setBackground(Color.yellow);

        JPanel WestEast = new JPanel();
        WestEast.setLayout(new GridLayout(4, 1));
        JLabel WestEasttext = new JLabel("从西向东");
        WestEastone = new JRadioButton("单车道");
        WestEasttwo = new JRadioButton("双车道");
        WestEastthree = new JRadioButton("三车道");
        WestEastChange WestEastlistener = new WestEastChange();
        ButtonGroup WestEastgroup = new ButtonGroup();
        WestEastgroup.add(WestEastone);
        WestEastgroup.add(WestEasttwo);
        WestEastgroup.add(WestEastthree);
        WestEastone.addActionListener(WestEastlistener);
        WestEasttwo.addActionListener(WestEastlistener);
        WestEastthree.addActionListener(WestEastlistener);
        WestEast.add(WestEasttext);
        WestEast.add(WestEastone);
        WestEast.add(WestEasttwo);
        WestEast.add(WestEastthree);
        leftPanel.add(WestEast);

        JPanel NorthSouth = new JPanel();
        NorthSouth.setLayout(new GridLayout(4, 1));
        JLabel NorthSouthtext = new JLabel("从南向北");
        NorthSouthone = new JRadioButton("单车道");
        NorthSouthtwo = new JRadioButton("双车道");
        NorthSouththree = new JRadioButton("三车道");
        NorthSouthChange NorthSouthlistener = new NorthSouthChange();
        ButtonGroup NorthSouthgroup = new ButtonGroup();
        NorthSouthgroup.add(NorthSouthone);
        NorthSouthgroup.add(NorthSouthtwo);
        NorthSouthgroup.add(NorthSouththree);
        NorthSouthone.addActionListener(NorthSouthlistener);
        NorthSouthtwo.addActionListener(NorthSouthlistener);
        NorthSouththree.addActionListener(NorthSouthlistener);
        NorthSouth.add(NorthSouthtext);
        NorthSouth.add(NorthSouthone);
        NorthSouth.add(NorthSouthtwo);
        NorthSouth.add(NorthSouththree);
        leftPanel.add(NorthSouth);

        JPanel third = new JPanel();
        third.setLayout(new GridLayout(3, 1));
        JLabel thirdtest = new JLabel("全局");
        thirdrun = new JButton("Run");
        thirdstop = new JButton("Stop");
        thirdrun.addActionListener(new autoRun());
        thirdstop.addActionListener(new autoStop());
        third.add(thirdtest);
        third.add(thirdrun);
        third.add(thirdstop);
        leftPanel.add(third);

        JF.add(leftPanel, BorderLayout.WEST);
        RightPanel = new Crossroad(Carlist, Roadlist);

        //RightPanel = new Crossroad(Roadlist);
        JF.add(RightPanel, BorderLayout.CENTER);
//        WestToEastadd();
//        NorthToSouthadd();
//        RightPanel.call(Roadlist);
//        RightPanel.repaint();//初始化车道
//检测车辆的碰撞检测       
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AutoCarRun();
                CheckCarRoad();
            }
        });
        timer.start();
        timer2 = new Timer(50, (ActionEvent e) -> {
            RightPanel.call(Roadlist);
            AddCarRoads();//自动添加车道
            MoveCar();
            RightPanel.repaint();
//            for (Car i : Carlist) {
//                for (Car a : Carlist) {
//                    i.CollisionDetection(a);
//                }
//            }
        });
        timer2.start();
        JF.setLocationRelativeTo(null);
        JF.setVisible(true);
    }
    private boolean[] start = {false, false, false, false, false, false};
    private int[] hadcar = {0, 0, 0, 0, 0, 0};
//判断刷新车辆
    private void CheckCarRoad() {
        int n = 0;
        for (int s = 0; s < start.length; s++) {
            for (Car i : Carlist) {
                if (s == i.road) {
                    if (i.carid > n) {
                        n = i.carid;
                        tempcar = i;
                    }
                }
            }
            if (tempcar.head == Carhead.NorthToSouth && tempcar.y > tempcar.getHeight()) {
                start[s] = false;
            }
//             if (tempcar.head==Carhead.SouthToNorth&&tempcar.y>tempcar.getHeight()) {
//                start[s]=false;
//            }
//              if (tempcar.head==Carhead.EastToWest&&tempcar.y>tempcar.getHeight()) {
//                start[s]=false;
//            }
            if (tempcar.head == Carhead.WestToEast && tempcar.x > tempcar.getHeight()) {
                start[s] = false;
            }
        }
    }

//加车
    private void AutoCarRun() {
        Random rand = new Random();
        int carwidth = 30;
        int carheight = 50;
//        int carwidth = rand.nextInt(10) + 10;
//        int carheight = rand.nextInt(20) + 20;
        float speed = (float) (rand.nextFloat() + 0.5);
        int rgb = rand.nextInt();
        Color color = new Color(rgb);
        if (Roadlist.size() == 0) {
            return;
        }
        int index = rand.nextInt(Roadlist.size());
        if (start[index] == true) {
            return;
        }
        System.out.println(index);
        Car b = null;
        hadcar[index] = hadcar[index] + 1;
        switch (Roadlist.get(index).head) {
            case WestToEast://→
                int loca = Roadlist.get(index).y + carwidth / 2 - 5;
                b = new Car(carheight, carwidth, color, speed, index, hadcar[index]);
                b.y = loca;
                b.x = -50;
                b.head = Carhead.WestToEast;
                break;
            case EastToWest://← 
                loca = Roadlist.get(index).y - carwidth / 2 - 5;
                b = new Car(carheight, carwidth, color, speed, index, hadcar[index]);
                b.y = loca;
                b.x = -50;
                b.head = Carhead.EastToWest;
                break;
            case NorthToSouth://↓
                loca = Roadlist.get(index).x - carwidth / 2 + 25;
                b = new Car(carwidth, carheight, color, speed, index, hadcar[index]);
                b.x = loca;
                b.y = -50;
                b.head = Carhead.NorthToSouth;
                break;
            case SouthToNorth://↑
                loca = Roadlist.get(index).x + carwidth / 2 + 25;
                b = new Car(carwidth, carheight, color, speed, index, hadcar[index]);
                b.x = loca;
                b.y = -50;
                b.head = Carhead.SouthToNorth;
                break;
        }
        start[index] = true;
        Carlist.add(b);
        System.out.println("加车");
        System.out.println(hadcar[index]);
    }

    private void MoveCar() {
        for (Car i : Carlist) {
            Car last = null;
            for (Car a : Carlist) {
                if (a.carid > 0) {
                    if (i.road == a.road && i.carid == a.carid - 1) {
                        last = a;
                        System.out.println(a.road + "            " + a.carid);
                        System.out.println(i.road + "            " + i.carid);
                        break;
                    }
                }
            }
            if (last != null) {
                i.CollisionDetection(last);
            }
            switch (i.head) {
                case NorthToSouth:
//                    for (Car c:Carlist){
//                        if(c.road==start[i.road])
//                    }
//                    if (i.y > i.getHeight()) {
//                        start[i.road] = false;
//                    }
                    CanCarRun(i, RightPanel.South);
                    break;
                case WestToEast:
//                    if (i.x > i.getHeight()) {
//                        start[i.road] = false;
//                    }
                    CanCarRun(i, RightPanel.East);
                    break;
            }
        }
    }

    Car tempcar = new Car(0, 0, Color.red, 0, 0, -1);//前一辆车
    Car [] tempcarlist ={tempcar,tempcar,tempcar,tempcar,tempcar,tempcar};
    private void CanCarRun(Car i, TrafficLight light) {
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
                if (roadside1 - i.y - i.getHeight() < 10 && roadside1 - i.y - i.getHeight() > 0) {
                    i.Canrun = false;
                    tempcar = i;
                    i.Move();
//                    System.out.println(tempcar);
                    // System.out.println("红灯第一辆车");
                }
                if (i.y + i.getHeight() + 10 < tempcar.y) {
                    i.Canrun = true;
                    i.Move();
                    // System.out.println("红灯后面的车");
                }
                if (tempcar.y - i.y - i.getHeight() < 10 && tempcar.y - i.y - i.getHeight() > 0) {
                    i.Canrun = false;;
                    tempcar = i;
                    i.Move();
                    // System.out.println("红灯后面的车");
                }
                if (i.Canrun == false) {
                    tempcar = i;
                    i.Move();
                }
            }
        }

        if (light.getI() == 0) {
            if (i.head == Carhead.WestToEast) {
                if (i.x + i.getHeight() > roadside1) {
                    i.Canrun = true;
                    i.Move();
                    // System.out.println("红灯run");
                }
                if (roadside1 - i.x - i.getHeight() < 10 && roadside1 - i.x - i.getHeight() > 0) {
                    i.Canrun = false;
                    tempcar = i;
//                    System.out.println(tempcar);
                    i.Move();
                    // System.out.println("红灯第一辆车");
                }
                if (i.x + i.getHeight() + 30 < tempcar.y) {
                    i.Move();
                    // System.out.println("红灯后面的车");
                }
                if (tempcar.x - i.x - i.getHeight() < 30 && tempcar.x - i.x - i.getHeight() > 0) {
                    i.Canrun = false;;
                    tempcar = i;
                    // System.out.println("红灯后面的车");
                }
                if (i.Canrun == false) {
                    tempcar = i;
                    i.Move();
                }
            }
        }
    }

    private void RemoveCar() {
        int c;
        //int n = Carlist.size();
        for (c = 0; c < Carlist.size(); c++) {
            if (c >= Carlist.size()) {
                c = 0;
            }
            if (Carlist.get(c).x > RightPanel.getWidth() || Carlist.get(c).x < 0 || Carlist.get(c).y > RightPanel.getHeight() || Carlist.get(c).y < 0) {
                Carlist.remove(c);
            }
        }
    }

    private void AddCarRoads() {
        Roadlist.clear();
        for (OneRoad i : WestEastRoadlist) {
            Roadlist.add(i);
        }
        for (OneRoad i : NorthSouthRoadlist) {
            Roadlist.add(i);
        }
        //System.out.println(Roadlist.size());
    }
//增加从西向东的车道
    private final ArrayList<OneRoad> WestEastRoadlist = new ArrayList<>();

    public void WestToEastadd() {
        switch (WestEastroads) {
            case 1:
                int oneloca = (roadside2 - roadside1) / (WestEastroads + 1) * WestEastroads + roadside1 - 25;
                OneRoad one = new OneRoad(0, oneloca, this.RightPanel.getWidth(), Roadhead.WestToEast);
                if (!WestEastRoadlist.isEmpty()) {
                    WestEastRoadlist.clear();
                }
                WestEastRoadlist.add(one);
//                System.out.println("RoadSizeChange1:     "+RoadSizeChange);
                break;
            case 2:
                int twoloca1 = (roadside2 - roadside1) / (WestEastroads + 1) * 1 + roadside1 - 25;
                OneRoad twofirst = new OneRoad(0, twoloca1, this.RightPanel.getWidth(), Roadhead.WestToEast);
                int twoloca2 = (roadside2 - roadside1) / (WestEastroads + 1) * 2 + roadside1 - 25;
                OneRoad twosecond = new OneRoad(0, twoloca2, this.RightPanel.getWidth(), Roadhead.WestToEast);
                WestEastRoadlist.clear();
                WestEastRoadlist.add(twofirst);
                WestEastRoadlist.add(twosecond);
//                System.out.println("RoadSizeChange2:     "+RoadSizeChange);
                break;
            case 3:
                int threeloca1 = (roadside2 - roadside1) / (WestEastroads + 1) * 1 + roadside1 - 25;
                OneRoad threefirst = new OneRoad(0, threeloca1, this.RightPanel.getWidth(), Roadhead.WestToEast);
                int threeloca2 = (roadside2 - roadside1) / (WestEastroads + 1) * 2 + roadside1 - 25;
                OneRoad threesecond = new OneRoad(0, threeloca2, this.RightPanel.getWidth(), Roadhead.WestToEast);
                int threeloca3 = (roadside2 - roadside1) / (WestEastroads + 1) * 3 + roadside1 - 25;
                OneRoad threethird = new OneRoad(0, threeloca3, this.RightPanel.getWidth(), Roadhead.WestToEast);
                WestEastRoadlist.clear();
                WestEastRoadlist.add(threefirst);
                WestEastRoadlist.add(threesecond);
                WestEastRoadlist.add(threethird);
//                System.out.println("RoadSizeChange3:     "+RoadSizeChange);
                break;
            default:
//                System.out.println("RoadSizeChangeINdefault:     "+RoadSizeChange);
                break;
        }
        AddCarRoads();
    }
//增加从北向南的车道
    private final ArrayList<OneRoad> NorthSouthRoadlist = new ArrayList<>();

    public void NorthToSouthadd() {
        switch (NorthSouthroads) {
            case 1:
                int oneloca = (roadside2 - roadside1) / (NorthSouthroads + 1) * NorthSouthroads + roadside1 - 25;
                OneRoad one = new OneRoad(oneloca, 0, this.RightPanel.getHeight(), Roadhead.NorthToSouth);
                if (!NorthSouthRoadlist.isEmpty()) {
                    NorthSouthRoadlist.clear();
                }
                NorthSouthRoadlist.add(one);
                break;
            case 2:
                int twoloca1 = (roadside2 - roadside1) / (NorthSouthroads + 1) * 1 + roadside1 - 25;
                OneRoad twofirst = new OneRoad(twoloca1, 0, this.RightPanel.getHeight(), Roadhead.NorthToSouth);
                int twoloca2 = (roadside2 - roadside1) / (NorthSouthroads + 1) * 2 + roadside1 - 25;
                OneRoad twosecond = new OneRoad(twoloca2, 0, this.RightPanel.getHeight(), Roadhead.NorthToSouth);
                NorthSouthRoadlist.clear();
                NorthSouthRoadlist.add(twofirst);
                NorthSouthRoadlist.add(twosecond);
                break;
            case 3:
                int threeloca1 = (roadside2 - roadside1) / (NorthSouthroads + 1) * 1 + roadside1 - 25;
                OneRoad threefirst = new OneRoad(threeloca1, 0, this.RightPanel.getHeight(), Roadhead.NorthToSouth);
                int threeloca2 = (roadside2 - roadside1) / (NorthSouthroads + 1) * 2 + roadside1 - 25;
                OneRoad threesecond = new OneRoad(threeloca2, 0, this.RightPanel.getHeight(), Roadhead.NorthToSouth);
                int threeloca3 = (roadside2 - roadside1) / (NorthSouthroads + 1) * 3 + roadside1 - 25;
                OneRoad threethird = new OneRoad(threeloca3, 0, this.RightPanel.getHeight(), Roadhead.NorthToSouth);
                NorthSouthRoadlist.clear();
                NorthSouthRoadlist.add(threefirst);
                NorthSouthRoadlist.add(threesecond);
                NorthSouthRoadlist.add(threethird);
                break;
        }
        AddCarRoads();
    }
    private boolean auto = true;

    private class autoRun implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            auto = true;
        }
    }

    private class autoStop implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            auto = false;
        }
    }
//车道控制

    private class WestEastChange implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == WestEastone) {
                WestEastroads = 1;
            }
            if (e.getSource() == WestEasttwo) {
                WestEastroads = 2;
            }
            if (e.getSource() == WestEastthree) {
                WestEastroads = 3;
            }
//            System.out.println("WestToEastClick    RoadSizeChange:     "+RoadSizeChange);
            WestToEastadd();
        }
    }

    private class NorthSouthChange implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == NorthSouthone) {
                NorthSouthroads = 1;
            }
            if (e.getSource() == NorthSouthtwo) {
                NorthSouthroads = 2;
            }
            if (e.getSource() == NorthSouththree) {
                NorthSouthroads = 3;
            }

//            System.out.println("i"+i);
//            System.out.println("NorthSouthroads"+NorthSouthroads);
//            System.out.println("NorthSouthClick    RoadSizeChange:     "+RoadSizeChange);
            NorthToSouthadd();
        }
    }

    public static void main(String[] args) {
        CrossroadTraffic crossroadTraffic = new CrossroadTraffic();
    }
}

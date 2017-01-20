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
public class CrossroadTraffic {

    /**
     * @param args the command line arguments
     */
    JPanel leftPanel;
    JButton thirdrun,thirdstop;
    private ArrayList<Car> Carlist;
    Timer timer;
    Timer timer2;
    Crossroad RightPanel;
    boolean SouthToNorth;
    int WestEastroads=1,NorthSouthroads=1;
    JRadioButton WestEastone,WestEasttwo,WestEastthree;
    JRadioButton NorthSouthone,NorthSouthtwo,NorthSouththree;
    final static int roadside1=150;
    final static int roadside2=400;
    public CrossroadTraffic(){
        Carlist = new ArrayList<Car>();
        JFrame JF=new JFrame("交通示意图");
        JF.setLayout(new BorderLayout());
        JF.setSize(640,640);
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3,1));
        leftPanel.setBackground(Color.yellow);
        
        JPanel WestEast = new JPanel();
        WestEast.setLayout(new GridLayout(4,1));
        JLabel WestEasttext = new JLabel("从西向东");
        WestEastone = new JRadioButton("单车道",true);
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
        NorthSouth.setLayout(new GridLayout(4,1));
        JLabel NorthSouthtext = new JLabel("从南向北");
        NorthSouthone = new JRadioButton("单车道",true);
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
        third.setLayout(new GridLayout(3,1));
        JLabel thirdtest = new JLabel("全局");
        thirdrun = new JButton("Run");
        thirdstop = new JButton("Stop");
        thirdrun.addActionListener(new autoRun());
        thirdstop.addActionListener(new autoStop());
        third.add(thirdtest);
        third.add(thirdrun);
        third.add(thirdstop);
        leftPanel.add(third);
        
        JF.add(leftPanel,BorderLayout.WEST);
        //RightPanel = new Crossroad(Carlist,OneRoadlist);
        RightPanel = new Crossroad(Roadlist);
        JF.add(RightPanel,BorderLayout.CENTER);
//检测车辆的碰撞检测       
//        timer = new Timer(12, new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                MoveCar();
                ///RightPanel.repaint();
//                //RemoveCar();
//                //AutoCarRun();
//                for(Car i:Carlist){
//                    for(Car s:Carlist){
//                        i.CollisionDetection(s);
//                    }
//                }
//            }
//        });
//        timer.start();
        
        timer2 = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //RemoveCar();
                RightPanel.call(Roadlist);
                AutoCarRun();//自动添加车辆
                RightPanel.repaint();
                System.out.println("Roadlist.length"+Roadlist.size());
            }
        });
        timer2.start();
        
        //RemoveCar();
        JF.setLocationRelativeTo(null);
        JF.setVisible(true);
    }
//    private void MoveCar(){
//        for(Car i:Carlist){
//            switch(i.head){
//                case NorthToSouth:
//                    CanCarRun(i,RightPanel.South);           
//                    break;
//                case WestToEast:
//                    CanCarRun(i,RightPanel.East);
//                    break;
//            }
//        }
//    }
//    private ArrayList<Car> tempcar=new ArrayList<Car>();
//    private void CanCarRun(Car i,TrafficLight light){
//        Car tempcar=new Car(0,0,Color.red,0);//前一辆车
//        //对所有车辆进行碰撞检测
//        for(Car s:Carlist){
//            i.CollisionDetection(s);
//        }
//        //绿灯或是黄灯移动
//        if(light.getI()==2||light.getI()==1){
//            i.Canrun=true;
//            i.Move();
//            firstlastcar=null;
//            secondlastcar=null;
//        }
//        //红灯停止
//        if(light.getI()==0){
//            if(i.head==Carhead.NorthToSouth){
//                if(i.y+i.getHeight()>roadside1){
//                    i.Canrun=true;
//                    i.Move();
//                   // System.out.println("红灯run");
//                }
//                if(roadside1-i.y-i.getHeight()<10){
//                   i.Canrun=false;;
//                   tempcar=i;
//                  // System.out.println("红灯第一辆车");
//                }
//                if(i.y+i.getHeight()<tempcar.y){
//                    i.Move();
//                    i.CollisionDetection(tempcar);
//                    //tempcar=i;
//                   // System.out.println("红灯后面的车");
//                }   
//                if(i.Canrun==false){
//                    tempcar=i;
//                }
//            }
//        }
//    }
//    private void RemoveCar(){
//        int c;
//        int n=Carlist.size();
//        for(c=0;c<n;c++){
//            if(Carlist.get(n).x> RightPanel.getWidth()||Carlist.get(n).x<0||Carlist.get(n).y>RightPanel.getHeight()||Carlist.get(n).y<0){
//                Carlist.remove(c);
//            }
//        }
//    }
    private ArrayList<OneRoad> Roadlist=new ArrayList<OneRoad>();
    private void AutoCarRun(){
        if(auto==true){
            Roadlist.clear();;
            WestToEastadd();
            NorthToSouthadd();
            //System.out.println("123456789");
        }
        Roadlist.clear();
        for(OneRoad i : WestEastRoadlist){
            Roadlist.add(i);
        }
         for(OneRoad i : NorthSouthRoadlist){
            Roadlist.add(i);
        }
    }
//增加从西向东的车
    private ArrayList<OneRoad> WestEastRoadlist=new ArrayList<OneRoad>();
    public void WestToEastadd(){
      switch(WestEastroads){
            case 1:
                int oneloca=(roadside2-roadside1)/(NorthSouthroads+1)*NorthSouthroads+roadside1-25;
                OneRoad one=new OneRoad(0,oneloca,this.RightPanel.getWidth(),Roadhead.WestToEast);
                WestEastRoadlist.add(one);
                break;
            case  2:
                int twoloca1=(roadside2-roadside1)/(NorthSouthroads+1)*1+roadside1-25;
                OneRoad twofirst=new OneRoad(0,twoloca1,this.RightPanel.getWidth(),Roadhead.WestToEast);
                int twoloca2=(roadside2-roadside1)/(NorthSouthroads+1)*2+roadside1-25;
                OneRoad twosecond=new OneRoad(0,twoloca2,this.RightPanel.getWidth(),Roadhead.WestToEast);
                WestEastRoadlist.clear();
                WestEastRoadlist.add(twofirst);
                WestEastRoadlist.add(twosecond);
                break;
            case 3:
                int threeloca1=(roadside2-roadside1)/(NorthSouthroads+1)*1+roadside1-25;
                OneRoad threefirst=new OneRoad(0,threeloca1,this.RightPanel.getWidth(),Roadhead.WestToEast);
                int threeloca2=(roadside2-roadside1)/(NorthSouthroads+1)*2+roadside1-25;
                OneRoad threesecond=new OneRoad(0,threeloca2,this.RightPanel.getWidth(),Roadhead.WestToEast);
                int threeloca3=(roadside2-roadside1)/(NorthSouthroads+1)*3+roadside1-25;
                OneRoad threethird=new OneRoad(0,threeloca3,this.RightPanel.getWidth(),Roadhead.WestToEast);
                WestEastRoadlist.clear();
                WestEastRoadlist.add(threefirst);
                WestEastRoadlist.add(threesecond);
                WestEastRoadlist.add(threethird);
                break;
        }
    }
//增加从北向南的车道
    private ArrayList<OneRoad> NorthSouthRoadlist=new ArrayList<OneRoad>();
    public void NorthToSouthadd(){
        switch(NorthSouthroads){
            case 1:
                int oneloca=(roadside2-roadside1)/(NorthSouthroads+1)*NorthSouthroads+roadside1-25;
                OneRoad one=new OneRoad(oneloca,0,this.RightPanel.getHeight(),Roadhead.NorthToSouth);
                NorthSouthRoadlist.add(one);
                break;
            case  2:
                int twoloca1=(roadside2-roadside1)/(NorthSouthroads+1)*1+roadside1-25;
                OneRoad twofirst=new OneRoad(twoloca1,0,this.RightPanel.getHeight(),Roadhead.NorthToSouth);
                int twoloca2=(roadside2-roadside1)/(NorthSouthroads+1)*2+roadside1-25;
                OneRoad twosecond=new OneRoad(twoloca2,0,this.RightPanel.getHeight(),Roadhead.NorthToSouth);
                NorthSouthRoadlist.clear();
                NorthSouthRoadlist.add(twofirst);
                NorthSouthRoadlist.add(twosecond);
                break;
            case 3:
                int threeloca1=(roadside2-roadside1)/(NorthSouthroads+1)*1+roadside1-25;
                OneRoad threefirst=new OneRoad(threeloca1,0,this.RightPanel.getHeight(),Roadhead.NorthToSouth);
                int threeloca2=(roadside2-roadside1)/(NorthSouthroads+1)*2+roadside1-25;
                OneRoad threesecond=new OneRoad(threeloca2,0,this.RightPanel.getHeight(),Roadhead.NorthToSouth);
                int threeloca3=(roadside2-roadside1)/(NorthSouthroads+1)*3+roadside1-25;
                OneRoad threethird=new OneRoad(threeloca3,0,this.RightPanel.getHeight(),Roadhead.NorthToSouth);
                NorthSouthRoadlist.clear();
                NorthSouthRoadlist.add(threefirst);
                NorthSouthRoadlist.add(threesecond);
                NorthSouthRoadlist.add(threethird);
                break;
        }
    }
    private boolean  auto=false;
    private class autoRun implements ActionListener {
       public void actionPerformed(ActionEvent e) {
            auto=true;
            AutoCarRun();
        }
    }    
    private class autoStop implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           auto=false;
           AutoCarRun();
        }
    }
//车道控制
    private class WestEastChange  implements ActionListener{
        public void actionPerformed(ActionEvent e){ 
            if (e.getSource()==WestEastone) 
                WestEastroads=1;
            if (e.getSource()==WestEasttwo)  
                WestEastroads=2;
            if (e.getSource()==WestEastthree) 
                WestEastroads=3;
        }
    }
    private class NorthSouthChange implements ActionListener{
        public void actionPerformed(ActionEvent e){ 
            if (e.getSource()==NorthSouthone) 
                NorthSouthroads=1;
            if (e.getSource()==NorthSouthtwo)  
                NorthSouthroads=2;
            if (e.getSource()==NorthSouththree) 
                NorthSouthroads=3;
        }
    }
    
    
    public static void main(String[] args) {
       new CrossroadTraffic();
    }
}

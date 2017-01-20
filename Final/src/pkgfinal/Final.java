/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

/**
 *
 * @author HP-PC
 */
public class Final {

    /**
     * @param args the command line arguments
     */
    JPanel leftPanel;
    JButton firstAdd,secondAdd,thirdrun,thirdstop;
    private ArrayList<Car> Carlist;
    Timer timer;
    Timer timer2;
    Crossroad RightPanel;
    boolean SouthToNorth;
    int firstroads=1,secondroads=1;
    JRadioButton firstone,firsttwo,firstthree;
    JRadioButton secondone,secondtwo,secondthree;
    final static int roadside1=150;
    final static int roadside2=400;
    public Final(){
        Carlist = new ArrayList<Car>();
        JFrame JF=new JFrame("交通示意图");
        JF.setLayout(new BorderLayout());
        JF.setSize(640,640);
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3,1));
        leftPanel.setBackground(Color.yellow);
        JPanel first = new JPanel();
        first.setLayout(new GridLayout(5,1));
        JLabel firsttext = new JLabel("从西向东");
        firstAdd = new JButton("Add a Car");
        firstone = new JRadioButton("单车道",true);
        firsttwo = new JRadioButton("双车道");
        firstthree = new JRadioButton("三车道");
        firstAdd.addActionListener(new firstal());
        firstChange firstlistener = new firstChange();
        ButtonGroup firstgroup1 = new ButtonGroup(); 
        firstgroup1.add(firstone);    
        firstgroup1.add(firsttwo); 
        firstgroup1.add(firstthree);  
        firstone.addActionListener(firstlistener); 
        firsttwo.addActionListener(firstlistener);
        firstthree.addActionListener(firstlistener); 
        first.add(firsttext);
        first.add(firstAdd);
        first.add(firstone);
        first.add(firsttwo);
        first.add(firstthree);
        leftPanel.add(first);
        
        JPanel second = new JPanel();
        second.setLayout(new GridLayout(5,1));
        JLabel secondtext = new JLabel("从南向北");
        secondAdd = new JButton("Add a Car");
        secondone = new JRadioButton("单车道",true);
        secondtwo = new JRadioButton("双车道");
        secondthree = new JRadioButton("三车道");
        secondAdd.addActionListener(new secondal());
        secondChange secondlistener = new secondChange();
        ButtonGroup secondgroup1 = new ButtonGroup(); 
        secondgroup1.add(secondone);    
        secondgroup1.add(secondtwo); 
        secondgroup1.add(secondthree);  
        secondone.addActionListener(secondlistener); 
        secondtwo.addActionListener(secondlistener);
        secondthree.addActionListener(secondlistener); 
        second.add(secondtext);
        second.add(secondAdd);
        second.add(secondone);
        second.add(secondtwo);
        second.add(secondthree);
        leftPanel.add(second);
        
        JPanel third = new JPanel();
        third.setLayout(new GridLayout(3,1));
        JLabel thirdtest = new JLabel("全局");
        thirdrun = new JButton("Run");
        thirdstop = new JButton("Stop");
        thirdrun.addActionListener(new thirdadd());
        thirdstop.addActionListener(new thirdstop());
        third.add(thirdtest);
        third.add(thirdrun);
        third.add(thirdstop);
        leftPanel.add(third);
        
        JF.add(leftPanel,BorderLayout.WEST);
        RightPanel = new Crossroad(Carlist);
        JF.add(RightPanel,BorderLayout.CENTER);
//检测车辆的碰撞检测       
        timer = new Timer(12, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MoveCar();
                RightPanel.repaint();
                //RemoveCar();
                //AutoCarRun();
                for(Car i:Carlist){
                    for(Car s:Carlist){
                        i.CollisionDetection(s);
                    }
                }
            }
        });
        timer.start();
        
        timer2 = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //RemoveCar();
                AutoCarRun();//自动添加车辆
            }
        });
        timer2.start();
        
        //RemoveCar();
        JF.setLocationRelativeTo(null);
        JF.setVisible(true);
    }
    private void MoveCar(){
        for(Car i:Carlist){
            switch(i.getHead()){
                case NorthToSouth:
                    CanCarRun(i,RightPanel.South);           
                    break;
                case WestToEast:
                    CanCarRun(i,RightPanel.East);
                    break;
            }
        }
    }
    private ArrayList<Car> tempcar=new ArrayList<Car>();
    private void CanCarRun(Car i,TrafficLight light){
        Car tempcar=new Car(0,0,Color.red,0);//前一辆车
        //对所有车辆进行碰撞检测
        for(Car s:Carlist){
            i.CollisionDetection(s);
        }
        //绿灯或是黄灯移动
        if(light.getI()==2||light.getI()==1){
            i.Canrun=true;
            i.Move();
            firstlastcar=null;
            secondlastcar=null;
        }
        //红灯停止
        if(light.getI()==0){
            if(i.getHead()==Carhead.NorthToSouth){
                if(i.getY()+i.getHeight()>roadside1){
                    i.Canrun=true;
                    i.Move();
                   // System.out.println("红灯run");
                }
                if(roadside1-i.getY()-i.getHeight()<10){
                   i.Canrun=false;;
                   tempcar=i;
                  // System.out.println("红灯第一辆车");
                }
                if(i.getY()+i.getHeight()<tempcar.getY()){
                    i.Move();
                    i.CollisionDetection(tempcar);
                    //tempcar=i;
                   // System.out.println("红灯后面的车");
                }   
                if(i.Canrun==false){
                    tempcar=i;
                }
            }
        }
    }
    private void RemoveCar(){
        int c;
        int n=Carlist.size();
        for(c=0;c<n;c++){
            if(Carlist.get(n).getX()> RightPanel.getWidth()||Carlist.get(n).getX()<0||Carlist.get(n).getY()>RightPanel.getHeight()||Carlist.get(n).getY()<0){
                Carlist.remove(c);
            }
        }
    }
    
    private void AutoCarRun(){
        if(auto==true){
            firstadd();
            secondadd();
            //System.out.println("123456789");
        }
        else
            return;
    }
//增加从西向东的车
    Car firstlastcar;
    public void firstadd(){
       
        //int random=((int)Math.random()*20+1);
        //int rgb=((int)Math.random()*20+1);
        Random rand=new Random();
        int width=rand.nextInt(10)+10;
        int height=rand.nextInt(20)+20;
        int speed=rand.nextInt(2)+2;
        int rgb=rand.nextInt();
        Color color=new Color(rgb);
        Car b=new Car(height,width,color,speed);
        //多个跑道
        int x=1;
        if(firstroads>1)
            x=rand.nextInt(firstroads)+1;
        int loca=(roadside2-roadside1)/(firstroads+1)*x+roadside1;
        System.out.println("loca"+loca);
        System.out.println("Lastloca"+firstlastcar);
        //上一辆车的位置
        if(firstlastcar!=null){
            if(loca==firstlastcar.getY()||secondlastcar.getX()<width){
                //System.out.println("不能在Y相同位置添加");
                return;
            }
        }
        firstlastcar=b;
        loca-=width/2;
        b.setY(loca);
        b.setHead(Carhead.WestToEast);
        Carlist.add(b);
        //System.out.println(width+"////"+rgb);
    }
//增加从北向南的车
    Car secondlastcar;
    public void secondadd(){
       
        //int random=((int)Math.random()*20+1);
        //int rgb=((int)Math.random()*20+1);
        Random rand=new Random();
        int width=rand.nextInt(20)+20;
        int height=rand.nextInt(20)+20;
        int speed=rand.nextInt(2)+2;
        int rgb=rand.nextInt();
        Color color=new Color(rgb);
        Car b=new Car(width,height,color,speed);
        int x=1;
        if(secondroads>1)
            x=rand.nextInt(secondroads)+1;
        int loca=(roadside2-roadside1)/(secondroads+1)*x+roadside1;
        // System.out.println("loca"+loca);
        // System.out.println("Lastloca"+secondlastloca);
        if(secondlastcar!=null) 
        {
            if(loca==secondlastcar.getX()||secondlastcar.getY()<height){
            //System.out.println("不能在X相同位置添加");
            return;
            }
        }
        secondlastcar=b;
        loca-=width/2; 
        b.setX(loca);
        b.setHead(Carhead.NorthToSouth);
        Carlist.add(b);
        //System.out.println(width+"////"+rgb);
    }
//移除车辆
    public void remove(){
        Carlist.remove(0);
        Carlist.remove(0);
    }
    private boolean  auto=false;
    private class thirdadd implements ActionListener {
       public void actionPerformed(ActionEvent e) {
            auto=true;
            AutoCarRun();
        }
    }
    
    private class thirdstop implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           auto=false;
           AutoCarRun();
        }
    }
//车道控制
    private class secondChange  implements ActionListener{
        public void actionPerformed(ActionEvent e){ 
            if (e.getSource()==secondone) 
                secondroads=1;
            if (e.getSource()==secondtwo)  
                secondroads=2;
            if (e.getSource()==secondthree) 
                secondroads=3;
        }
    }
    private class firstChange implements ActionListener{
        public void actionPerformed(ActionEvent e){ 
            if (e.getSource()==firstone) 
                firstroads=1;
            if (e.getSource()==firsttwo)  
                firstroads=2;
            if (e.getSource()==firstthree) 
                firstroads=3;
        }
    }
//车辆增加
    private class secondal implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            secondadd();
        }
    }
    private class firstal implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            firstadd();
        }
    }
    public static void main(String[] args) {
       new Final();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import animals.*;
import java.util.ArrayList;
import java.math.*;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.*; 
import java.awt.*;
/**
 *
 * @author HP-PC
 */
public class TestPolymorphism {
    static Random R=new Random();
    public  static int RandInt(int max)
    {
        //int num=(int)(Math.random()*max);
        int num=R.nextInt(max);
        return num;
    }
    
    public  static int RandInt(int min,int max)
    {
        int num=R.nextInt(max-min);
        return num+min;
    }
     public  static boolean randBool() 
    {
        int n=(int)(Math.random()*2);
        switch(n)
        {
            case 0:
                return false;
            case 1:
                return true;
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Animals> Animalist=new ArrayList<Animals>();
        String[] mammalNames = {"Dolphin", "Koala", "Goat", "Kangaroo", "Wallaby"};
        String[] countries = {"Australia", "China", "Finland", "America", "England", "Japan"};
		
        String[] fishNames = {"Tuna", "Salmon", "Nemo", "Shark"};
        boolean[] bonyFish = {true, true, true, false};
		
        String[] birdNames = {"Big bird", "Sunbird", "Crow", "Emu"};
        boolean[] canFly = {false, true, true, false};
        int num=RandInt(10,20);
        for(int n=0;n<num;n++)
        {
             int kind=(int)(Math.random()*3);
             switch(kind)
             {
                 case 0:
                    int mname=RandInt(0,mammalNames.length);
                    int mcountry=RandInt(countries.length);
                    boolean Island=randBool();
                    Animals m=new Mammal(mammalNames[mname],countries[mcountry],Island);
                    Animalist.add(m);
                    break;
                 case 1:
                    int fname=RandInt(0,fishNames.length);
                    int fcountry=RandInt(countries.length);
                    int fbonyfish=RandInt(bonyFish.length);
                    Animals f=new Fish(fishNames[fname],countries[fcountry],bonyFish[fbonyfish]);
                    Animalist.add(f);
                    break;
                 case 2:
                    int bname=RandInt(0,birdNames.length);
                    int bcountry=RandInt(countries.length);
                    int bcanfly=RandInt(canFly.length);
                    Animals b=new Bird(birdNames[bname],countries[bcountry],canFly[bcanfly]);
                    Animalist.add(b);
                    break;
            }
           // System.out.println(Animalist.get(n));
        }
        
        JFrame frame = new JFrame("Animals"); 
        frame.setSize(1280, 960);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
        frame.setLayout(new FlowLayout()); 
        JPanel p=new JPanel(); 
        p.setBackground(Color.yellow);
        p.setPreferredSize(new Dimension(300,600));
        for(Animals a:Animalist)
        {
            p.add(new JLabel(a.toString())); 
        }
        JButton b=new JButton("VISIBLE");
        p.add(b);
        frame.add(p);
        frame.pack();//根据FPanel变换大小
        frame.setVisible(true); 
    }
}

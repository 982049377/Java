/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author HP-PC
 */
public class Crossroad extends JPanel{
    private ArrayList<Car> Carlist;
    public TrafficLight South,East;
    Timer timer;
    public Crossroad(ArrayList<Car> cl){
        setLayout(null);
        Carlist=cl;
        setPreferredSize(new Dimension(400, 100));  
        setBackground(Color.LIGHT_GRAY);
        South=new TrafficLight(180,60);
        East=new TrafficLight(60,180);
        add(South);
        add(East);
        South.seti(2);
        East.seti(0);
        South.setBounds(140, 400, 180, 60);
        East.setBounds(400, 140,60, 180);
        int t=0;
        timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                turn();
                South.repaint();
                East.repaint();
            }
        });
        timer.start();
    }
    private int su=1;
    public void turn(){
        if(su==0 && South.getI()==1 && East.getI()==1)
        {
            South.seti(2);
            East.seti(0);
            su=1;
            return;
        }
        if(South.getI()==2&&East.getI()==0)
        {
            South.seti(1);
            East.seti(1);
            return;
        }
        if(South.getI()==0&&East.getI()==2)
        {
            South.seti(1);
            East.seti(1);
            return;
        }
        if(South.getI()==1&&East.getI()==1&&su==1)
        {
            South.seti(0);
            East.seti(2);
            su=0;
            return;
        }   
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(0, 0, 150,150); 
        g.fillRect(400, 0,600,150);
        g.fillRect(0, 400, 150,600); 
        g.fillRect(400,400,600,600);       
        for(Car i:Carlist){
                i.draw(g);
                //System.out.println(i.getX());
        }  
    }
   
}

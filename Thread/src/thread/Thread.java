/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author HP-PC
 */
public class Thread {
    //JPanel Drawarea=new TestPanel();
    public static void main(String[] args) {
        new Thread();
    }
    
    private  JPanel battonarea;
    private  JPanel Drawarea;
    private ArrayList<Ball> Balllist;
    Timer timer;
    public Thread(){
        Balllist=new ArrayList<Ball>();
        JFrame JF=new JFrame("Thread");
        JF.setLayout(new BorderLayout());
        JF.setSize(300, 300);
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        battonarea=new JPanel();
        JButton add=new JButton("add");
        JButton remove=new JButton("remove");
        add.addActionListener(new al());
        remove.addActionListener(new rl());
        battonarea.add(add);
        battonarea.add(remove);
        JF.add(battonarea,BorderLayout.NORTH);
        
        Drawarea=new TestPanel(Balllist);
        //this.Drawarea=Drawarea;
        JF.add(Drawarea,BorderLayout.CENTER);
        JF.pack();
        JF.setVisible(true);
        JF.setLocationRelativeTo(null);
        timer = new Timer(12, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 for(Ball i:Balllist){
                     i.move();
                     i.Bouned(Drawarea.getWidth(), Drawarea.getHeight());
                }
                Drawarea.repaint();
            }
        });
        timer.start();
    }
    public void add(){
        //int random=((int)Math.random()*20+1);
        //int rgb=((int)Math.random()*20+1);
        Random rand=new Random();
        int random=rand.nextInt(20)+20;
        int rgb=rand.nextInt();
        Color color=new Color(rgb);
        Ball b=new Ball(random,color);
        Balllist.add(b);
        //System.out.println(random+"////"+rgb);
    }
    public void remove(){
        Balllist.remove(0);
    }
    
    private class al implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            add();
        }
    }

    private class rl implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            remove();
        }
    }
    
}

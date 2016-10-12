/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author HP-PC
 */
public class Panel extends JPanel {
    private JTextField txt;
   // private JPanel JPf;
    private JButton judge;
    private int n;
    private JLabel label;
    private int i=(int)(Math.random()*10)+1;
    private JButton JB;
    
    public Panel(){
        //JPf=new JPanel();
        add(new JLabel("从0到10猜数"));
        setBackground(Color.yellow);
        //setLayout(new BorderLayout());
        setLayout(new GridLayout(3,1));
        txt = new JTextField (5);
        txt.addActionListener (new TempListener());  
//        System.out.println("0000n"+n);
        add(txt);
        
        //judge=new PushCounterPanel();
        //judge.setText("判断");   
        //judge.add(new PushCounterPanel(n));
        // add(judge); 
        
        label=new JLabel("-------");
        add(label);
}

    private class TempListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String tempn=txt.getText();
            n = Integer.parseInt (tempn);
            if(n==i)
                label.setText("正确");
            else if(n<i)
                label.setText("猜小了");
            else
                label.setText("猜大了");
            System.out.println("111n"+n);
            // JButton 
        }
    }
  /*  class PushCounterPanel extends JButton{
        public PushCounterPanel() { 
            this.addActionListener (new TempListener());
        }
        private class TempListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) 
            {
                    String tempn=txt.getText();
                  n = Integer.parseInt (tempn);
                 //System.out.println("555n"+n);
                 //System.out.println("i"+i);
                 // System.out.println("22n"+n);
                    if(n==i)
                        label.setText("正确");
                    else if(n<i)
                        label.setText("猜小了");
                    else
                        label.setText("猜大了");
            }
        }
    }*/
}
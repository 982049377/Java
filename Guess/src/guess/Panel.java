/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Scanner;
import javax.swing.*;
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
    private JOptionPane jop;
    public Panel(){
        jop=new JOptionPane();
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
            try{
                String tempn=txt.getText();
                n = Integer.parseInt (tempn);
               // n=Integer.valueOf(txt.getText());
                if(n==i)
                    label.setText("正确");
                else if(n<i)
                    label.setText("猜小了");
                else
                    label.setText("猜大了");
                System.out.println("111n"+n);
                // JButton 
                Checknum();
            }
          
            catch(NumberRangeException ee){ 
                String answerStr=ee.getMessage(); 
                label.setText(answerStr);
                jop.showMessageDialog(null,answerStr);
            } 
             catch(Exception e ){
                String answerStr="输入的必须是数字";
                label.setText(answerStr);
                jop.showMessageDialog(null,answerStr);
            }
        }
         public void Checknum()throws NumberRangeException { 
            if((n<0)||(n>10)){ 
                NumberRangeException ee= new NumberRangeException("第二个输入的数字不在指定的范围！请重新输入."); 
                throw ee; 
            } 
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
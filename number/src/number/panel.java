/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author HP-PC
 */
public class panel extends JPanel{
    private JPanel top;
    private JTextField first;
    private JTextField second;
    private JComboBox combo;
    private JScrollPane under;
    float firstnum;
    float secondnum;
    private JTextArea  result;
    JButton count;
    String fu;
    String []s = {"+", "-", "*","/"};
    
    panel(){
        setLayout(new BorderLayout());
        result=new JTextArea (5,20);
        top=new JPanel();
        under=new JScrollPane(result);
        under.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//一直存在
        top.setLayout(new GridLayout(1,4));
        first=new JTextField(5);
        second=new JTextField(5);
        fu="+";
        
        combo = new JComboBox(s);
        combo.addActionListener(new Change());
        //add(combo); 
        first.addActionListener (new firstListener());
        second.addActionListener (new secondListener());
      
        count=new JButton("计算");
        count.addActionListener (new countListener());
        
        top.add(first);
        top.add(combo);
        top.add(second);
        top.add(count);
        add(top,BorderLayout.NORTH);
        add(under,BorderLayout.CENTER);
  
        // System.out.println(firstnum);
        // System.out.println(secondnum);
        // System.out.println(fu);
    }
    private class countListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            float res;
             switch(fu)
             {
                case "+":
                    res=firstnum+secondnum;
                    result.append(firstnum+fu+secondnum+"="+res+"\n");
                    System.out.println("+"+res);
                    break;
                case "-":
                    res=firstnum-secondnum;
                    result.append(firstnum+fu+secondnum+"="+res+"\n");
                    System.out.println("-"+res);
                    break;
                case "*":
                    res=firstnum*secondnum;
                    result.append(firstnum+fu+secondnum+"="+res+"\n");
                    System.out.println("*"+res);
                    break;
                case "/":
                    res=firstnum/secondnum;
                    result.append(firstnum+fu+secondnum+"="+res+"\n");
                    System.out.println("/"+res);
                    break;     
             }
        }
    }

    private class firstListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            try{
                //firstnum=Integer.valueOf(first.getText());
                firstnum=Float.valueOf(first.getText());
                Checkfirstnum( );
            }
          
            catch(NumberRangeException ee){ 
                String answerStr=ee.getMessage(); 
                result.setText(answerStr);
            }
              catch (Exception e){
                String answerStr="输入的必须是数字,第一个不为数字";
                result.setText(answerStr);
                System.out.println("jianting"+firstnum);
            }
            
        }
        public float Checkfirstnum()throws NumberRangeException { 
            if((firstnum<0)||(firstnum>100)){ 
                NumberRangeException ee= new NumberRangeException("第一个输入的数字不在指定的范围！请重新输入."); 
                throw ee; 
            } 
            return firstnum;
        }

    }
    private class secondListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            try{
                secondnum=Integer.parseInt (second.getText());
                System.out.println("jianting"+secondnum);
                Checksecondnum( );
            }
            
            catch(NumberRangeException ee){ 
                String answerStr=ee.getMessage(); 
                result.setText(answerStr);
            } 
             catch (Exception e){
                String answerStr="输入的必须是数字,第一个不为数字";
                result.setText(answerStr);
                System.out.println("jianting"+firstnum);
            }
        }
         public float Checksecondnum()throws NumberRangeException { 
            if((secondnum<0)||(secondnum>100)){ 
                NumberRangeException ee= new NumberRangeException("第二个输入的数字不在指定的范围！请重新输入."); 
                throw ee; 
            } 
            return secondnum;
        }
    }
    private class Change implements ActionListener{
        public void actionPerformed(ActionEvent e){
            fu = combo.getSelectedItem().toString();
            System.out.println("jianting"+ fu);
        }
    }
}

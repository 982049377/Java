/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_interest_inventory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 *
 * @author HP-PC
 */
public class Panel extends JPanel{
      JTextField firstno;
      JTextField secondname;
      JCheckBox c1,c2,c3,c4,c5;
      JButton confirm,exit;
      String result="";
      String choose="";
      JOptionPane last;
      public Panel() {
          JOptionPane last=new JOptionPane();
          setLayout(new GridLayout(4,1));
          JPanel First=new JPanel();
          JLabel no=new JLabel("学号");
          First.add(no);
          firstno=new JTextField(20);
          firstno.addActionListener(new firstlistener());
          First.add(firstno);
          add(First);
          
          JPanel Second=new JPanel();
          JLabel name=new JLabel("姓名");
          Second.add(name);
          secondname=new JTextField(20);
          secondname.addActionListener(new secondlistener());
          Second.add(secondname);
          add(Second);
          
          c1=new JCheckBox("长跑");
          c2=new JCheckBox("短跑");
          c3=new JCheckBox("跳远");
          c4=new JCheckBox("跳高");
          c5=new JCheckBox("投掷");
          JPanel Third=new JPanel();
          Third.add(c1);
          Third.add(c2);
          Third.add(c3);
          Third.add(c4);
          Third.add(c5);
          Change listener = new Change();
          c1.addItemListener(listener); 
          c2.addItemListener(listener);
          c3.addItemListener(listener); 
          c4.addItemListener(listener);  
          c5.addItemListener(listener); 
            
          add(Third);
          
          JPanel Fouth=new JPanel();
          confirm=new JButton("确定");
          confirm.addActionListener(new confirmlistener());
          exit=new JButton("退出");
          exit.addActionListener(new exitlistener());
          Fouth.add(confirm);
          Fouth.add(exit);
          add(Fouth);
      }

    private static class exitlistener implements ActionListener {

        public void actionPerformed(ActionEvent event) { 
          System.exit(0);
        }
    }

    private class confirmlistener implements ActionListener {
       public void actionPerformed(ActionEvent event) { 
          last.showMessageDialog(null , result+choose);
          //result="";
          choose="";
       }
    }

    private class secondlistener implements ActionListener {

         public void actionPerformed(ActionEvent event) { 
            result+=secondname.getText();
            //result+=s;
        }
    }
    private class firstlistener implements ActionListener {

        public void actionPerformed(ActionEvent event) { 
            result+=firstno.getText();
            //result+=s;
        }
    }
    private class Change  implements ItemListener{

       public void itemStateChanged(ItemEvent e){
           if (c1.isSelected())
               choose+="长跑";
           if (c2.isSelected())
               choose+="短跑";
           if (c3.isSelected())
               choose+="跳远";
           if (c4.isSelected())
               choose+="跳高";
           if (c5.isSelected())
               choose+="投掷";
       }
    }
}

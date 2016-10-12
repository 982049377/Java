/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author HP-PC
 */
public class RadiobuttonTest extends JPanel{
        JLabel l;
        JRadioButton r1,r2,r3;
        public RadiobuttonTest() {
        setBorder(BorderFactory.createTitledBorder(
        " 您最喜欢 哪一 家速食店呢 ？"));
        r1 = new JRadioButton(" 麦当劳",true);
        r2 = new JRadioButton(" 肯德基");
        r3 = new JRadioButton(" 必胜客 ");
        l = new JLabel("I Like  麦当劳");
        Change listener=new Change();
        r1.addActionListener(listener);
        r2.addActionListener(listener);
        r3.addActionListener(listener);
        add(r1); add(r2);
        add(r3); add(l);
        ButtonGroup bgroup1 = new ButtonGroup();
        bgroup1.add(r1); bgroup1.add(r2);
        bgroup1.add(r3);
        }
        private class Change implements ActionListener{
        public void actionPerformed(ActionEvent e){
        if (e.getSource() == r1)
            l.setText("I Like  麦当劳 " );
        else if (e.getSource() == r2)
            l.setText( "I Like 肯德基" );
        else
            l.setText("I Like  必胜客");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author HP-PC
 */
public class PushCounterPanel extends JPanel{
    private int count;
    private JLabel label;
    private JButton LJB;
    private JButton RJB;
    public PushCounterPanel() {
        count = 0; ;
        LJB = new JButton ("增大");
        RJB = new JButton ("减小");
        LJB.addActionListener (new B_ButtonListener());
        RJB.addActionListener (new S_ButtonListener());
        label = new JLabel ("Pushes: " + count);
        add (LJB);
        add (label);
        add (RJB);
        setPreferredSize (new Dimension(300, 40));
        setBackground (Color.cyan);
    }

    private class S_ButtonListener implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e){
        count--;
        label.setText("Pushes: " + count);
        }
    }
    private class B_ButtonListener implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
        count++;
        label.setText("Pushes: " + count);
        }
    }   
}

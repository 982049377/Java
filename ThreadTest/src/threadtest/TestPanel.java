/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author HP-PC
 */
public class TestPanel extends JPanel implements ActionListener{
    Timer timer;
    int hour = 0;
    int minute = 0;
    int second = 0;
    String time;
    JLabel timeLabel;
    JButton play;
    public TestPanel() {
        setPreferredSize(new Dimension(300, 200));
        setLayout(new BorderLayout());
        JPanel p = new JPanel();
        timeLabel = new JLabel("00:00:00");
        Font f = new Font("黑体", 1, 50);
        timeLabel.setFont(f);
        p.add(timeLabel);

        add(p, BorderLayout.CENTER);
        play = new JButton("PLAY");
        play.addActionListener(this);
        add(play, BorderLayout.SOUTH);
         timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                time = "";
                second++;
                if (second == 60) {
                    minute++;
                    second = 0;
                }
                if (minute == 60) {
                    hour++;
                    minute = 0;
                }
                if (hour == 24) {
                    hour = 0;
                }
                if (hour < 10) {
                    time = time + "0" + hour + ":";
                } else {
                    time = time + hour + ":";
                }
                if (minute < 10) {
                    time = time + "0" + minute + ":";
                } else {
                    time = time + minute + ":";
                }
                if (second < 10) {
                    time = time + "0" + second;
                } else {
                    time = time + second;
                }
                timeLabel.setText(time);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        timer.start();//开始计时
    }



}

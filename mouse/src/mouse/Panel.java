/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Panel extends JPanel {

    JLabel label;
    String nameField = new String("Hello,14081202王恒尊");
    JPanel top;
    JButton red_button;
    JButton green_button;
    JPanel Down;
    JPanel center;
    JButton Retangle;
    JButton name;
    Color k;
    int x;
    int y;
    int Status = 1;
    Point start, end;
    ArrayList<Point> line = new ArrayList<>();

    public Panel() {
        setLayout(null);

        start = new Point();
        end = new Point();
        top = new JPanel();
        top.setLayout(new GridLayout(1, 2));

        red_button = new JButton("red");
        green_button = new JButton("green");
        red_button.addActionListener(new redl());
        green_button.addActionListener(new greenl());

        ButtonGroup topBG = new ButtonGroup();
        topBG.add(red_button);
        topBG.add(green_button);

        top.add(red_button);
        top.add(green_button);

        top.setBounds(0, 0, 500, 20);
        add(top);

        Down = new JPanel();
        Down.setLayout(new GridLayout(1, 3));
        label = new JLabel("start");
        Down.add(label);

        Retangle = new JButton("矩形");
        name = new JButton("显示姓名学号");
        name.addActionListener(new namel());
        Retangle.addActionListener(new Retanglel());

        ButtonGroup DownBG = new ButtonGroup();
        DownBG.add(red_button);
        DownBG.add(green_button);

        Down.add(Retangle);
        Down.add(name);
        Down.setBounds(0, 680, 500, 20);
        add(Down, BorderLayout.SOUTH);

        k = Color.red;
        red_button.setEnabled(false);
        Retangle.setEnabled(false);
        //   center = new JPanel();
        //  center.setLayout(null);
        //  add(center);
        addMouseListener(new MouseChange());
        addMouseMotionListener(new MousePosition());
    }

    private class Retanglel implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            Status = 0;
            Retangle.setEnabled(false);
            name.setEnabled(true);
        }
    }

    private class namel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Status = 1;
            Retangle.setEnabled(true);
            name.setEnabled(false);
        }
    }

    private class MousePosition implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent me) {
            //Label=Mouse;
            end.setX(me.getX());
            end.setY(me.getY());
            line.add(end);
            repaint();
            //System.out.println(end.getX() + "  " + end.getY()+ "***********"+ line.size());
        }

        @Override
        public void mouseMoved(MouseEvent me) {
            x = me.getX();
            y = me.getY();
            label.setText("x:" + x + "y:" + y);
        }
    }

    private class redl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            k = Color.red;
            red_button.setEnabled(false);
            green_button.setEnabled(true);
        }
    }

    private class greenl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            k = Color.green;
            red_button.setEnabled(true);
            green_button.setEnabled(false);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(k);
        if (Status == 0) {
            //g.fillRect(X1,Y1,X2-X1,Y2-Y1);
            g.drawRect(start.getX(), start.getY(), end.getX() - start.getX(), end.getY() - start.getY());

        }
        if (Status == 1) {
            //  Point stop=new Point(-1,-1);
            for (int i = 0; i <= line.size() - 2; i++) {
                
                if (line.get(i + 1).getX() == -1 && line.get(i + 1).getY() == -1) {
                    // System.out.println("zradjaskdja");
                    i = i + 2;
                    start =new Point();
                    end = new Point();
                } //else {
                
                    start = line.get(i);
                    end = line.get(i + 1);
                   // System.out.println(start.getX()+"%%%" + start.getY());
                   // System.out.println(end.getX()+"###" + end.getY());
                    g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
               // }
            }
        } else {
            g.drawString(nameField, start.getX(), start.getY());
        }
       end = new Point();
    }

    private class MouseChange implements MouseListener {

        public void mousePressed(MouseEvent e) {
            start.setX(e.getX());
            start.setY(e.getY());
            end = start;//画线必须有的
            start = end;
            // System.out.println(1);
            //repaint();
            line.add(end);
        }

        public void mouseReleased(MouseEvent e) {
            //label.setText( "您已经放开鼠标按钮" );
            line.add(new Point(-1, -1));
            //System.out.println("asjdklajsda");
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
            //end=new Point();
        }
    }
}

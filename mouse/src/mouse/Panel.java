/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse;
import java.awt.*;
import java.awt.event.* ;
import javax.swing.*;
public class Panel extends JPanel
{
    JLabel label;
    String nameField = new String("Hello,14081202王恒尊");
    JPanel top;
    JButton red;
    JButton green;
    JPanel Down;
    JPanel center;
    JButton Retangle;
    JButton name;
    Color k;
    int x;
    int y;
    int Status=0;
    int X1,X2,Y1,Y2;
    public Panel(){
        setLayout(null);

        top = new JPanel();
        top.setLayout(new GridLayout(1,2));

        red = new JButton("red");
        green = new JButton("grees");
        red.addActionListener(new redl());
        green.addActionListener(new greenl());
        
        ButtonGroup topBG = new ButtonGroup();
        topBG.add(red);
        topBG.add(green);

        top.add(red);
        top.add(green);

        top.setBounds(0,0,500,20);
        add(top);
        
        Down = new JPanel();
        Down.setLayout(new GridLayout(1,3));
        label = new JLabel("start");
        Down.add(label);
        
        Retangle = new JButton("矩形");
        name = new JButton("显示姓名学号");
        name.addActionListener(new namel());
        Retangle.addActionListener(new Retanglel());
        
        ButtonGroup DownBG = new ButtonGroup();
        DownBG.add(red);
        DownBG.add(green);
        
        Down.add(Retangle);
        Down.add(name);
        Down.setBounds(0,680,500,20);
        add(Down,BorderLayout.SOUTH);
        k=Color.red;
     //   center = new JPanel();
      //  center.setLayout(null);
      //  add(center);
        addMouseListener(new MouseChange());
        addMouseMotionListener(new MousePosition());
    }

    private class Retanglel  implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            Status=0;
        }   
    }

    private class namel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Status=1;
        }
    }

    private class MousePosition implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent me) {
           //Label=Mouse;
            X2=me.getX();
            Y2=me.getY();
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent me) {
            x=me.getX();
            y=me.getY();
            label.setText("x:"+x+"y:"+y);
        }
    }

    private class redl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            k=Color.red;
        }
    }

    private class greenl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
             k=Color.green;
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(k);
        if(Status==0)  
            //g.fillRect(X1,Y1,X2-X1,Y2-Y1);
            g.drawRect(X1,Y1,X2-X1,Y2-Y1);
        else
            g.drawString(nameField, X1,Y1);
        X2=0;
        Y2=0;
    }
    private class MouseChange implements MouseListener{
        public void mousePressed(MouseEvent e) {
            X1=e.getX();
            Y1=e.getY();
            //System.out.println(x+"0000"+y);
            repaint();
            
        }
        public void mouseReleased(MouseEvent e) {
            //label.setText( "您已经放开鼠标按钮" );
          
        }
        public void mouseEntered(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
        }
        public void mouseClicked(MouseEvent e) {
        }
    }
}
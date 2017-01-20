/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;
import java.awt.*;    
import java.util.*;    
import javax.swing.*;    
/**  
 * 2012.4.4  
 * @author Administrator  
 * zwyjg@163.com  
 */    
public class Hufan extends JFrame{    
    public  static HuPanel hp;    
    public  static Hufan hu;    
    public static void main(String[] args) {    
        hu=new Hufan();    
    }    
    public Hufan(){    
        hp=new HuPanel();    
        this.add(hp);    
        Thread t=new Thread(new Light());    
        t.start();    
        this.setTitle("模拟交通灯");    
        this.setSize(400, 400);    
        this.setLocation(300, 200);    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        this.setVisible(true);    
    }    
}    
class HuPanel extends JPanel implements Runnable{    
    Vector<Car> arrCar=new Vector<Car>();//放车对象     
    Vector<Light> arrLight=new Vector<Light>();//放车对象     
    public HuPanel(){    
        Thread t=new Thread(this);    
        t.start();    
        arrLight.add(new Light(150,150,0));    
        arrLight.add(new Light(150,215,1));    
        arrLight.add(new Light(215,235,2));    
        arrLight.add(new Light(235,150,3));    
    }    
    public void paint(Graphics g){    
        super.paint(g);    
        g.setColor(Color.darkGray);    
        g.fillRect(0, 150, 400, 4);    
        g.fillRect(0, 250, 400, 4);    
        g.fillRect(150, 0, 4, 400);    
        g.fillRect(250, 0, 4, 400);    
        g.setColor(Color.gray);    
        g.fillRect(0, 200, 400, 2);    
        g.fillRect(200, 0, 2, 400);    
        g.setColor(Color.blue);    
        for(int i=0;i<arrCar.size();i++){//画车     
            if(arrCar.get(i).direct%2==0){    
                g.fillRect(arrCar.get(i).x, arrCar.get(i).y, 20, 35);    
            }else{    
                g.fillRect(arrCar.get(i).x, arrCar.get(i).y, 35, 20);    
            }    
        }    
        for(int i=0;i<arrLight.size();i++){//画灯     
            Light light=arrLight.get(i);    
            g.setColor(Color.black);    
            if(light.direct%2==0){    
                g.fillRect(light.x, light.y, 35, 15);    
            }else{    
                g.fillRect(light.x, light.y, 15, 35);    
            }    
            g.setColor(Color.green);    
            if(light.greenLight==true){    
                if(light.direct%2==0){    
                    g.fillOval(light.x, light.y+2, 10, 10);    
                }else{    
                    g.fillOval(light.x+2, light.y, 10   , 10);    
                }    
            }    
            g.setColor(Color.red);    
            if(light.redLight==true){    
                if(light.direct%2==0){    
                    g.fillOval(light.x+20, light.y+2, 10, 10);    
                }else{    
                    g.fillOval(light.x+2, light.y+20, 10    , 10);    
                }    
            }    
        }    
    }    
    public synchronized void run() {    
        Car car=null;    
        while(true){    
            Random r=new Random();    
            int direct=r.nextInt(4);//随机0-3的车的方向     
            switch(direct){    
            case 0:    
                car = new Car(170, -35, 0);    
                arrCar.add(car);    
                break;    
            case 1:    
                car = new Car(-35, 220, 1);    
                arrCar.add(car);    
                break;    
            case 2:    
                car = new Car(220, 355, 2);    
                arrCar.add(car);    
                break;    
            case 3:    
                car = new Car(355, 170, 3);    
                arrCar.add(car);    
                break;    
            }    
            Thread t = new Thread(car);    
            t.start();    
            try {    
                Thread.sleep(700);    
            } catch (InterruptedException e) {    
                // TODO Auto-generated catch block     
                e.printStackTrace();    
            }    
        }    
    }    
}    
class Car implements Runnable{    
    int x;//x坐标     
    int y;//y坐标     
    int direct;//方向  0:向下 1:向右 2:向上 3:向左     
    int speed=10;//速度     
    boolean stopCar=true;//是否停车     
    boolean stopThread;  
    public Car(int x,int y,int direct){    
        this.x=x;    
        this.y=y;    
        this.direct=direct;    
    }    
    //判断车碰灯，边界     
    public void panDuan(int x,int y,int direct){    
        if(x<0||x>400||y<0||y>400){// 碰到边界，从arrAcr删除     
            Hufan.hp.arrCar.remove(this);   
            stopThread=true;  
        }    
        //是否碰到灯     
        for(int i=0;i<Hufan.hp.arrLight.size();i++){    
            Light light=Hufan.hp.arrLight.get(i);    
            if(direct%2==0){    
                if(x>=light.x&&x<=light.x+50&&y>=light.y&&y<=light.y+15){    
                    if(light.redLight==true&&light.direct==direct){    
                        stopCar=false;    
                    }else{    
                        stopCar=true;    
                    }    
                }    
            }else{    
                if(x>=light.x&&x<=light.x+15&&y>=light.y&&y<=light.y+50){    
                    if(light.redLight==true&&light.direct==direct){    
                        stopCar=false;    
                    }else{    
                        stopCar=true;    
                    }    
                }    
            }    
        }    
        //车碰车     
        for(int i=0;i<Hufan.hp.arrCar.size();i++){    
            Car car=Hufan.hp.arrCar.get(i);    
            if(direct%2==0){    
                if(x>=car.x&&x<=car.x+20&&y>=car.y&&y<=car.y+35){    
                    if(car.stopCar==false){    
                        stopCar=false;    
                    }else{    
                        stopCar=true;    
                    }    
                }    
            }else{    
                if(x>=car.x&&x<=car.x+35&&y>=car.y&&y<=car.y+20){    
                    if(car.stopCar==false){    
                        stopCar=false;    
                    }else{    
                        stopCar=true;    
                    }    
                }    
            }    
        }    
    }    
    public synchronized void run() {    
        while(true){    
            switch(direct){    
            case 0:    
                if (stopCar) {    
                    y += speed;    
                }    
                this.panDuan(x, y+35, direct);    
                break;    
            case 1:    
                if(stopCar){    
                    x+=speed;    
                }    
                this.panDuan(x+35, y, direct);    
                break;    
            case 2:    
                if(stopCar){    
                    y-=speed;    
                }    
                this.panDuan(x, y, direct);    
                break;    
            case 3:    
                if(stopCar){    
                    x-=speed;    
                }    
                this.panDuan(x, y, direct);    
                break;    
            }    
            if(stopThread){  
                break;  
            }  
            Hufan.hp.repaint();//刷新JPanel     
            try {    
                Thread.sleep(50);    
            } catch (InterruptedException e) {    
                // TODO Auto-generated catch block     
                e.printStackTrace();    
            }    
        }    
    }    
}    
class Light implements Runnable{    
    int x;//x坐标     
    int y;//y坐标     
    boolean redLight;//红灯     
    boolean greenLight;//绿灯     
    int direct;//所在方位  0:上 1:左 2:下 3:右     
    public Light(int x,int y,int direct){    
        this.x=x;    
        this.y=y;    
        this.direct=direct;    
    }    
    public Light(){}    
    public synchronized void run() {    
        int direct=0;    
        //判断是否亮灯     
        while(true){    
            for(int i=0;i<Hufan.hp.arrLight.size();i++){    
                Light light=Hufan.hp.arrLight.get(i);    
                if(direct%2==0){    
                    if(light.direct%2==0){    
                        light.greenLight=true;    
                        light.redLight=false;    
                    }else{    
                        light.greenLight=false;    
                        light.redLight=true;    
                    }    
                }else{    
                    if(light.direct%2==0){    
                        light.greenLight=false;    
                        light.redLight=true;    
                    }else{    
                        light.greenLight=true;    
                        light.redLight=false;    
                    }    
                }    
            }    
            direct++;    
            try {    
                Thread.sleep(3000);    
            } catch (InterruptedException e) {    
                // TODO Auto-generated catch block     
                e.printStackTrace();    
            }    
        }    
    }    
}   
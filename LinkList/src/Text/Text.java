/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Text;
import linklist.*;
import People.*;
import java.util.Scanner;
/**
 *
 * @author HP-PC
 */
public class Text {
    public static int Order()
    {  
        Scanner scan=new Scanner(System.in);
        System.out.println("录入信息请按1");
        System.out.println("删除信息请按2");
        System.out.println("修改信息请按3");
        System.out.println("查找信息请按4");
        System.out.println("退出目录请按5");
        int i=scan.nextInt();
        return i;
    }
    public static Teacher addteacher()
    {
        Scanner scan=new Scanner(System.in);
        System.out.print("name:");
        String tname=scan.next();
        System.out.print("ID:");
        int tId=scan.nextInt();
        System.out.print("School:");
        String tschool=scan.next();
        Teacher teac=new Teacher(tname,tId,tschool);
        return teac;
    }
    
    public static Student addStudent()
    {
        Scanner scan=new Scanner(System.in);
        System.out.print("name:");
        String sname=scan.next();
        System.out.print("ID:");
        int sId=scan.nextInt();
        System.out.print("age:");
        int sage=scan.nextInt();
        Student stu=new Student(sname,sId,sage);
        return stu;
    }
    
    
    public static void main(String[] args) {
        Link l=new Link();
        l.add(1);
        l.Output();
        System.out.println();
        l.add(2);
        l.Output();
        System.out.println();
        l.add(3);
        l.Output();
        System.out.println();
        l.Correct(3, 4);
        l.Output();
        System.out.println();
        l.del(2);
        l.Output();
        System.out.println();
        l.geti(1);
        System.out.println(l.geti(1));
        
        Link1<Student> s=new Link1<Student>();
        Link1<Teacher> t=new Link1<Teacher>();
        Scanner scan=new Scanner(System.in);
        int i=0;
        while(i==5)
        {
            i=Order();
            switch(i)
            {
                case 1:
                    System.out.println("录入老师信息请按1");
                    System.out.println("录入学生信息请按2");
                    int a=scan.nextInt();
                    if(a==1)
                    {
                        t.add(addteacher());
                    }
                    else
                    {
                        s.add(addStudent());
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;     
            }
        }
        
    }
}

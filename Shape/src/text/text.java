/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;
import shape.*;
import java.util.*;
/**
 *
 * @author HP-PC
 */
public class text {
     public static void main(String[] args) {
         Shape []s=new Shape[3];
         s[0]=new Rectangle(2,4);
         s[1]=new Triangle(3,4,5);
         s[2]=new Circle(3.0);
         float Perimeter=0;
         for(Shape a:s)
         {
             Perimeter +=a.Perimeter();
         }
         System.out.println(Perimeter);
    }
}

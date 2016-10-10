/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

/**
 *
 * @author HP-PC
 */
public class Rectangle extends Shape {
    private double x,y;
    public Rectangle(double a,double b)  { x = a;  y = b; } 
    public double calcArea( ){ return x * y; }
    public double Perimeter() {
        return (x+y)*2;
    }

}

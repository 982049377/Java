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
public class Circle extends Shape{
    private double r; 
    public Circle(double a)  { r = a; }
    public double calcArea( ){ return r * r * 3.14; }

    @Override
    public double Perimeter() {
        return 2*3.14*r;
    }

}

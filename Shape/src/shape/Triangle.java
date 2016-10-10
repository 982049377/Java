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
public class Triangle extends Shape{
    float firstedge;
    float secondedge;
    float thirdedge;
    public Triangle(float f,float s,float t)
    {
        firstedge=f;
        secondedge=s;
        thirdedge=t;
    }
    @Override
    public double Perimeter() {
        return firstedge+secondedge+thirdedge;
    }

    @Override
    public double calcArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

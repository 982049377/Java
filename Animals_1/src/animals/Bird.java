/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

/**
 *
 * @author HP-PC
 */
public class Bird extends Animals{
    private boolean CanFly;
    public Bird(String name, String cy,boolean fly) {
        super(name, cy);
        CanFly=fly;
    }
    public boolean GetCanFly() {
        return CanFly;
    }
    public void setLand(boolean bony) {
        this.CanFly = bony;
    }
    @Override
    public String toString()
    {
        if(CanFly==true)
        {
           return(super.toString()+"[Can fly]");
        }
        else
           return(super.toString()+"[Would be awesome if it could fly]");
        
    }
}

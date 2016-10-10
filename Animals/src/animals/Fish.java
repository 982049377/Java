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
public class Fish extends Animals{
    private boolean BonySkeleton;
    public Fish(String name, String cy,boolean bony) {
        super(name, cy);
        BonySkeleton=bony;
    }
    public boolean GetBonySkeleton() {
        return BonySkeleton;
    }
    public void setLand(boolean bony) {
        this.BonySkeleton = bony;
    }
    @Override
    public String toString()
    {
        if(BonySkeleton==true)
        {
           return(super.toString()+"[Bony]");
        }
        else
           return(super.toString()+"[Not-bony]");
        
    }
}

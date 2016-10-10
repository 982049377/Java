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
public class Mammal extends Animals{
    private boolean land;
    public Mammal(String name, String cy,boolean lan) {
        super(name, cy);
        land=lan;
    }
    public boolean GetisLand() {
        return land;
    }
    public void setLand(boolean land) {
        this.land = land;
    }
    @Override
    public String toString()
    {
        if(land==true)
        {
           return(super.toString()+"[Land-dwelling]");
        }
        else
           return(super.toString()+"[Water-dwelling]");
        
    }
    
}
/**super  1 调父类重名的方法时，  
 *        2 调用父类的构造方法  */
/**this   1 传参和形参相同时，this.name=name
 *        2 调用另一个构造方法  */
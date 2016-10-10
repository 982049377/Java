/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package People;

/**
 *
 * @author HP-PC
 */
public class Teacher {
    private String name;
    private int ID;
    private String School;
    public Teacher(){}
    public Teacher(String n,int i,String s)
    {
        name=n;
        ID=i;
        School=s;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getSchool() {
        return School;
    }
    public void setSchool(String School) {
        this.School = School;
    }
    public String toString()
    {
        return "name:"+name+"    ID:"+ID+"   school:"+School;
    }
}

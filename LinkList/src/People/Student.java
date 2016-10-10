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
public class Student {
    private String name;
    private int ID;
    private int Age;
    public Student(){}
    public Student(String n,int i,int a)
    {
        name=n;
        ID=i;
        Age=a;
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
    public int getAge() {
        return Age;
    }
    public void setAge(int Age) {
        this.Age = Age;
    }
    public String toString()
    {
        return "name:"+name+"    age"+Age+"    ID"+ID;
    }
    public boolean Equal()
    {
        if(true)
        {return true;}
        return false;
    }
}

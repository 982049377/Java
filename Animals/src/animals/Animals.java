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
public class Animals
{
    protected String commonName;
    protected String country;
    public Animals(String name,String cy)
    {
        commonName=name;
        country=cy;
    }
    public String getCommonName() {
        return commonName;
    }
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String toString()
    {
        return commonName+" ("+country+")";
    }

}


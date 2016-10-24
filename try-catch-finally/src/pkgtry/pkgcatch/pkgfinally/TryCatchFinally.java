/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtry.pkgcatch.pkgfinally;

/**
 *
 * @author HP-PC
 */
public class TryCatchFinally {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*int m=3,n=0;
        try{
            System.out.println(m/n);
        }
        catch(ArithmeticException e){
            System.out.println("\t捕获异常："+e.getMessage());
        }
        catch(Exception e){
            System.out.println("\t捕获异常1："+e.getMessage());
        }
        System.out.println("OK");
        */
       
        int m = 3,n = 0; 
        try { test(m,n);            } 
        catch( ArithmeticException e ){ 
            System.out.println("\t捕获异常： "+e.getMessage());
        } 
        System.out.println("OK"); 
     
      /*  int a[] = new int[10]; 
        int s = 0; 
        for (int k = 0; k < 10; ++k) { 
            a[k] = k; 
        } 
        try { 
            for (int j = 0; j < 10; ++j) {
                s = s + a[j + 1] / a[j];
            } 
            System.out.print("No exception");
        } 
        catch (ArrayIndexOutOfBoundsException e1) {
            System.out.print("Exception 1"); 
        } 
        catch (Exception e2) { 
            System.out.print("Exception 2"); 
        }*/
    }
    public static void test(int a,int b) throws ArithmeticException{   
        System.out.println(a/b);      
    } 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author HP-PC
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        int i = new Integer(123);
//        int a = new Integer("123");
//        int num = Integer.parseInt("-4536");
//        //  System.out.println(num);
//        Scanner sc = new Scanner(System.in);
//        //String ii = sc.nextLine();
//        // System.out.println(ii);
//        int[] aa = {5, 1, 2, 3, 6};
//        aa.toString();
//        Arrays.toString(aa);
//        System.out.println(aa.toString());
//        System.out.println(Arrays.toString(aa));
//        int[] b = aa.clone();
//        String str = b.toString();
//        System.out.println(str);
//        System.out.println(b);
//        for (int s = 0; s < b.length; s++) {
//            // System.out.println(b[s]);
//        }

        int[] arr4 = {3, 7, 2, 1, 9};
        Arrays.sort(arr4);

        System.out.println(arr4.toString());
        System.out.println(Arrays.toString(arr4));
        for (int x : arr4) {
            System.out.print(x + "\t"); // 1 2 3 7 9
        }
        System.out.println();
        int[] arr5 = {3, 7, 2, 1, 9};
        Arrays.sort(arr5, 1, 4);//加头不加尾
        for (int x : arr5) {
            System.out.print(x + "\t"); // 3 2 7 1 9
        }
        System.out.println();
        Vector<Integer> aa = new Vector<>();
        aa.add(Integer.SIZE)
        ArrayList<Integer> list = new ArrayList();
        list.add(Integer.SIZE)
    }

}

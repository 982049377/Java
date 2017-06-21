/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP-PC
 */
public class link {

 
    public Object[] list;

    public link() {
    }

    public int indexof(Object s) {
        for (int i = 0; i < list.length; i++) {
            if (s == list[i]) {
                return i;
            }
        }
        return -1;
    }

    public void add(Object s) {
        if (this.indexof(s) == -1) {
            System.out.println("已经存在此元素");
            return;
        }
        list[list.length] = s;
    }

    public boolean del(Object d) {
        int ind = this.indexof(d);
        if (ind == -1) {
            System.out.println("不存在此元素");
            return false;

        }
        list[ind] = null;
        for (; ind < list.length - 1; ind++) {
            list[ind] = list[ind + 1];
        }
        return true;
    }

    public boolean Correct(Object before, Object after) {
        int in = this.indexof(before);
        if (in == -1) {
            System.out.println("不存在此元素");
            return false;

        }
        list[in] = after;
        return true;
    }

    public void Output() {
        for(int i=0;i<list.length;i++){
            System.out.println(list[i]);
        }
    }

    public Object geti(int num) {
        if(num>list.length){
            return null;
        }
        return list[num];
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linklist;

/**
 *
 * @author HP-PC
 */
//泛型
public class Link1<E> {
    class Node
    {
        E date;
        Node next;
        public Node(E o){date=o;next=null;}
    }
    Node head;
    public Link1()
    {
        head=null;
    }
    public void add(E s)
    {
        Node p;
        if(head==null)
        {head=new Node(s);}
        else
        {
            for(p=head;p.next!=null;p=p.next);
            p.next=new Node(s);
        }
    }
    public boolean del(E d)
    {
        Node p;
        p=head;
        boolean i=false;
        while(p.next!=null)
        {
            if(p.next.date==d)
            {
                i=true;
                p.next=p.next.next;
                return i;
            }  
            p=p.next;
        }
        return i;
    }
    public boolean Correct(E c,E cc)
    {
        Node p;
        p=head;
        boolean i=false;
        Node aft=new Node(cc);
        while(p.next!=null)
        {
            if(p.next.date==c)
            {
                i=true;
                p.next=aft;
                aft.next=p.next.next;
                return i;
            } 
            p=p.next;
        }
        return i;
    }
    public void Output()
    {
        Node p;
        p=head;
        while(p.next!=null)
        {
            System.out.print(p.date+"    ");
            p=p.next;
        } 
        System.out.print(p.date+"    ");
    }
    public Object geti(int num)
    {
        Node p;
        int i=0;
        if(head==null)
        {return -1;}
        else
        {
            for(p=head;p.next!=null;p=p.next,i++)
            {
                if(i==num)
                {
                    return p.date;
                }
            }
            if(i==num)
            {
                    return p.date;
            }
        }
        return -1;
    }
    
}

package classfile;

import java.io.*;
import java.lang.String;
import java.util.*;

class SingleLinkedList {
    SNode head;
    public SingleLinkedList() {
        head = null;
    }

    public void append(int n) {
        SNode curr = head;
        if(head == null)
            head = new SNode(n);
        else {
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = new SNode(n);
        }
    }

    public void append(SNode no) {
        SNode curr = head;
        if(head == null)
            head = no;
        else {
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = no;
        }
    }
    // prev =  null
    // [
    static SNode reverseLL(SNode curr){
        SNode head = curr;
        if(curr != null){
            head = reverseLL(curr.next);
            if(curr.next != null){
                curr.next.next = curr;
                curr.next = null;
            }
            else
                head = curr;

        }
        return head;
    }

    //recursive
    static SNode next=null;
    public void Reverse(SNode curr) {
        if(curr != null) {
            Reverse(curr.next);
            if(next != null)
                next.next = curr;
            else
                head = curr;
            next = curr;
            curr.next = null;
        }
    }
    //iteration
    public void reverseIte(SNode curr) {
        if(head != null) {
            SNode prev = null;
            SNode next = curr.next;

            while(curr != null) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if(next != null)
                    next = next.next;
            }
            head = prev;
        }
    }

    public SNode getHead() {
        return head;
    }

    public SNode getTail() {
        SNode curr = head;
        while(curr != null && curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

    public void Remove(SNode no) {
        if(no != null && head != null) {
            SNode curr = head;
            SNode prev = null;
            while(curr != no) {
                prev = curr;
                curr = curr.next;
            }
            if(prev != null && no.next != null) {
                prev.next = no.next;
                no.next = null;
            } else if(prev == null && no.next != null) {
                head = no.next;
                no.next = null;
            } else if(prev != null && no.next == null) {
                prev.next = null;
            } else {
                no = null;
                head = null;
            }
        }
    }
}

class SingleLinkedListTest {
    public static void main(String args[]) {
        test0();
        test1();
        test2();
    }

    static void test0(){
        System.out.println("---------------------------------\n");
        SingleLinkedList s = new SingleLinkedList();
        SNode n1 = new SNode(1);
        SNode n2 = new SNode(2);
        SNode n3 = new SNode(3);
        s.append(n1);
        s.append(n2);
        s.append(n3);

        Aron.printSLL(s.getHead());
        System.out.println("---------------------------------\n");
        SNode head = s.reverseLL(s.getHead());
        Aron.printSLL(head);
        System.out.println("---------------------------------\n");
    }

    static void test1(){
        System.out.println("---------------------------------\n");
        SingleLinkedList s = new SingleLinkedList();
        SNode n1 = new SNode(1);
        s.append(n1);

        Aron.printSLL(s.getHead());
        System.out.println("---------------------------------\n");
        SNode head = s.reverseLL(s.getHead());
        Aron.printSLL(head);
        System.out.println("---------------------------------\n");
    }


    static void test2(){
        System.out.println("---------------------------------\n");
        SingleLinkedList s = new SingleLinkedList();
        SNode n1 = new SNode(1);
        SNode n2 = new SNode(2);
        SNode n3 = new SNode(3);
        SNode n4 = new SNode(4);
        SNode n5 = new SNode(5);
        s.append(n1);
        s.append(n2);
        s.append(n3);
        s.append(n4);
        s.append(n5);
        Aron.printSLL(s.getHead());

        SNode node = mergeHalf(s.getHead());
        Aron.printSLL(node);
        System.out.println("---------------------------------\n");
    }

    // 1 2 3 4 5
    // 1 3 5
    // 2 4
    // 1 2
    // 3 4 5
    // 1->3
    // 2->4
    // 5->null
    // 1->3->2->4->5->null
    //
    // 1->3
    // 2->4
    // 1->3->2->4
    // 
    // 2, 3, 4
    // 2, [4]
    // 3
    // 2->3->4

    public static SNode mergeHalf(SNode head) {
        SNode curr = head;
        Queue<SNode> q0 = new LinkedList<SNode>();
        Queue<SNode> q1 = new LinkedList<SNode>();
        int count = 0;
        while(curr != null) {
            System.out.println("curr[" + curr.data+"]");
            q1.add(new SNode(curr.data));
            curr = curr.next;
        }

        int halfsize = q1.size()/2;
        int size = q1.size();
        System.out.println("q1size[" + q1.size()+"]");
        System.out.println("q1size/2[" + halfsize +"]");
        for(int i=0; i<= size/2; i++) {
            SNode node = q1.remove();
            System.out.println("node[" + node.data+"] i=[" + i+"]");
            q0.add(new SNode(node.data));
        }

        System.out.println("q0.size[" + q0.size()+"]");
        SNode prevPair = null;
        SNode currPair = null;
        SNode newHead = null;
        while(q0.peek() != null) {
            SNode n0 = q0.remove();
            SNode n1 = null;
            if(q1.peek() != null) {
                n1 = q1.remove();
                System.out.println("q1[" + n1.data+"]");
            }

            n0.next = n1;
            currPair = n0;

            if(prevPair!= null)
                prevPair.next.next = currPair;
            else
                newHead = currPair;
            prevPair = currPair;
        }
        return newHead;
    }
//    public static void print(SNode curr) {
//        while(curr != null) {
//            System.out.println("[" + curr.data+"]");
//            curr=curr.next;
//        }
//    }
}

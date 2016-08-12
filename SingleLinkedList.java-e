package classfile;

import java.io.*;
import java.lang.String;
import java.util.*;

public class SingleLinkedList {
    public SNode head;
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



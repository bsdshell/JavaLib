package classfile;

import java.io.*;
import java.lang.String;
import java.util.*;

public class SingleLinkedList {
    public Node head;
    public SingleLinkedList() {
        head = null;
    }

    public void append(int n) {
        Node curr = head;
        if(head == null)
            head = new Node(n);
        else {
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(n);
        }
    }

    public void append(Node no) {
        Node curr = head;
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
    static Node reverseLL(Node curr){
        Node head = curr;
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
    static Node next=null;
    public void Reverse(Node curr) {
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
    public void reverseIte(Node curr) {
        if(head != null) {
            Node prev = null;
            Node next = curr.next;

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

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        Node curr = head;
        while(curr != null && curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

    public void Remove(Node no) {
        if(no != null && head != null) {
            Node curr = head;
            Node prev = null;
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



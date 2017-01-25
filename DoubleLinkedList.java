package classfile;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector; 

public class DoubleLinkedList{
    public Node head;
    public Node tail;
    public DoubleLinkedList() {
        head = tail = null;
    }
    public void append(Node no) {
        if(head == null) {
            head = no;
            tail = head;
        } else {
            tail.next = no;
            no.prev = tail;;
            tail = tail.next;
        }
    }
    public void addFirst(Node no) {
        if(head == null) {
            head = no;
            tail = head;
        } else {
            head.prev = no;
            no.next = head;
            head = no;
        }
    }
    public void addNext(Node front, Node no) {
        if(front != null) {
            if(front.next == null) {
                append(no);
            } else {
                Node cur = no;
                Node prev = front;
                Node next = front.next;

                cur.prev = prev;
                cur.next = next;
                prev.next = cur;
                next.prev = cur;
            }
        }
    }
    public void delete(Node node) {
        Node curr = head;
        Node prev = null;
        while(curr != null){
            if(curr == node){
                if(prev == null){ 
                    head = curr.next;
                    if(head != null){   // [curr]->[]
                        curr.next.prev = null;
                        curr.next = null;
                    }else{
                        tail = null;  // [curr] 
                    }

                    curr.next = curr.prev = null;
                }else{  
                    prev.next = curr.next;
                    if(curr.next != null)    // []->[curr]->[] 
                        curr.next.prev = prev;
                    else
                        tail = prev;        // []->[curr] 

                    curr.next = curr.prev = null;
                }
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void show() {
        Node cur = head;
        while(cur != null) {
            System.out.println ("cur=" + cur.data);
            cur = cur.next;
        }
    }

    public void toList(List<Node> list) {
        Node curr = head;
        while(curr != null) {
            list.add(curr);
            curr = curr.next;
        }
    }

    public void show1() {
        Node curr = tail;
        while(curr != null) {
            System.out.println ("rev curr=" + curr.data);
            curr = curr.prev;
        }
    }

}



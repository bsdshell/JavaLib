package classfile;
import java.util.*;

public class BST {
    public Node root;
    public BST() {
        root = null;
    };
    public void insert(int n) {
        if(root == null) {
            root = new Node(n);
        } else {
            Node cur = root;
            boolean end = false;
            while(cur != null && !end) {
                if(n < cur.data) {
                    if(cur.left == null) {
                        cur.left = new Node(n);
                        end = true;
                    } else
                        cur = cur.left;
                } else {
                    if(cur.right == null) {
                        cur.right = new Node(n);
                        end = true;
                    } else
                        cur = cur.right;
                }
            }
        }
    }
    public void OneQueue(Node curr) {
        if(curr != null) {
            Queue<Node> q = new LinkedList<Node>();
        }
    }
    public void inorder(Node cur) {
        if(cur != null) {
            inorder(cur.left);
            System.out.print(cur.data + " ");
            inorder(cur.right);
        }
    }
    public boolean findNode(int n) {
        Node cur = root;
        boolean ret = false;
        if(cur != null) {
            if(n < cur.data)
                cur = cur.left;
            else if(n > cur.data)
                cur = cur.right;
            else
                ret = true;
        }
        return ret;
    }
    public boolean findSum(Node r, int n) {
        boolean ret = false;
        if(r == null) {
            if(n == 0)
                ret = true;
        } else if(r != null) {
            boolean bl = findSum(r.left, n - r.data);
            boolean br = findSum(r.right, n - r.data);
            ret = (bl || br);
        }
        return ret;
    }


    public void levelOrder() {
        Node cur = root;
        Queue<Node> Q1 = new LinkedList<Node>();
        Queue<Node> Q2 = new LinkedList<Node>();
        Q1.offer(cur);
        while(Q1.peek() != null || Q2.peek() != null) {
            while(Q1.peek() != null) {
                Node top = Q1.poll();
                System.out.print(top.data + " ");
                if(top.left != null)
                    Q2.offer(top.left);
                if(top.right != null)
                    Q2.offer(top.right);
            }
            System.out.println();
            while(Q2.peek() != null) {
                Node top = Q2.poll();

                System.out.print(top.data + " ");
                if(top.left != null)
                    Q1.offer(top.left);
                if(top.right != null)
                    Q1.offer(top.right);
            }
            System.out.println();
        }
    }
    public Node getRoot() {
        return root;
    }
}

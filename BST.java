package classfile;
import java.util.*;

public class BST {
    public Node root;
    public BST() {
        root = null;
    };

    public void pp(){
        System.out.println("[pp]");
    }

    public void insert(int n) {
        if(root == null) {
            root = new Node(n);
        } else {
            Node curr = root;
            boolean end = false;
            while(curr != null && !end) {
                if(n < curr.data) {
                    if(curr.left == null) {
                        curr.left = new Node(n);
                        end = true;
                    } else
                        curr = curr.left;
                } else {
                    if(curr.right == null) {
                        curr.right = new Node(n);
                        end = true;
                    } else
                        curr = curr.right;
                }
            }
        }
    }
    public void OneQueue(Node curr) {
        if(curr != null) {
            Queue<Node> q = new LinkedList<Node>();
        }
    }
    public void inorder(Node curr) {
        if(curr != null) {
            inorder(curr.left);
            System.out.println("[" + curr.data + "]");
            inorder(curr.right);
        }
    }

    public boolean findNode(int n) {
        Node curr = root;
        boolean ret = false;
            while(curr != null) {
                if(n < curr.data)
                    curr = curr.left;
                else if(n > curr.data)
                    curr = curr.right;
                else
                    return true;
            }
        return ret;
    }

    public boolean contains(int n) {
        Node curr = root;
        boolean ret = false;
            while(curr != null) {
                if(n < curr.data)
                    curr = curr.left;
                else if(n > curr.data)
                    curr = curr.right;
                else
                    return true;
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
        Node curr = root;
        Queue<Node> Q1 = new LinkedList<Node>();
        Queue<Node> Q2 = new LinkedList<Node>();
        Q1.offer(curr);
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

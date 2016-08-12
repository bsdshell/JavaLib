package classfile;

public class PNode {
    public PNode left;
    public PNode right;
    public PNode next;
    public int data;
    public boolean isVisited;
    public PNode(int n) {
        left = right = null;
        data = n;
        isVisited = false;
    }
}


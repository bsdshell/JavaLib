package classfile;

public class Node {
    public Node left;
    public Node right;
    public int data;
    public boolean isVisited;
    public Node(int n) {
        left = right = null;
        data = n;
        isVisited = false;
    }
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }
    public void setLeft(Node l) {
        left = l;
    }
    public void setRight(Node r) {
        right = r;
    }
}


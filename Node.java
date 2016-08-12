package classfile;

public class Node{
    public Node left;
    public Node right;
    public Node next;
    public int data;
    public boolean isVisited;
    public Node(int n) {
        left = right = null;
        data = n;
        isVisited = false;
    }

    @Override
    public int hashCode(){
        return 0;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) 
            return false;
        if(this == obj)
            return true;
        
        if(!(obj instanceof Node))
            return false;

        Node node = (Node)obj;
        if(this.data != node.data)
            return false;

        return true;
    }
}


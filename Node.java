package classfile;

public class Node{
    public Node left;
    public Node right;
    public Node next;
    public Integer data;
    public boolean isVisited;
    public Node(int data) {
        this.left = this.right = null;
        this.data = this.data;
        this.isVisited = false;
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


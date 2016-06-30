package classfile;

import java.io.*;
import java.lang.String;
import java.util.*;


public final class Aron {

    public static void printSLL(SNode head) {
        SNode curr = head;
        while(curr != null){
            System.out.println("---------------------------------\n"); 
            System.out.println("[" + curr.data + "]");
            System.out.println("---------------------------------\n"); 
            curr = curr.next;
        }
    }
    public static boolean findNode(Node root, int n) {
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

    public static void levelOrder(Node root) {
        Node cur = root;
        Queue<Node> Q1 = new LinkedList<Node>();
        Queue<Node> Q2 = new LinkedList<Node>();
        Q1.offer(cur);
        while(Q1.peek() != null || Q2.peek() != null) {
            while(Q1.peek() != null) {
                Node top = Q1.poll();
                System.out.print("[" + top.data + "]");
                if(top.left != null)
                    Q2.offer(top.left);
                if(top.right != null)
                    Q2.offer(top.right);
            }
            System.out.println();
            while(Q2.peek() != null) {
                Node top = Q2.poll();

                System.out.print("[" + top.data + "]");
                if(top.left != null)
                    Q1.offer(top.left);
                if(top.right != null)
                    Q1.offer(top.right);
            }
            System.out.println();
        }
    }

    public static void preorder(Node curr) {
        if(curr != null) {
            System.out.print("[" + curr.data + "]");
    		preorder(curr.left);
    		preorder(curr.right);
    	}
    }

    public static void postorder(Node curr) {
        if(curr != null) {
            postorder(curr.left);
            postorder(curr.right);
            System.out.print("[" + curr.data + "]");
        }
    }

    public static void inorder(Node curr) {
        if(curr != null) {
            inorder(curr.left);
            System.out.print("[" + curr.data + "]");
            inorder(curr.right);
        }
    }

    public static boolean squareNumber(int n) {
        int num = (int)Math.sqrt(n);
        List<Integer> list = Aron.allPrimes(num);

        for (int i = 0; i < list.size(); i++) {
            Integer p = list.get(i);
            if (n % (p * p) == 0)
                n = n / (p * p);
        }

        if(n == 1)
            return true;
        else
            return false;
    }
    public static List<Integer> allPrimes(int num) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);

        for(int n=3; n<=num; n++) {
            boolean isPrime = true;
            for(int j=0; j<list.size() && isPrime; j++) {
                if(list.get(j) < n && n % list.get(j) == 0)
                    isPrime = false;
            }
            if(isPrime)
                list.add(n);
        }
        return list;
    }

    public static List<Integer> geneNPrime(int numPrime) {
        List<Integer> list = new ArrayList<Integer>();
        if(numPrime == 0)
            return list;

        list.add(2);
        int num = 3;
        int count = 1;
        while(count < numPrime ) {
            boolean isPrime = true;
            for(int i=0; i<list.size() && isPrime; i++) {
                if(num % list.get(i) == 0)
                    isPrime = false;
            }
            if(isPrime) {
                list.add(num);
                count++;
            }
            num++;
        }
        return list;
    }


    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray2D(int[][] arr) {
        if(arr != null) {
            for(int c=0; c<arr.length; c++) {
                for(int r=0; r<arr[0].length; r++) {
                    System.out.print("["+arr[c][r]+"]");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public static <T> void printList(List<T> list) {
        for(T item : list) {
            System.out.println(item);
        }
        System.out.println();
    }

    public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        List<T> list = new ArrayList<T>();
        for (T o : a) {
            c.add(o); // Correct
            list.add(o);
            System.out.println("[" + o + "]");
        }
    }

    public static <T> void printArray(T[] arr) {
        if(arr != null) {
            for(T t : arr) {
                System.out.print("["+ t +"]");
            }
            System.out.println();
        }
    }
    public static void printTable(int[][] arr) {
        if(arr != null) {
            for(int c=0; c<arr.length; c++) {
                for(int r=0; r<arr[0].length; r++) {
                    System.out.print("["+arr[c][r]+"]");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void reverse(int[] arr) {
        if( arr != null) {
            int len = arr.length;
            int tmp = 0;
            for(int i=0; i<len/2; i++) {
                tmp = arr[i];
                arr[i] = arr[len-1-i];
                arr[len-1-i] = tmp;
            }
        }
    }

    public static List<String> readFile(String fileName) {
        List<String> list = new ArrayList<String>();
        try {
            // searchkey: read file line by line
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str;
            while((str = in.readLine()) != null) {
                System.out.println(str);
                list.add(str);
            }
            in.close();
        } catch(IOException io) {
            io.printStackTrace();
        }
        return list;
    }

    public static void writeFile(String fileName) {
        try {
            // searchkey: write to file, write file, write to text file, open file to write
            // create file if fileName doesn't exist 
            FileWriter fstream = new FileWriter(fileName);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("hello java");
            out.close();
        } catch(Exception e) {
        }
    }
}

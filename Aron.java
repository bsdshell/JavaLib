package classfile;

import java.io.*;
import java.lang.String;
import java.util.*;

public final class Aron {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    final static String lineStr = "\n--------------------------------------------------------------------------";
    public static void line(){
        System.out.println(lineStr);

    }
    public static int charIndex(char ch){
        Character chara = new Character(ch);
        if(Character.isLowerCase(ch)){
            return (int)ch - 'a';
        }else if(Character.isUpperCase(ch)){
            return (int)ch - 'A';
        }
        return -1;
    }
    public static int charToInt(char ch){
        return (int)ch;
    }

    public static void listDirPrint(String directoryName) {
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
            }
        }
    }

    public static void beg() {
        System.out.println(ANSI_RED + "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]" + ANSI_RESET + lineStr);
    }
    public static void end() {
        System.out.println(lineStr);
    }

    public static void name() {
        System.out.println("[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
    }

    public static void listFileDirPrint(String directoryName) {
        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                listFileDirPrint(file.getAbsolutePath());
            }
        }
    }

    public static boolean isBST(Node root, Node previous) {
        if( root != null) {
            if(!isBST(root.left, previous))
                return false;
            if(previous != null && previous.data >= root.data)
                return false;
            if(!isBST(root.right, root))
                return false;
        }
        return true;
    }

    public static void swap(int m, int n, Node root, Node[] first, Node[] second) {
        if(root != null) {
            swap(m, n, root.left, first, second);
            if(root.data == m) {
                first[0] = root;
            } else if(root.data == n) {
                second[0] = root;
            }
            if( first[0] != null && second[0] != null) {
                int tmp = first[0].data;
                first[0].data = second[0].data;
                second[0].data = tmp;
                first[0] = null;
                second[0] = null;
            }
            swap(m, n, root.right, first, second);
        }
    }

    public static void printSLL(SNode head) {
        SNode curr = head;
        while(curr != null) {
            System.out.println("[" + curr.data + "]");
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
    public static void inorderl(Node curr) {
        if(curr != null) {
            inorder(curr.left);
            System.out.println("[" + curr.data + "]");
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

    public static <T> void printlnList(List<T> list) {
        for(T item : list) {
            System.out.println("[" + item + "]");
        }
        System.out.println();
    }

    public static <T> void printList(List<T> list) {
        for(T item : list) {
            System.out.print("[" + item + "]");
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

    public static <T> void printArray2D(T[][] arr) {
//        if(arr != null) {
//            for(int c=0; c<arr.length; c++) {
//                for(int r=0; r<arr[0].length; r++) {
//                    System.out.print("["+arr[c][r]+"]");
//                }
//                System.out.println();
//            }
//        }
        System.out.println();
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

    public static List<String> readFileOneLine(String fname){
        List<String> list = new ArrayList<String>(); 
        if(fname != null){
            try(BufferedReader br = new BufferedReader(new FileReader(fname))){
                String line; 
                while((line = br.readLine()) != null){
                    break;
                }
                String[] arr = line.trim().split("\\s+");
                for(int i=0; i<arr.length; i++){
                    if(arr[i].length() > 0)
                        list.add(arr[i]); 
                } 
                Aron.printList(list);
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
        return list;
    }

    public static List<String> readFile(String fileName) {
        List<String> list = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str;
            while((str = in.readLine()) != null) {
                list.add(str.trim());
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

    public static List<String> listDir(String directoryName){
        List<String> list = new ArrayList<String>(); 
        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isDirectory()){
                System.out.println(file.getName());
                list.add(file.getName());
            }
        }
        return list;
    }

    public static List<String> listFileDir(String directoryName){
        List<String> list = new ArrayList<String>(); 
        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
                list.add(file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFileDir(file.getAbsolutePath());
                list.add(file.getAbsolutePath());
            }
        }
        return list;
    }
}

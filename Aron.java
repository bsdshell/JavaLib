package classfile;

import java.io.*;
import java.lang.String;
import java.util.*;
import java.net.*;
import classfile.*;

public final class Aron {
    final static String lineStr = "\n--------------------------------------------------------------------------";
    public static void line() {
        System.out.println(lineStr);

    }
    public static int charIndex(char ch) {
        Character chara = new Character(ch);
        if(Character.isLowerCase(ch)) {
            return (int)ch - 'a';
        } else if(Character.isUpperCase(ch)) {
            return (int)ch - 'A';
        }
        return -1;
    }


    // prefix and suffix
    // abc = [a, bc], [ab, c], [abc, ""]
    public static List<String> prefixSuffix(String str){
        List<String> list = new ArrayList<String>(); 
        if(str != null){
            int len = str.length();
            for(int i=0; i<len; i++){
                String prefix = str.substring(0, i+1);
                String suffix = str.substring(i+1, len);
                list.add(prefix);
                list.add(suffix);
            } 

        }
        return list;
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
        System.out.println(CColor.GREEN + "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]" + CColor.RESET + lineStr);
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

    public static char intToChar(int num){
        return Character.forDigit(num, 10);
    }

    public static int charToInt(char ch){
        return Character.digit(ch, 10);
    }
    public static String charToString(char ch){
        return Character.toString(ch);
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

    public static void printSLL(Node head) {
        Node curr = head;
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

    public static List<Queue<Node>> prettyLevel(Node root, int level) {
        Queue<Node> Q1 = new LinkedList<Node>();
        Queue<Node> Q2 = new LinkedList<Node>();
        List<Queue<Node>> list = new ArrayList<Queue<Node>>();

        if(root != null) {
            int countLevel = 1;
            Q1.offer(root);
            Queue<Node> q = new LinkedList(Q1);
            list.add(q);
            while((Q1.peek() != null || Q2.peek() != null) && countLevel < level) {
                if(countLevel < level){
                    Print.plb("q1.s=" + Q1.size());
                    list.add(Q1);
                    countLevel++;
                }

                Q2 = new LinkedList<Node>();
                while(Q1.peek() != null && countLevel < level) {
                    Node top = Q1.poll();
                    Print.pb(top.data);
                    if(top.left != null){
                        //Q2.offer(top.left);
                        Print.p(top.data);
                    }
                    else{
                        //Q2.offer(new Node(100));
                        Print.pb("#"); 
                    }

                    if(top.right != null){
                        //Q2.offer(top.right);
                        Print.p(top.data);
                    }
                    else{
                        //Q2.offer(new Node(1000));
                        Print.pb("#"); 
                    }

                }

                if(countLevel < level){
                    Print.plb("q2.s=" + Q2.size());
                    list.add(Q2);
                    countLevel++;
                }

                System.out.println();
                Q1 = new LinkedList<Node>();
                while(Q2.peek() != null && countLevel < level) {
                    Node top = Q2.poll();

                    Print.pb(top.data);
                    if(top.left != null){
                        Print.p(top.data);
                        //Q1.offer(top.left);
                    }
                    else{
                        Print.pb("#"); 
//                        Q1.offer(new Node(100));
                    }

                    if(top.right != null){
                        Print.p(top.data);
                        //Q1.offer(top.right);
                    }
                    else{
                        Print.pb("#"); 
//                        Q1.offer(new Node(1000));
                    }

                }
                System.out.println();
            }
        }
        return list;
    }
    public static void levelOrder(Node root) {
        Node cur = root;
        Queue<Node> Q1 = new LinkedList<Node>();
        Queue<Node> Q2 = new LinkedList<Node>();
        Q1.offer(cur);
        while(Q1.peek() != null || Q2.peek() != null) {
            while(Q1.peek() != null) {
                Node top = Q1.poll();
                Print.pb(top.data);
                if(top.left != null)
                    Q2.offer(top.left);
                if(top.right != null)
                    Q2.offer(top.right);
            }
            System.out.println();
            while(Q2.peek() != null) {
                Node top = Q2.poll();

                Print.pb(top.data);
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

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int arrayToInt(int[] arr) {
        int s = 0;
        if(arr != null){
            int len = arr.length;
            for(int i=len-1; i>=0; i--){
                int p = (int)Math.pow(10, (len - 1) - i);
                Print.p(arr[i] + "  " + p);
                s += arr[i]*p;
            } 
        }
        return s;
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

    public static boolean arrayInc(int[] arr) {
        boolean isInc = true;
        if(arr != null) {
            int len = arr.length;
            for(int i=1; i<len && isInc; i++){
                if(arr[i-1] > arr[i])
                    isInc = false;
            } 
        }
        return isInc;
    }

    public static void printArray(int[] arr) {
        if(arr != null) {
            for(int t : arr) {
                System.out.print("["+ t +"]");
            }
            System.out.println();
        }
    }
    public static void printArray(long[] arr) {
        if(arr != null) {
            for(long t : arr) {
                System.out.print("["+ t +"]");
            }
            System.out.println();
        }
    }
    public static void printArray(double[] arr) {
        if(arr != null) {
            for(double t : arr) {
                System.out.print("["+ t +"]");
            }
            System.out.println();
        }
    }

    public static void printArray2D(double[][] arr) {
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
    public static void printArray2D(long[][] arr) {
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

    public static <T> void printArray2D(T[][] arr) {
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

    // read one line from file
    public static List<String> readFileOneLine(String fname) {
        List<String> list = new ArrayList<String>();
        if(fname != null) {
            try(BufferedReader br = new BufferedReader(new FileReader(fname))) {
                String line;
                while((line = br.readLine()) != null) {
                    break;
                }
                String[] arr = line.trim().split("\\s+");
                for(int i=0; i<arr.length; i++) {
                    if(arr[i].length() > 0)
                        list.add(arr[i]);
                }
                Aron.printList(list);
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return list;
    }

    // read file line by line
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

    // write to file
    public static void writeFile(String fileName) {
        try {
            FileWriter fstream = new FileWriter(fileName);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("hello java");
            out.close();
        } catch(Exception e) {
        }
    }

    public static void writeFile(String fileName, List<String> list) {
        try {
            FileWriter fstream = new FileWriter(fileName);
            BufferedWriter out = new BufferedWriter(fstream);
            for(String s : list){
                out.write(s);
            }
            out.close();
        } catch(Exception e) {
        }
    }
    public static List<String> listDir(String directoryName) {
        List<String> list = new ArrayList<String>();
        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
                list.add(file.getName());
            }
        }
        return list;
    }

    public static List<String> listFileDir(String directoryName) {
        List<String> list = new ArrayList<String>();
        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
                list.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                listFileDir(file.getAbsolutePath());
                list.add(file.getAbsolutePath());
            }
        }
        return list;
    }
    public static int height(Node r) {
        if(r == null)
            return -1;
        else {
            return Math.max(height(r.left), height(r.right)) + 1;
        }
    }
    public static int level(Node r) {
        if(r == null)
            return 0;
        else
            return Math.max(level(r.left), level(r.right)) + 1;
    }
    public static void saveImage(String imageUrl, String directory, String fName) {
        try {
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(directory + fName);

            byte[] b = new byte[2048];
            int length = 0;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    //[ file=quicksortpart.html title=""
    // partition the array with pivot
    public static int partition(int[] arr, int lo, int hi){
        int big = lo;
        if(arr != null && lo < hi){
            int pivot = arr[hi];
            for(int i=lo; i<=hi; i++){
                if(arr[i] <= pivot){
                    Aron.swap(arr, big, i);
                    if(i < hi)
                        big++;
                }
            }
        }
        return big;
    }
    //]

    public static void quickSort(int[] arr, int lo, int hi){
        if(lo < hi){
            int pivotIndex = partition(arr, lo, hi);
            quickSort(arr, lo, pivotIndex-1);
            quickSort(arr, pivotIndex+1, hi);
        }
    }

    public static String executeCommand(String[] command) {
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static String executeCommand(String command) {
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    // pretty print binary tree
    // int indent = 0
    public static void prettyPrint(Node r, int indent) {
        if( r != null) {
            System.out.print("["+r.data+"]");
            if(r.right != null)
                System.out.print("[  ]");

            prettyPrint(r.right, indent+1);

            if(r.left != null) {
                System.out.println();
                for(int i=0; i<indent; i++) {
                    System.out.print("[  ][  ]");
                }
            }
            prettyPrint(r.left, indent+1);
        }
    }

    public static void binImage(Node r) {
        List<String> list = new ArrayList<String>();
        String str1 = "digraph G{\n";
        list.add(str1);
        System.out.print(str1);
        int level = 0;
        printGraphviz(r, level, list, 0);
        String str2 = "}\n";
        System.out.print(str2);
        list.add(str2);

        String fName = "/Users/cat/myfile/github/java/bintree.gv";
        Aron.writeFile(fName, list);

        //TODO try to run the command in background, "command &" doesn't work 
        String command = "/Applications/Graphviz.app/Contents/MacOS/Graphviz bintree.gv";
        Aron.executeCommand(command);
    }

    public static void printGraphviz(Node root, int level, List<String> list, int leftRight) {
        if(root != null) {
            String str1 = "";
            if(leftRight == 0){
                // 0 = left node
                str1 = "" + root.data + "[color=red];" + "\n";
            }else{
                // 1 = right node
                str1 = "" + root.data + "[color=green];" + "\n";
            }
            System.out.print(str1);
            list.add(str1);
            if(root.left != null) {
                String str2 = "" + root.data + "->";
                System.out.print(str2);
                list.add(str2);
            }
            printGraphviz(root.left, level+1, list, 0);

            if(root.right != null) {
                String str3 = "" + root.data + "->";
                System.out.print(str3);
                list.add(str3);
            }
            printGraphviz(root.right, level+1, list, 1);
        }
    }

    //init index = 0
    public static void printAllPath(Node r, int[] arr, int index) {
        if( r != null && arr != null) {
            arr[index] = r.data;
            if( r.left == null && r.right == null) {
                for(int i=0; i<index+1; i++)
                    System.out.print(arr[i]+" ");
                System.out.println();
            } else {
                printAllPath(r.left, arr, index+1);
                printAllPath(r.right, arr, index+1);
            }
        }
    }

    public static boolean equalBinaryTree(Node r1, Node r2) {
        if(r1==null && r2==null)
            return true;
        else if(r1 != null && r2 != null) {
            if(r1.data != r2.data)
                return false;
            if(!equalBinaryTree(r1.left, r2.left))
                return false;
            if(!equalBinaryTree(r1.right, r2.right))
                return false;
        } else
            return false;
        return true;
    }
}

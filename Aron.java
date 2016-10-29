package classfile;

import java.io.*;
import java.lang.String;
import java.util.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public static String intToAlphabetUpper(int n) {
            int num = (int)'A' + n;
            char ch = (char)num;
            return "" + ch;
    }
    public static String intToAlphabet(int n) {
            int num = (int)'a' + n;
            char ch = (char)num;
            return "" + ch;
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

    /**
    *
    * @param directoryName full directory name 
    *
    * @return void
    */
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

    // 1->'A'
    // 2->'B'
    // 3->'C'
    //
    // 26->'z'
    // 27->'AA'  1*pow(26, 1) + 1*pow(26, 0) = 27
    // 52->'AZ'  1*pow(26, 1) + 26*pow(26, 0) = 52
    //
    // 'A'->1 - 1 = 0
    // 'B'->2 - 1 = 1
    // 'C'->3 - 1 = 2
    // 'Z'->26 - 1 = 25
    // ['A'..'Z'] -> [0..25]
    public static int excelHeaderToNumber(String str) {
        if(str != null) {
            int sum = 0;
            int len = str.length();
            for(int i=len-1; i>=0; i--) {
                char ch = str.charAt(i);
                int c  = ch - 'A' + 1;
                sum += c*(int)Math.pow(26, len - 1 - i);
            }
            return sum;
        } else {
            throw new IllegalArgumentException("str must be not null.");
        }
    }

    // n = 1..
    // c = ch - 'A' + 1 => c - 1 = ch - 'A'
    // x = c - 1 = ch - 'A' => r[0..25] maps ['A'..'Z']
    public static String numberToExcelHeader(int n) {
        final int base = 26;
        String str = "";
        while(n - 1 >= 0) {
            int r = (n - 1) % base;
            str = (char)(r + 'A') + "" + str;
            n  = (n - 1) / base;
        }
        return str;
    }

    // 6:42
    // "123" -> 123
    // String to decimal
    public static int atoInt(String str){
        if(str != null){
            int len = str.length(); 
            int sum = 0;
            for(int i=len-1; i>=0; i--){
                char ch = str.charAt(i);
                if(Character.isDigit(ch)){
                    int c = (int)(ch - '0');
                    sum += c*Math.pow(10, len - 1 - i);
                }else{
                    throw new IllegalArgumentException("str contains non-digit");
                }
            }
            return sum;
        }
        throw new IllegalArgumentException("str must not be null");
    }

    // 3->"101"
    // convert decimal to String Binary
    public static String decimalToBinary(int n){
        String str ="";
        if(n == 0){
            str = "0";
        }else{
            while(n > 0){
                int r = n % 2;
                str = r + "" + str;
                n /= 2;
            }
        }
        return str;
    }
    public static <T> List<T> left(List<T> list, int index) {
        List<T> leftList = new ArrayList<T>(); 
        for(int i=0; i<list.size(); i++)
            leftList.add(list.get(i));

        return leftList;
    }

    public static <T> List<T> right(List<T> list, int index) {
        List<T> rightList = new ArrayList<T>(); 
        for(int i=index; i<list.size(); i++)
            rightList.add(list.get(i));

        return rightList;
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
        return (char)num; 
    }

    public static int charToInt(char ch){
        return (int)ch; 
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

    public static Node getNode(Node r, int m){
        if(r != null){
            if(r.data == m)
                return r;
            Node left = getNode(r.left, m);
            if(left != null)
                return left;

            Node right = getNode(r.right, m);
            if(right != null)
                return right;
        }
        return null;
    }
    public static void swapNode(Node r, int m, int n){
        Node left = getNode(r, m);
        Node right = getNode(r, n);
        if(left != null && right != null){
            int tmp = left.data;
            left.data = right.data;
            right.data = tmp;
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
                    Print.pbl("q1.s=" + Q1.size());
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
                    Print.pbl("q2.s=" + Q2.size());
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

    public static void preorderGraph(Node curr){
        if(curr != null){
            Print.p(curr.data);
            for(Node n : curr.list){
                preorderGraph(n);
            }
        }
    }

    public static void postorder(Node curr) {
        if(curr != null) {
            postorder(curr.left);
            postorder(curr.right);
            System.out.print("[" + curr.data + "]");
        }
    }

    public static void postorderGraph(Node curr){
        if(curr != null){
            for(Node n : curr.list){
                postorderGraph(n);
            }
            Print.p(curr.data);
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

    public static <T1, T2> void printMap(Map<T1, T2> map) {
        for(Map.Entry<T1, T2> entry : map.entrySet()){
            System.out.println("[" + entry.getKey() + " , " + entry.getValue() + "]");
        } 
        
    }
    public static <T> void printSet(Set<T> set) {
        Iterator ite = set.iterator();
        while(ite.hasNext()){
            Print.p(ite.next());
        }
    }
    public static <T> void printList2dArr(List<ArrayList<T>> lists) {
        for(ArrayList<T> list : lists) {
            for(T item : list) {
                System.out.println("[" + item + "]");
                Ut.l();
            }
            Ut.l();
        }
        Ut.l();
    }

    public static <T> void printList2d(List<List<T>> lists) {
        for(List<T> list : lists) {
            for(T item : list) {
                System.out.print("[" + item + "]");
            }
        }
        Ut.l();
    }

    public static <T> void printList2dln(List<List<T>> lists) {
        for(List<T> list : lists) {
            for(T item : list) {
                System.out.println("[" + item + "]");
            }
        }
        Ut.l();
    }

    public static <T> void printList(List<T> list) {
        for(T item : list) {
            System.out.print("[" + item + "]");
        }
        System.out.println();
    }

    public static <T> void printList(List<T> list, String line) {
        for(T item : list) {
            if(line.length() > 0)
                System.out.print("[" + item + "]");
            else
                System.out.println("[" + item + "]");
        }
        System.out.println();
    }

    public static <T> void pL(List<T> list) {
        printList(list);
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

    public static void printArray(char[] arr) {
        if(arr != null) {
            for(char t : arr) {
                System.out.print("["+ t +"]");
            }
            System.out.println();
        }
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
    public static void printArray2D(char[][] arr) {
        if(arr != null) {
            for(int c=0; c<arr.length; c++) {
                for(int r=0; r<arr[0].length; r++) {
                    String s = arr[c][r] + "";
                    System.out.print("["+ s +"]");
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

    // read file line by line to list
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

    // if match pattern, true 
    // o.w false 
    //
    // e.g. pattern="\\.html$" input="file.html" => return true 
    //
    public static boolean isMatched(String regexp, String input) {
        String ret = null;
        Pattern pattern = Pattern.compile(regexp);
        Matcher match = pattern.matcher(input);

        return match.find();
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

    // list all directories only in directoryName
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

    /**
    * @param directoryName absoluate path to a directory
    *
    * @return a list of absoluate file paths 
    */
    public static List<String> listFile(String directoryName) {
        List<String> list = new ArrayList<String>();
        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
                list.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                listFile(file.getAbsolutePath());
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

    public static String extractEmail(String strPhone){
        String retNumber = "";
        String format0 = "([\\w\\.-]+@\\S+\\.\\w{2,3})";
        String[] patternArray = {
            format0
        };
        for(String numberPat: patternArray){
            Pattern patternRegex = Pattern.compile(numberPat);
            Matcher phoneMatch = patternRegex.matcher(strPhone);
            if(phoneMatch.find()){
                retNumber = phoneMatch.group(1);
                Print.pbl(numberPat);
                Print.pbl(retNumber);
                break;
            }
        }
        return retNumber;
    }

    // format0 = 4253443445
    // format1 = 425-344-3445
    // format2 = 425-3443445
    // format3 = 425-344 3445
    // format4 = 425 344-3445
    public static String extractPhoneNumber(String strPhone){
        String retNumber = "";
        String format0 = "((\\d\\s*){10})";
        String format1 = "(\\d{3}-\\d{3}-\\d{4})";
        String format2 = "(\\d{3}-\\d{7})";
        String format3 = "(\\d{3}-\\d{3}\\s*\\d{4})";
        String format4 = "(\\d{3}\\s*\\d{3}-\\d{4})";
        
        String[] patternArray = {
            format0,
            format1,
            format2,
            format3,
            format4
        };
        for(String numberPat: patternArray){
            Pattern patternRegex = Pattern.compile(numberPat);
            Matcher phoneMatch = patternRegex.matcher(strPhone);
            if(phoneMatch.find()){
                retNumber = phoneMatch.group(1);
                Print.pbl(numberPat);
                Print.pbl(retNumber);
                break;
            }
        }
        return retNumber;
    }

    // print all permutation from given char[] array 
    // index = 0
    //
    public static void permutation(char[] arr, int index){
        if(index == arr.length){
            Aron.printArray(arr);
        }else{
            if(arr != null){
                int len = arr.length;
                for(int i=index; i<len; i++){
                    Aron.swap(arr, i, index);
                    permutation(arr, index + 1);
                    Aron.swap(arr, i, index);
                } 
            }
        }
    }

    // rotate 2d array clockwise 90 degrees
    public static void rotateArray(int[][] arr){
        if(arr != null){
            int len = arr.length;
            for(int k = 0; k<len/2; k++){
                for(int j=k; j<len-1-k; j++){
                    int tmp = arr[k][j];
                    arr[k][j] = arr[len-1-j][k];
                    arr[len-1-j][k] = arr[len-1-k][len-1-j];
                    arr[len-1-k][len-1-j] = arr[j][len-1-k];
                    arr[j][len-1-k] = tmp;
                }
            }
        }
    }

    //[ file=spiralnew.html title=""
    // [1, 2]
    //
    // [1]
    // 
    // [1, 2]
    // [3, 4]
    // 
    // [1, 2, 3]
    // [4, 5, 6]
    // print spiral shape from rectangle 
    //
    public static void rotateRectangle(int[][] arr){
        if(arr != null){
            int height = arr.length;
            if(height > 0){
                int width = arr[0].length;
                int k = 0; 
                while(k < Math.min(height, width)){
                    if(width - 2*k == 1){
                        for(int i=k; i<height-k; i++){
                            Print.p(arr[i][k]);
                        } 
                        break;
                    }else if(height- 2*k == 1){
                        for(int i=k; i<width-k; i++){
                            Print.p(arr[k][i]);
                        }
                        break;
                    }
                    else if((width - 2*k == 0) || (height - 2*k == 0)){
                        break;
                    }else{
                        for(int i=k; i<width-1-k; i++){
                            Print.p(arr[k][i]);
                        } 
                        for(int i=k; i<height-1-k; i++){
                            Print.p(arr[i][width-1-k]);
                        }
                        for(int i=k; i<width-1-k; i++){
                            Print.p(arr[height-1-k][width-1-i]);
                        }
                        for(int i=k; i<height-1-k; i++){
                            Print.p(arr[height-1-i][k]);
                        }
                    }
                    k++;
                }
            }
        }
    }
    //]
}

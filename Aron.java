package classfile;

import java.io.*;
import java.lang.String;
import java.util.*;
import java.util.Date;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.output.TeeOutputStream;
import java.text.SimpleDateFormat;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public final class Aron{
    final static String lineStr = "\n--------------------------------------------------------------------------";

    public static void line() {
        System.out.println(lineStr);
    }

    public static double calculatePI(int nStep){
       double pi = 1.0;
       for(int i=1; i<nStep; i++){
           if(i % 2 == 1)
               pi += (double)-1/(2*i + 1);
           else
               pi += (double)1/(2*i + 1);
       } 
       Print.pbl(4*pi);
       return 4*pi;
    }

    public static Logger logInit(String className, String fName){
        Logger LOGGER = Logger.getLogger(className);
        SimpleFormatter formatterTxt = new SimpleFormatter();
        FileHandler fileTxt = null;

        try{
            fileTxt = new FileHandler(fName);
        }catch(IOException e){
            e.printStackTrace();
        }

        LOGGER.setLevel(Level.INFO);
        LOGGER.addHandler(fileTxt);
        fileTxt.setFormatter(formatterTxt);
        return LOGGER;
    }

    // generate random [0...n-1]
    public static List<Integer> random(int n){
		Random ran = new Random();
        List<Integer> list = new ArrayList<Integer>(); 
        for(int i=0; i<n; i++){
            list.add(ran.nextInt(n));
        } 
        return list;
    }
    public static void time(){ now(); }

    public static void date(){ now(); }
    public static void now(){
        String date = StringUtils.rightPad("Date=" + (new Date()), 20, " ");
        Print.pbl(date);
    }

    public static String threadInfo(Thread t){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a");

        String id = StringUtils.rightPad("Id=" + t.currentThread().getId(), 6, " ");
        String state = StringUtils.rightPad("State=" + t.getState(), 20, " ");
        String strTime = StringUtils.rightPad("Time=" + sdf.format(date), 20, " ");
        String tname = StringUtils.rightPad("Name=" + t.currentThread().getName(), 20, " ");
        String retStr = id + state + strTime + tname;
        Print.pbl(retStr);
        return retStr; 
    }

    public static void threadInfo(Thread t, String fName){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a");

        String id = StringUtils.rightPad("Id=" + t.currentThread().getId(), 6, " ");
        String state = StringUtils.rightPad("State=" + t.getState(), 20, " ");
        String strTime = StringUtils.rightPad("Time=" + sdf.format(date), 20, " ");
        String tname = StringUtils.rightPad("Name=" + t.currentThread().getName(), 20, " ");
        String content = id + state + strTime + tname + "\n";
        writeFileBoth(fName, content); 
    }

    public static void threadInfo(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a");

        String id = StringUtils.rightPad("Id=" + Thread.currentThread().getId(), 6, " ");
        String strTime = StringUtils.rightPad("Time=" + sdf.format(date), 20, " ");
        String tname = StringUtils.rightPad("Name=" + Thread.currentThread().getName(), 20, " ");
        Print.pbl(id + strTime + tname);
    }


    // generate random unique [0...n-1]
    public static List<Integer> randomUnique(int n){
		Random ran = new Random();
        List<Integer> list = new ArrayList<Integer>(); 
        
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++){
            arr[i] = i;
        } 

        for(int i=0; i<n; i++){
            int r = ran.nextInt(n - i);
            int tmp = arr[r]; 
            arr[r] = arr[n-1-i];
            arr[n-1-i] = tmp;
        } 
        return Arrays.asList(arr); 
    }

//    public static List<String> sortList(List<String> list){
//        return Collections.sort(list); 
//    }
    public static List<String> sortArray(String[] arr){
        Arrays.sort(arr);
        return Arrays.asList(arr);
    }

    public static String sortStr(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
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

    // word boundary, boundary word, get all words, read all word
    // get all words from a file, read all words from a file
    public static List<String> getWords(String fileName){
        Pattern pattern = Pattern.compile("(?<=^|\\s)[a-z]+(?=\\s|$)");
        
        List<String> wordList = new ArrayList<String>(); 
        List<String> list = Aron.readFile(fileName);
        for(String s : list){
            String[] arr = s.split("\\s+");
            for(String str : arr){
                Matcher matcher = pattern.matcher(str.toLowerCase());
                if(matcher.find()){
                    wordList.add(matcher.group());
                }
            }
        }
        return wordList;
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

    // get all files from current directory
    // return a list of absoluate paths
    // getcurrent file, 
    public static List<String> getCurrentFiles(String directoryName) {
        List<String> list = new ArrayList<String>(); 
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                list.add(file.getAbsolutePath());
            } 
        }
        return list;
    }

    // get all files from current directory
    // return a list of absoluate paths
    // getcurrent file, 
    public static List<String> getCurrentDir(String directoryName) {
        List<String> list = new ArrayList<String>(); 
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            list.add(file.getAbsolutePath());
        }
        return list;
    }

    // get all directories from current directory
    // return a list of absoluate paths in directoryName
    public static List<String> getCurrentDirs(String directoryName) {
        List<String> list = new ArrayList<String>(); 
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isDirectory()) {
                list.add(file.getAbsolutePath());
            } 
        }
        return list;
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

    public static void preorder(Node curr, int level) {
        if(curr != null) {
            String s = StringUtils.leftPad("", 2*level, '-');
            System.out.println(s + "[" + curr.data + "]");
            preorder(curr.left, level + 1);
            preorder(curr.right, level + 1);
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

    // *postorder* with *two_stacks* two stacks
    public static void postorderTwoStacks(Node r){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        if(r != null){
            s1.push(r);
            while(!s1.empty()){
                Node n = s1.pop();
                if(n.left != null)
                    s1.push(n.left);
                if(n.right != null)
                    s1.push(n.right);
                s2.push(n);
            }
            while(!s2.empty())
                Print.pbl(s2.pop().data);
        }
    }
    
    public static void postorder(Node curr) {
        if(curr != null) {
            postorder(curr.left);
            postorder(curr.right);
            System.out.print("[" + curr.data + "]");
        }
    }

    // postorder graph *postorder_graph*
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
            Ut.l();
        }
        Ut.l();
    }

    public static <T> void printList2dln(List<List<T>> lists) {
        for(List<T> list : lists) {
            for(T item : list) {
                System.out.println("[" + item + "]");
            }
            Ut.l();
        }
        Ut.l();
    }

    public static <T> void printList(List<T> list) {
        for(T item : list) {
            System.out.print("[" + item + "]");
        }
        System.out.println();
    }

    public static <T> void printListLn(List<T> list) {
        for(T item : list) {
            System.out.println("[" + item + "]");
        }
        System.out.println();
    }

    public static <T> void printList(List<T> list, String b) {
        for(T item : list) {
            //System.out.print("[" + item + "]");
            Print.pb(item, b);
        }
        System.out.println();
    }

    public static <T> void printList(List<T> list, int num) {
        for(T item : list) {
            if(num == 0)
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

    // split string with delimiter: pattern,
    // empty string is removed
    public static List<String> split(String str, String pattern){
        String[] array = str.split(pattern);
        List<String> list = new ArrayList<String>(); 
        for(String s : array){
            if(s.trim().length() > 0)
                list.add(s);
        }
        return list; 
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

    public static List<String> readFileOneLineSplit(String fname, String delimiter) {
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

    // read the FIRST line from file 
    public static List<String> readFileOneLineSplit(String fname) {
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

    // read binary file byte[], and split it with new line '\n', not for '\r\n'
    // return list of string with new line = '\n'
    public static List<String> readFileLineByte(String fName, int bufSize){
        List<String> list = new ArrayList<String>(); 
        try {
            FileInputStream fstream = new FileInputStream(fName);
            int nbyte = 0;
            //Read File Line By Line
            byte[] arr = new byte[bufSize];
            byte[] lineArr = new byte[bufSize];
            int k=0;
            while ((nbyte = fstream.read(arr)) != -1) {
                String str = new String(arr);

                for(int i=0; i<nbyte; i++){
                    Print.pbl("char=" + arr[i]);
                    if(arr[i] == '\n'){
                        Print.pbl("newline=" + arr[i]);

                        lineArr[k] = arr[i];
                        list.add(new String(lineArr));
                        k = 0;
                        lineArr = new byte[bufSize];
                    }else{
                        lineArr[k] = arr[i];
                        k++;
                    }
                }
            }
            //Close the input stream
            fstream.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }


    /**
    *  split line with empty line separator 
    *  
    *  line1
    *  line2
    *  
    *  line2
    *  
    *  line3
    *  
    *  output [line1 line2] [line2] [line3]
    */
    public static List<ArrayList<String>> readFileSaperater(String fileName) {
        List<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>(); 
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str;
            String line = "";
            
            ArrayList<String> list = new ArrayList<String>(); 
            while((str = in.readLine()) != null) {
                String goodStr = str.trim();
                if(goodStr.length() > 0){
                    list.add(goodStr);
                }else{
                    if(list.size() > 0)
                        list2d.add(list);
                    list = new ArrayList<>();
                }
            }
            in.close();
        } catch(IOException io) {
            io.printStackTrace();
        }
        return list2d;
    }

    // write to file
    public static void writeFile(String fileName) {
        try {
            FileWriter fstream = new FileWriter(fileName);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("hello java");
            out.close();
        } catch(Exception e) {
            e.printStackTrace();
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

    public static void writeFileBoth(String fName, List<String> list) {
        try {
            File file = new File(fName);
            FileOutputStream fos = new FileOutputStream(file);
            TeeOutputStream bothOut = null;
            bothOut = new TeeOutputStream(System.out, fos);

            for(String str: list) {
                byte[] contentInBytes = str.getBytes();
                //we will want to print in standard "System.out" and in "file"
                bothOut.write(contentInBytes);
            }

            if(bothOut != null){
                bothOut.flush();
                bothOut.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFileBoth(String fName, String content) {
        try {
            File file = new File(fName);
            byte[] contentInBytes = content.getBytes();

            FileOutputStream fos = new FileOutputStream(file);
            //we will want to print in standard "System.out" and in "file"
            TeeOutputStream bothOut = new TeeOutputStream(System.out, fos);

            bothOut.write(contentInBytes);
            bothOut.flush();
            bothOut.close();

        } catch (Exception e) {
            e.printStackTrace();
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

    public static List<Integer> listStrToInt(List<String> list){
        List<Integer> nlist = new ArrayList<Integer>();
        for(String s : list){
            nlist.add(Integer.parseInt(s));
        }
        return nlist;
    }

    public static int partition(Integer[] arr, int lo, int hi){
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

    public static void quickSort(int[] arr, int lo, int hi){
        if(lo < hi){
            int pivotIndex = partition(arr, lo, hi);
            quickSort(arr, lo, pivotIndex-1);
            quickSort(arr, pivotIndex+1, hi);
        }
    }

    public static void quickSort(Integer[] arr, int lo, int hi){
        if(lo < hi){
            int pivotIndex = partition(arr, lo, hi);
            quickSort(arr, lo, pivotIndex-1);
            quickSort(arr, pivotIndex+1, hi);
        }
    }

    public static void quickSort(List<Integer> list, int lo, int hi){
        Integer[] arr = list.toArray(new Integer[list.size()]); 
        quickSort(arr, lo, hi);
        list.clear(); 
        for(Integer n : arr)
            list.add(n);
    }

    public static void swapStr(String[] arr, int i, int j){
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(String[] arr, int lo, int hi){
        int big = lo;
        if(arr != null && lo < hi){
            String pivot = arr[hi];
            for(int i=lo; i<=hi; i++){
                int n = arr[i].compareTo(pivot);
                Print.pbl("n=" + n);
                if(n > 0){
                    swapStr(arr, big, i);
                    if(i < hi)
                        big++;
                }
            }
        }
        return big;
    }

    public static void quickSortStr(String[] arr, int lo, int hi){
        if(lo < hi){
            int pivotIndex = partition(arr, lo, hi);
            quickSortStr(arr, lo, pivotIndex-1);
            quickSortStr(arr, pivotIndex+1, hi);
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


    // spawn a complete new process
    // String cmd = "/opt/local/bin/mvim";
    // spawnProcess(cmd);
    public static void spawnProcess(String cmd){
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finished");
    }

    // exec command, execute command, parent => child process 
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


    // pretty print binary tree *printbst* *printbinarytree*
    public static void prettyPrint(Node curr, int level){
        String s = StringUtils.leftPad("", 2*level, ' ');
        if(curr != null){
            if(curr.isLeft == null)
                Print.pl(s + "[" + curr.data + "]");
            else{
                if(curr.isLeft)
                    Print.pl(s + CColor.YELLOW + "L[" + curr.data + "]" +  CColor.RESET);
                else 
                    Print.pl(s + "R[" + curr.data + "]");
            }

            if(curr.left != null)
                curr.left.isLeft = true;
            prettyPrint(curr.left, level + 1);

            if(curr.right != null)
                curr.right.isLeft = false;
            prettyPrint(curr.right, level + 1);
        }else{
            Print.pl(s + "[ ]");
        }
    } 

    // pretty print binary tree *prettyprint*
    public static void prettyPrint(Node curr, int level, boolean isLeaf){
        String s = StringUtils.leftPad("", 4*level, ' ');
        if(curr != null){
            if(curr.isLeft == null)
                Print.pl(s + "[" + curr.data + "]");
            else{
                if(curr.isLeft)
                    Print.pl(s + CColor.YELLOW + "[" + curr.data + "]" +  CColor.RESET);
                else 
                    Print.pl(s + "[" + curr.data + "]");
            }

            if(curr.left != null)
                curr.left.isLeft = true;
            prettyPrint(curr.left, level + 1, curr.left == null && curr.right == null ? true : false);

            if(curr.right != null)
                curr.right.isLeft = false;
            prettyPrint(curr.right, level + 1, curr.left == null && curr.right == null ? true : false);
        }else{
            if(!isLeaf)
            Print.pl(s + "[ ]");
        }
    } 

    // print general tree *prettytree* *printgeneraltree*
    public static void prettyPrintGeneral(Node curr, int level){
        if(curr != null){
            String s = StringUtils.leftPad("", 4*level, ' ');
            Print.pl(s + "[" + curr.data + "]");
            for(Node n : curr.list){
                prettyPrintGeneral(n, level + 1);
            }
        }
    }

    // print Binary Tree image or Binary Tree graph *printimg* *printbstimg*
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

		Random ran = new Random();
        int ranNum = ran.nextInt(9000);
        String name = "bintree_" + ranNum + ".gv";

        //String fName = "/Users/cat/myfile/github/java/bintree.gv";
        String fName = "/Users/cat/myfile/github/java/" + name;
        Aron.writeFile(fName, list);

        //TODO try to run the command in background, "command &" doesn't work 

        //String command = "/Applications/Graphviz.app/Contents/MacOS/Graphviz bintree.gv";
        String command = "/Applications/Graphviz.app/Contents/MacOS/Graphviz " + name;
        
        try {
            //Runtime.getRuntime().exec("/opt/local/bin/mvim");
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Aron.executeCommand(command);
    }

    // print *printgraphic*
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

    public static Node cloneBinaryTree(Node r){
        if(r != null){
            Node parent = new Node(r.data);
            parent.left = cloneBinaryTree(r.left);
            parent.right = cloneBinaryTree(r.right);
            return parent;
        }
        return null;
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

    public static BST createBin(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(9);

        int index = 0;
        boolean isLeaf = true;
        prettyPrint(b1.root, index, isLeaf);
        //binImage(b1.root);

        Aron.end();
        return b1; 
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

    // is positive Integer from [-n -1 0 1 n] 
    // gf /Users/cat/myfile/github/java/MatchNum.java
    public static boolean isNumeric(String str){
        return str.matches("[-+]?[1-9][0-9]*|0");
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

    //[ file=findminmax.html title=""
    // /Users/cat/myfile/github/java/RotatedSortedArrayMaxMin.java 
    // find the index of minimum element of an array
    // make sure to test the case [2, 1]
    public static int findMinimumIndex(int[] arr, int lo, int hi){
        if( arr[lo] <= arr[hi])
            return lo;
        else{
            // [2, 1]
            // [3, 1, 2]
            // =>[3, 1] => [1]
            int mid = (lo + hi)/2;
            if(arr[lo] < arr[mid])
                return findMinimumIndex(arr, mid, hi);
            else if(arr[lo] > arr[mid])
                return findMinimumIndex(arr, lo, mid);
            else 
                return hi;
        }
    }
    public static int findMaximumIndex(int[] arr, int lo, int hi){
        if(arr[lo] <= arr[hi])
            return hi;
        else{
            // [2, 1]
            int mid = (lo + hi)/2;
            if( arr[lo] < arr[mid])
                return findMaximumIndex(arr, mid, hi);
            else if(arr[lo] > arr[mid]) 
                return findMaximumIndex(arr, lo, mid);
            else
                return lo;
        }
    }
    //]

    // /Users/cat/myfile/github/java/TryRArr.java
    public static void spiral(int[][] arr){
        int height = arr.length;
        int width= arr[0].length;
        int min = Math.min(width, height);
        int k = 0;
        while(k < width){
            // [2, 1]
            // horizonal 
            if(height - 2*k == 1){
                for(int i=k; i<width-k; i++)
                    Print.p(arr[k][i]); // horizontal

                break;
            }
            else if(width - 2*k == 1){
                for(int i=k; i<height-k; i++)
                    Print.p(arr[i][k]); // vertical 

                break;
            }
            else{
                for(int i=k; i<width-1-k; i++)
                    Print.p(arr[k][i]);
                for(int i=k; i<height-1-k; i++)
                    Print.p(arr[i][width-1-k]);
                for(int i=k; i<width-1-k; i++)
                    Print.p(arr[height-1-k][width-1-i]);
                for(int i=k; i<height-1-k; i++)
                    Print.p(arr[height-1-i][k]);
            }
            k++;
        }
    }

    // print general tree
    public static void inorderGeneralTree(Node r){ 
        Print.p(r.data);
        for(Node n : r.list)
            inorderGeneralTree(n);
    }

    // create general tree
    public static Node createGeneralTree(){
        Node r = new Node(1); 
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);

        Node nn1 = new Node(11);
        Node nn2 = new Node(12);
        Node nn3 = new Node(13);

        Node nn4 = new Node(14);
        Node nn5 = new Node(15);

        n1.list.add(nn1);
        n1.list.add(nn2);
        n1.list.add(nn3);

        n2.list.add(nn4);
        n2.list.add(nn5);

        r.list.add(n1);
        r.list.add(n2);
        r.list.add(n3);
        return r;
    }

    // gf /Users/cat/myfile/github/java/SerializeGeneralTree.java
    public static void serializeGeneralTree(Node r, BufferedWriter bw){
        if(r != null){
            try{
            bw.write(r.data + " ");
            for(Node n : r.list)
                serializeGeneralTree(n, bw);

            bw.write(" # ");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    // use one stack to deserialize general tree
    public static Node deserializeGeneralTree(List<String> list){ 
        Stack<Node> stack = new Stack<>();
        for(String s : list){
            if(!s.equals("#")){
                Node n = new Node(s);
                stack.push(n);
            }else{
                if(stack.size() > 1){
                    Node top = stack.pop();
                    stack.peek().list.add(top);
                }
            }
        }
        return stack.peek();
    }
}

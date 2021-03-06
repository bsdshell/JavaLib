package classfile;

import java.io.*;
import java.lang.String;
import java.util.*;
import java.lang.*;

public final class Test extends TestBase{
    public static void t(boolean b) {
        Print.p(param(b) + pc(b == true));
    }

    public static void f(boolean b) {
        Print.p(param(b) + pc(b == false));
    }

    public static void t(String n1, String n2) {
        Print.p(param(n1, n2) + pc(n1.equals(n2)));
    }

    public static void t(long n1, long n2) {
        System.out.println("[" + n1 + "][" + n2 + "]" + "[" + (n1 == n2) + "]");
    }
    
    public static void t(int n1, int n2) {
        Print.p(param(n1, n2) + pc(n1 == n2));
    }

    public static void t(Integer[] arr1, Integer[] arr2) {
        boolean equal = true;
        if(arr1 != null && arr2 != null){
            int len1 = arr1.length;
            int len2 = arr2.length;
            if(len1 == len2){
                for(int i=0; i<len1 && equal; i++){
                    if(arr1[i] != arr2[i])
                        equal = false;
                } 
            }else{
                equal = false;
            }
        }else{
            equal = false;
        }
        Print.pbl(equal);
    }
    public static void t(Integer n1, Integer n2) {
        if(n1 == null && n2 == null){
            Print.p(param(n1, n2) + pc(true)); 
        }
        else if((n1 == null && n2 != null) || (n1 != null && n2 == null))
            System.out.println("[" + n1 + "][" + n2 + "]" + CColor.RED + "[" + false + "]");
        else{
            boolean boo = n1.intValue() == n2;
            if(boo)
                System.out.println("[" + n1 + "][" + n2 + "]" + "[" + boo + "]");
            else
                System.out.println("[" + n1 + "][" + n2 + "]" + CColor.RED + "[" + boo + "]" + CColor.RESET);
        }
    }

    public static void t(Integer n1, int n2) {
        if(n1 == null)
            System.out.println("[" + n1 + "][" + n2 + "]" + CColor.RED + "[" + false + "]");
        else{
            boolean boo = n1.intValue() == n2;
            if(boo)
                System.out.println("[" + n1 + "][" + n2 + "]" + "[" + boo + "]");
            else
                System.out.println("[" + n1 + "][" + n2 + "]" + CColor.RED + "[" + boo + "]" + CColor.RESET);
        }
    }
    public static void t(int n1, Integer n2) {
        if(n2 == null)
            Print.p(param(n1, n2) + pc(false));
        else{
            System.out.println("[" + n1 + "][" + n2 + "]" + pc(n1 == n2.intValue()));
        }
    }
    public static void t(Character n1, Character n2) {
        if(n1 == null && n2 == null)
            System.out.println("[" + n1 + "][" + n2 + "]" + "[" + true + "]");
        else if((n1 == null && n2 != null) || (n1 != null && n2 == null))
            System.out.println("[" + n1 + "][" + n2 + "]" + CColor.RED + "[" + false + "]");
        else{
            System.out.println("[" + n1 + "][" + n2 + "]" + "[" + n1.equals(n2) + "]");
        }
    }

    public static boolean t(Object n1, Object n2) {
        if(n1 == null && n2 == null){
            System.out.println("[" + n1 + "][" + n2 + "]" + "[" + true + "]");
            return true;
        }
        else if((n1 == null && n2 != null) || (n1 != null && n2 == null)){
            Print.p("line1");
            Print.p("[" + n1 + "][" + n2 + "]" + CColor.RED + "[" + false + "]");
            return false;
        }
        else{
            boolean boo = n1.equals(n2);
            System.out.println("[" + n1 + "][" + n2 + "]" + "[" + boo + "]");
            return boo;
        }
    }

    public static boolean tt(Object n1, Object n2) {
        if(n1 == null && n2 == null){
            return true;
        }
        else if((n1 == null && n2 != null) || (n1 != null && n2 == null)){
            return false;
        }
        else{
            return n1.equals(n2);
        }
    }
    public static void f(Object n1, Object n2){
        Print.p("[" + n1 + "][" + n2 + "]" + "[" + (tt(n1, n2) == false) + "]");
    }
}



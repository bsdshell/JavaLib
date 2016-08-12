package classfile;

import java.io.*;
import java.lang.String;
import java.util.*;
import java.lang.*;

class TestBase{
    public static String pc(boolean b){
        if(b)
            return "" + CColor.WHITE + "[" + b + "]" + CColor.RESET;
        else
            return "" + CColor.RED + "[" + b + "]" + CColor.RESET;
    }

    public static String param(int n1, int n2) {
        return "[" + n1 + "][" + n2 + "]";
    }
   
    public static String param(String n1, String n2) {
        return "[" + n1 + "][" + n2 + "]";
    }

    public static String param(Integer n1, Integer n2) {
        return "[" + n1 + "][" + n2 + "]";
    }

    public static String param(int n1, Integer n2) {
        return "[" + n1 + "][" + n2 + "]";
    }

    public static String param(Integer n1, int n2) {
        return "[" + n1 + "][" + n2 + "]";
    }

    public static String param(int n1) {
        return "[" + n1 + "]";
    }
    public static String param(boolean n1) {
        return "[" + n1 + "]";
    }
}



import java.util.*;
import java.io.*;
import classfile.*;

public class AllTest{
    public static void main(String[] args) {
        test0_extractEmail();
        test1_extractEmail();
        test2_extractEmail();
        test3_extractEmail();
        test4_extractEmail();

        test0_extractPhoneNumber();
        test1_extractPhoneNumber();
        test2_extractPhoneNumber();
        test3_extractPhoneNumber();
        test4_extractPhoneNumber();


    }
    public static void test0_extractEmail(){
        Aron.beg();
        String str = "dog@dog.com";
        String email = Aron.extractEmail(str);
        Test.t(email, str);
        Aron.end();
    }
    public static void test1_extractEmail(){
        Aron.beg();
        String str = "dog_cat@dog.com";
        String email = Aron.extractEmail(str);
        Test.t(email, str);
        Aron.end();
    }
    public static void test2_extractEmail(){
        Aron.beg();
        String str = "Santa Monica CA dog.cat@dog.com. call me baby";
        String email = Aron.extractEmail(str);
        Test.t(email, "dog.cat@dog.com");
        Aron.end();
    }
    public static void test3_extractEmail(){
        Aron.beg();
        String str = "A third of food producted worldwild never get eaten dog-cat@dog.co, this is that cool";
        String email = Aron.extractEmail(str);
        Test.t(email, "dog-cat@dog.co");
        Aron.end();
    }
    public static void test4_extractEmail(){
        Aron.beg();
        String str = "A third of food producted worldwild never get eaten 3344dog-cat@d334og.co, this is that cool";
        String email = Aron.extractEmail(str);
        Test.t(email, "3344dog-cat@d334og.co");
        Aron.end();
    }

    public static void test0_extractPhoneNumber(){
        Aron.beg();
        String str = "call me baby 426-334-3345 call";
        String number = Aron.extractPhoneNumber(str);
        Test.t(number, "426-334-3345");
        Aron.end();
    }
    public static void test1_extractPhoneNumber(){
        Aron.beg();
        String str = "call me baby 4263343345call";
        String number = Aron.extractPhoneNumber(str);
        Test.t(number, "4263343345");
        Aron.end();
    }
    public static void test2_extractPhoneNumber(){
        Aron.beg();
        String str = "call me baby 426 334 3345call";
        String number = Aron.extractPhoneNumber(str);
        Test.t(number, "426 334 3345");
        Aron.end();
    }
    public static void test3_extractPhoneNumber(){
        Aron.beg();
        String str = "call me baby426-334 3345call";
        String number = Aron.extractPhoneNumber(str);
        Test.t(number, "426-334 3345");
        Aron.end();
    }
    public static void test4_extractPhoneNumber(){
        Aron.beg();
        String str = "call me baby426 334-3345call";
        String number = Aron.extractPhoneNumber(str);
        Test.t(number, "426 334-3345");
        Aron.end();
    }
} 

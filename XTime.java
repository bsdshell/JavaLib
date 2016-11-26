package classfile;

public class XTime{
    static long ti = 0;
    public static void start(){
        ti = System.currentTimeMillis();
    }
    public static void stop(){
        long tf = System.currentTimeMillis();
        Print.pbl("Finish. Second:" + (tf - ti)/1000.0 + "=>" + " Millisecond:" + (tf-ti)); 
    }
    
}


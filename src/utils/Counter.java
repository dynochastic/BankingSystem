package utils;

import java.lang.Thread;
//Counter for delay
public class Counter {

    public static void threeSecondsCounter()  {
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }
    }
    public static void fiveSecondsCounter()  {
        try{
            Thread.sleep(5000);
        }
        catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }    }
    public static void oneSecondCounter()  {
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }    }
}

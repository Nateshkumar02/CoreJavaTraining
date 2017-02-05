package com.Programs.Assignment3;

/**
 * Created by nateshkumar on 2/5/17.
 */
public class threadMain {


    public static void main(String[] args)  {

        threadOne one =new threadOne();
        threadTwo two=new threadTwo();

        Thread t1=new Thread(one);
        Thread t2=new Thread(two);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();






    }
}

package com.Programs.Assignment3;

/**
 * Created by nateshkumar on 2/5/17.
 */
public class threadOne implements Runnable{
    @Override
    public void run() {


        for(int i=0;i<5;i++)
        {

            System.out.println("threa One : " + (10*i));
        }

    }
}

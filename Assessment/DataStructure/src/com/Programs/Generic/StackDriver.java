package com.Programs.Generic;
import java.lang.*;
/**
 * Created by nateshkumar on 2/5/17.
 */
public class StackDriver  {

        public static void main (String a[])
        {
            Stacks <Integer> s = new StackGeneric<Integer>();
            s.push(20);
            s.push(30);
            s.push(40);
            s.push(50);
            s.push(60);
            s.push(70);

            System.out.println("Size of the stack: " + s.size());

            // iterate through stack
            System.out.println("Following items pushed to Stack as of now:");
            for (Integer i : s)
                System.out.println(i);
        }
    }


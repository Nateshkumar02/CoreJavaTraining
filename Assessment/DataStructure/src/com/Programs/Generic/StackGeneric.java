package com.Programs.Generic;

import java.util.Iterator;

/**
 * Created by nateshkumar on 2/5/17.
 */
public class StackGeneric <Item> implements Stacks <Item> {

    private Item container[];
    private int top;
    private final static int DEFAULT_SIZE = 10;

    public StackGeneric() {
        //this(DEFAULT_SIZE);
    }

    public StackGeneric( int initSize ) {
        container = (Item[]) new Object[initSize];
        top = -1;
    }

    public Item getTop() {
        if (top == -1)
            return null;
        return container[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public Item pop() {
        if (top == -1)
            return null;
        return container[top--];
    }

    public void push( Item itm ) {
        container[++top] = itm;
    }

    public int size() {
        return (top + 1);
    }


}
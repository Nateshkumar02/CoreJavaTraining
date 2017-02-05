package com.Programs.Generic;

/**
 * Created by nateshkumar on 2/5/17.
 */
import java.util.*;
public interface Stacks <Item>
{
    Item getTop(); // return the top item without removing it from stack
    Item pop(); // return the top item and removes it from stack
    void push(Item itm); // adds an item to the stack
    boolean isEmpty(); // returns true if stack is empty, false otherwise
    int size();  // returns the number of items in stack right now

}
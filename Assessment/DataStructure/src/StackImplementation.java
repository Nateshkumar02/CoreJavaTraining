/**
 * Created by nateshkumar on 2/5/17.
 */

import java.lang.Exception;
public class StackImplementation {

    private int maxSize;
    private long[] stackArray;
    private int top;

    public StackImplementation(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }
    public void push(long data)throws Exception {
        if(isFull()) {
            throw new Exception("Stack overflow");
        }
        else{
            stackArray[++top] = data;
        }
    }
    public long pop() throws Exception{
        if(isEmpty()) {

            throw new Exception("Stack underflow");
        }
        else{
            return stackArray[top--];
        }
    }
    public long peek() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == maxSize - 1);
    }
    public void display()
    {
        if(!isEmpty())
        {
            for(int i=0;i<maxSize;i++)
            {
                System.out.println(stackArray[i]);
            }
        }
    }
    public static void main(String[] args) {
        StackImplementation Stack = new StackImplementation(10);
        try {
            Stack.push(10);
            Stack.push(20);
            Stack.push(30);
            Stack.push(40);
            Stack.push(50);
            //Stack.display();
            while (!Stack.isEmpty()) {
                long value = Stack.pop();
                System.out.print(value);
                System.out.print(" ");
            }
            System.out.println("");
        } catch (Exception ex) {
            System.out.println( ex.getMessage());
        }
    }
}

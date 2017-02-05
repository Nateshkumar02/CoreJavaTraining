/**
 * Created by nateshkumar on 2/5/17.
 */
import java.util.Scanner;
public class QueueImplementation {
    private static final int capacity = 3;
    int arr[] = new int[capacity];
    int size = 0;
    int front = -1;
    int rear = 0;

    public void push(int pushedElement) {
        if (front < capacity - 1) {
            front++;
            arr[front] = pushedElement;
            System.out.println("Element " + pushedElement
                    + " is pushed to Queue !");
            display();
        } else {
            System.out.println("Overflow !");
        }

    }

    public void pop() {
        if (front >= rear) {
            rear++;
            System.out.println("Pop operation done !");
            display();
        } else {
            System.out.println("Underflow !");
        }
    }

    public boolean isEmpty() {
        return (front == -1);
    }
    public boolean isFull() {
        return (front == capacity - 1);
    }

    public void display() {
        if (front >= rear) {
            System.out.println("Elements in Queue : ");
            for (int i = rear; i <= front; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        QueueImplementation queueDemo = new QueueImplementation();
        queueDemo.pop();
        queueDemo.push(23);
        queueDemo.push(2);
        queueDemo.push(73);
        queueDemo.push(21);
        queueDemo.pop();
        queueDemo.pop();
        queueDemo.pop();
        queueDemo.pop();
    }

}

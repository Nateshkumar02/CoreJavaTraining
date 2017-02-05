/**
 * Created by nateshkumar on 2/5/17.
 */
import java.util.Collection;
class Node
{
    int data;
    Node next;

    public Node(int data)
    {
        this.data=data;
        this.next=null;

    }

}
public class LinkedListImplementation
{

        Node Head;

    public void insertAtBeg(int data)
    {

        Node n=new Node(data);

        if(Head==null)
        {
            Head=n;
        }
        else {

            n.next = Head;
            Head = n;
        }

    }
    public  void insertAtEnd(int data) {

        Node n = new Node(data);
        if (Head == null)
        {
            Head = n;

        }
        else
        {
            Node temp = Head;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    public void insertAtMid(int data)
        {
            Node newNode = new Node(data);
            Node SlowPointer=Head;
            Node FastPointer=Head;


            while(FastPointer.next!=null)
            {
                SlowPointer=SlowPointer.next;
                FastPointer=FastPointer.next.next;
            }
            newNode.next=SlowPointer.next;
            SlowPointer.next=newNode;
        }

        public void display()
        {

            Node next=Head;
            int i=0;
            while(next!=null)
            {
                System.out.print("Node[" + i + "] : " + next.data + "\n");
                next=next.next;
                i++;

            }
        }

        public void insertAtPos(int data,int position)
        {
            Node node=new Node(data);
            Node temp=Head;
            Node prev=Head;
            int i=0;
            while(i<position-1)
            {
                prev=temp;
                temp=temp.next;
                i++;
            }
            prev.next=node;
            node.next=temp;
        }

    public static void main(String[] args)
    {
        LinkedListImplementation ll=new LinkedListImplementation();
            ll.insertAtEnd(10);
            ll.insertAtEnd(20);
            ll.insertAtEnd(8);
            ll.insertAtEnd(45);
            ll.insertAtEnd(25);
            ll.insertAtBeg(68);
            ll.insertAtPos(90,3);
            ll.insertAtMid(43);
            ll.display();
    }
}


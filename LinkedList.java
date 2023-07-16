import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
    void display(){
        System.out.println(data);
    }
}
class SLL{
    Node append(Node head,int d){
        if(head == null){
            Node temp = new Node(d);
            head=temp;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp = temp.next;
            }
            Node n = new Node(d);
            temp.next=n;
        }
        return head;
    }
    void display(Node temp){
        while(temp!=null){
            temp.display();
            temp=temp.next;
        }
    }
    Node reverse(Node temp){
        Node n;
        Node p=null;
        while(temp!=null){
            n=temp.next;
            temp.next=p;
            p=temp;
            temp=n;
        }
        return p;
    }
}
public class LinkedList{
    public static void main(String[] args) {
        SLL l = new SLL();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        for(int i=0;i<n;i++){
            int d = sc.nextInt();
           head = l.append(head,d);
        }
        System.out.println("display");
        l.display(head);
        Node head1 =l.reverse(head);
        System.out.println("reverse");
        l.display(head1);
        sc.close();
    }
}
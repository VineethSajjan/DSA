import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
   /* void display(){
        System.out.println(data);
    }*/
}
class Queu{
    Node front=null,rear =null;
    void enqueue(int d){
        if(front==null){
            Node temp = new Node(d);
            front=rear=temp;
        }
        else{
            Node temp = new Node(d);
            rear.next=temp;
            rear = temp;
        }
    }
    void dequeue(){
        if(front == null){
            System.out.println("empty");
            return ;
        }
        else{
            System.out.println(front.data);
            front = front.next;
        }
    }
}
class Quue{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queu q = new Queu();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            q.enqueue(sc.nextInt());
        }
        System.out.println("dequeue");
        q.dequeue();
        q.dequeue();
        sc.close();
    }
}


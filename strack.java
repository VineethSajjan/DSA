import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        next = null;
        data =d;
    }
}
class Stick{
    Node hptr;
    int max,c;
    Stick(int n){
        hptr=null;
        max=n;
        c=0;
    }
    void push(int d){
        if(max==c){
            return ;
        }
        if(hptr==null){
            Node temp=new Node(d);
            hptr = temp;
            c++;
        }
        else{
            Node nptr=new Node(d);
            nptr.next=hptr;
            hptr=nptr;
            c++;
        }
    }
    void pop(){
        if(c==0){
            return ;
        }
        System.out.println(hptr.data);
        hptr=hptr.next;
        c--;
    }
}
class strack{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stick st = new Stick(n);
        for(int i=0;i<n;i++){
            st.push(sc.nextInt());
        }
        for(int i=0;i<n;i++){
            st.pop();
        }
        st.pop();
        sc.close();
    }
}
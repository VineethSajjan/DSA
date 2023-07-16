import java.util.*;
class Node{
    Node c[] = new Node[26];
    boolean end;
    void put(char a , Node n){
        c[a-'a'] = n;
    }
    boolean containsKey(char a){
        if(c[a-'a']!=null){
            return true;
        }
        return false;
    }
    Node get(char a){
        return c[a-'a'];
    }
    void setend(){
        end=true;
    }
    boolean isend(){
        return end;
    }
}
class trie{
    static Node r = new Node();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s [] = sc.nextLine().split(" ");
        String v = sc.next();
        for(int i=0;i<s.length;i++){
            insert(s[i]);
        }
        System.out.println(contain(v));
        sc.close();
    }
    public static void insert(String s){
        Node t = r;
        for(int i=0;i<s.length();i++){
            if(!t.containsKey(s.charAt(i))){
                t.put(s.charAt(i), new Node());
            }
            t=t.get(s.charAt(i));
        }
        t.setend();
    }
    public static boolean contain(String s){
        Node t = r;
        for(int i=0;i<s.length();i++){
            if(!t.containsKey(s.charAt(i))){
                return false;
            }
            t = t.get(s.charAt(i));
        }
        return t.isend();
    }
}


import java.util.*;
class Toposort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0;i<m;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            al.get(a1).add(a2);
        }
        Stack<Integer> st  = new Stack<>();
        int [] vis = new int[m];
        for(int i=0;i<m;i++){
            if(vis[i]==0){
                dfs(al,vis,st,i);
            }
        }
        for(int i=0;i<m;i++){
            System.out.print(st.pop()+" ");
        }
        sc.close();
    }
    public static void dfs(ArrayList<ArrayList<Integer>> al,int [] vis,Stack<Integer> st,int i){
        vis[i]=1;
        for(int j:al.get(i)){
            if(vis[j]==0){
                dfs(al,vis,st,j);
            }
        }
        st.push(i);
    }
}

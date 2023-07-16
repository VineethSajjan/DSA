import java.util.*;
import java.util.LinkedList;
class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        data = d;
        left = null;
        right = null;
    }
    void display(){
        System.out.println(data);
    }
}
class Binarysearchtree{
    Node append(Node root,int d){
        if(root == null){
            Node temp = new Node(d);
            return temp;
        }
        else if(d>root.data){
            root.right = append(root.right,d);
            return root;
        }
        else{
            root.left = append(root.left,d);
            return root;
        }
    }
    void inorder(Node temp){
        if(temp==null){
            return;
        }
        inorder(temp.left);
        temp.display();
        inorder(temp.right);
    }
    void preorder(Node temp){
        if(temp==null){
            return;
        }
        temp.display();
        preorder(temp.left);
        preorder(temp.right);
    }
    void postorder(Node temp){
        if(temp==null){
            return;
        }
        postorder(temp.left);
        postorder(temp.right);
        temp.display();
    }
    void levelorder(Node temp){
        if(temp==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(temp);
        while(!q.isEmpty()){
            Node r = q.poll();
            System.out.println(r.data);
            if(r.left!=null){
                q.add(r.left);
            }
            if(r.right!=null){
                q.add(r.right);
            }
        }

    }
    int height(Node root){
        if(root == null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
    Node getmin(Node temp){
        if(temp == null)
            return null;
        
        if(temp.left != null)
            return getmin(temp.left);
        
        return temp;
    }
    boolean isbalanced(Node r){

        int lh,rh;
		if(r == null){
			return true;
		}
		else{
			lh=height(r.left);
			rh=height(r.right);
			if(Math.abs(lh-rh)>1){
				return false;
			}
			else{
				return isbalanced(r.left)&&isbalanced(r.right);
			}
        }
    }
    void rightsideview(Node root,int level,List<Integer> ds){
        if(root == null){
            return ;
        }
        if(ds.size()==level){
            ds.add(root.data);
        }
        rightsideview(root.right, level+1, ds);
        rightsideview(root.left, level+1, ds);
    }
    void leftsideview(Node root,int level,List<Integer> ds){
        if(root==null){
            return ;
        }
        if(ds.size()==level){
            ds.add(root.data);
        }
        leftsideview(root.left, level+1, ds);
        leftsideview(root.right, level+1, ds);
    }
        
}
class BST{
    public static void main(String[] args) {
        Binarysearchtree b = new Binarysearchtree();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d;
        Node root=null;
        for(int i=0;i<n;i++){
            d=sc.nextInt();
            root  = b.append(root,d);
        }
        System.out.println("display order");
        b.inorder(root);
        System.out.println("LevelOrder");
        b.levelorder(root);
        Node min = b.getmin(root);
        if(min == null){
            System.out.println("null tree");
        }
        else{
            System.out.println("the value is : "+min.data);
        }
        System.out.println(b.isbalanced(root));
        List<Integer> ds = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        b.rightsideview(root,0,ds);
        System.out.println("right side view:"+ds);
        b.leftsideview(root,0,v);
        System.out.println("right side view:"+v);
        sc.close();
    }
}
/*
 dikstars --- done   O(ElogV)  priorityqueue(pair(dist,node)),List<List<List<Integer>>> - to store ,dist to update if smaaler and push to queue; 
 bellaman ford --- n-1 iteratiopn after we check for one more iteration if it updates it has negative cycles. O(VE);
 foldfulkersion --- done O(Ef) e edges f is maximum flow
 topological sort --- done using visitedarray stack dfs, khans algo bfs. shortest path in dag .
 krushkal [union][disjointset]--- O(ElogV); sort edges according to wt ->(wt,u,v) now connect u and v of all edges if already present dont. noneed to update as we have sort we get min first
 prims priorityqueue(pair(wt,node,parent)) after pop we mark visited not on push. O(v2); sum=0; 
 knapsack
 fenwick
 segment
 suffix tree
 linkedlist --- done
 tree --- done
 stack --- done
 queue --- done
 trie --done
 merge sort -- done
 Quick sort --- done
 insertion sort --- done
 bubble sort --- done time --- O(n2) ---- best --O(N) already sorted
 selection sort --- done time -- O(n2) space -- O(1)
 */
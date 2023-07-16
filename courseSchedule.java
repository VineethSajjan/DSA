/*A graduate at University of China (UoC) has to follow certain rules. The rules are as follows:

UoC is offering K subjects, the subjects are indexed from 0 to K-1.
Some subjets have to follow the conditions, like condition[i]= [Xi, Yi] which specifies you must
take the subject Yi before the subject Xi.

You are given total number of subjects and a list of the condition pairs.
Return the ordering of subjects that a graduate should take to finish all subjects.
	- the result set should follow the given order of conditions.
	- If it is impossible to complete all subjects, return an empty set.

Input Format:
-------------
Line-1: An integer K, number of subjects.
Line-2: An integer C, number of conditions.
Next C lines: Two space separated integers, Xi and Yi.

Output Format:
--------------
Return a list of integers, the ordering of subjects that a graduate should take to finish all subjects


Sample Input-1:
---------------
4
3
1 2
3 0
0 1

Sample Output-1:
----------------
[2, 1, 0, 3]

Explanation-1:
--------------
There are a total of 4 courses to take. 
Subject 1  should be taken after you finished subject 2.
Subject 3  should be taken after you finished subject 0.
Subject 0  should be taken after you finished subject 1.
So the correct subject order is [2, 1, 0, 3].

Sample Input-2:
---------------
5
5
0 1
1 2
2 3
3 4
4 0

Sample Output-2:
----------------
[]

Explanation-2:
-------------
No subject can be completed because they depend on each other.
*/
import java.util.*;
import java.util.LinkedList;
class Test{
    static ArrayList<Integer> v = new ArrayList<>();
    public static void main (String[] args) {
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
            al.get(a2).add(a1);
        }
        bfs(al,m);
        System.out.println(v);
        sc.close();
    }
    public static void bfs(ArrayList<ArrayList<Integer>> al,int n){
        int ind[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j:al.get(i)){
                ind[j]+=1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(ind[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int r = q.poll();
            v.add(r);
            for(int i:al.get(r)){
                ind[i]-=1;
                if(ind[i]==0){
                    q.add(i);
                }
            }
        }
    }
}
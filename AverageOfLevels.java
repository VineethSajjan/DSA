/*
For X-Mas, santa claus is preparing a X-Mas Tree with set of Bulbs.
The bulbs are of different voltages, and preparation of tree as follows:
	- The bulbs are arranged in level-wise, levels are numbered from 0,1,2,3..
	  so on.
	- At level-0: There will be only one bulb as root bulb.,
	- From next level onwards, we can attach atmost two bulbs, one is to left side
	  and/or the other is to right side of every bulb in previous level.
	- The empty attachements in a level are indicated with -1. 
	(for example: look in hint)
		
You will be given the X-Mas Tree root,
Your task is to findout the average of each level of the X-Mas tree, starts from level-0.

Input Format:
-------------
A single line of space separated integers, voltages of the set of bulbs.

Output Format:
--------------
Print a list of double values (averages of each level)

Sample Input-1:
---------------
3 8 4 3 5 -1 7 

Sample Output-1:
----------------
[3.0, 6.0, 5.0]

Sample Input-2:
---------------
3 8 4 3 5 7 7 

Sample Output-2:
----------------
[3.0, 6.0, 5.5]

*/

import java.util.*;
import java.util.LinkedList;

class BinaryTree
{
	public int val; 
	public BinaryTree left, right; 
	public BinaryTree(int val){
		this.val = val; 
		left = null; 
		right = null; 
	}
}

public class AverageOfLevels{
	void insert(BinaryTree root, int key) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTree current = queue.poll();

            if (current.left == null) {
                current.left = new BinaryTree(key);
                break;
            } else {
                queue.offer(current.left);
            }

            if (current.right == null) {
                current.right = new BinaryTree(key);
                break;
            } else {
                queue.offer(current.right);
            }
        }
	}
	public List<Double> averageOfLevels(BinaryTree root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum=0;
            for (int i = 0; i < size; i++) {
                BinaryTree current = queue.poll();
                sum=sum+current.val;
                if (current.left != null && current.left.val!=-1) {
                    queue.offer(current.left);
                }

                if (current.right != null && current.right.val!=-1) {
                    queue.offer(current.right);
                }
            }
            double v = sum/size;
            res.add(v);
        }

        return res;
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		AverageOfLevels aveLel = new AverageOfLevels();
		
		String str[]=sc.nextLine().split(" ");
		BinaryTree root = new BinaryTree(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			aveLel.insert(root,Integer.parseInt(str[i]));

		System.out.println(aveLel.averageOfLevels(root));
        sc.close();
	}
}


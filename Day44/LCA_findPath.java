/*
 * In a joint family, every person is assigned with an ID, an integer value.
and the entire family is arranged in the form of tree.

You will be given the family tree and two persons IDs P1 and P2.
Your task is to find the person ID, who is the latest common ascendant of P1 and P2.
and return the Lowest Common Ascendant ID.

Implement the class Solution:
    - Node lowestCommonAscendant(Node root, Node P1, Node P2):
        return the person ID who is the latest common ascendant of P1 and P2.

Input Format:
-------------
Line-1: Single line of space separated integers, person ID's in the family.
Line-2: Two Person IDs, P1 and P2.

Output Format:
--------------
Return the latest common ascendant of P1 and P2.


Sample Input-1:
---------------
3 5 1 6 2 0 8 -1 -1 7 4
6 4

Sample Output-1:
----------------
5

Sample Input-2:
---------------
11 99 88 77 22 33 66 55 10 20 30 40 50 60 44
66 55

Sample Output-2:
----------------
11
 */

 import java.util.*;

class Node 
{
    public int data;
    public Node left;
    public Node right;
    public Node(int value) 
	{
        data = value;
        left = null;
        right = null;
    }
}

public class LCA_findPath 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        
        String[] arr= sc.nextLine().split(" ");
        String[] persons = sc.nextLine().split(" ");
        
        List<Integer> v = new ArrayList<>();
        int n=arr.length;
        for (int i = 0; i < n; i++) 
		{
            v.add(Integer.parseInt(arr[i]));
        }
        
        Node P1 = new Node(Integer.parseInt(persons[0]));
        Node P2 = new Node(Integer.parseInt(persons[1]));
        Queue<Node> q = new LinkedList<>();
		Node root = new Node(v.get(0));
      
        q.add(root);
        
        int j = 1;
        while (j < n && !q.isEmpty())
		{
            Node temp = q.poll();
            if (v.get(j) != -1) 
			{
                temp.left = new Node(v.get(j));
                q.add(temp.left);
            }
            j++;
            
            if (j < n && v.get(j) != -1) 
			{
                temp.right = new Node(v.get(j));
                q.add(temp.right);
            }            
            j++;
        }
        Node res=new Solution().lowestCommonAscendant(root, P1.data, P2.data);
        System.out.println(res.data);
  }
}

class Solution 
{
    Node lowestCommonAscendant(Node root, int n1, int n2)
	{
        //Write your code here
        List<Node> path1=new ArrayList<>();
        List<Node> path2=new ArrayList<>();
        if(!findPath(root,path1,n1) || !findPath(root,path2,n2)){
            return null;
        }
        int i;
        for(i=0;i<path1.size()&& i<path2.size();i++){
            if(path1.get(i).data!=path2.get(i).data){
                break;
            }
        }
        return path1.get(i-1);
    }

    // Finds the path from root to given node
    static boolean findPath(Node root, List<Node> path, int n) {

        //Write your code here
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n){
            return true;
        }
        if(findPath(root.left,path,n) || findPath(root.right,path,n)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

}
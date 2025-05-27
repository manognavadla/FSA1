/*
 * You're given a binary tree represented in level-order (with -1 denoting nulls). Your task is to print all paths from each leaf node to the root, preserving the order from leaf → parent → … → root. Each path should be printed on a new line, with node values joined by " —> ".
If the current node is null, return.
If the current node is a leaf (no left or right children), print the current path.

Input Format:
------------
Line-1: A single line containing space-separated integers representing the binary tree in level-order.
Use -1 to represent a null (no child).

Output Format:
--------------
Each line represents one path from a leaf node to the root.
Node values must be joined using " —> ".
Order of output paths may vary based on traversal, but all valid paths must be included

Constraints:
-------------
1 ≤ number of nodes ≤ 10^4
Node values are integers in the range [-10^9, 10^9]
Input tree is binary (each node has at most two children)
Input is provided in level-order, and -1 denotes nulls

Sample Input-1:
------------------
1 2 3 4 5 6 7 -1 -1 -1 -1 8 9 -1 -1

Sample Output-1:
--------------
4 —> 2 —> 1  
5 —> 2 —> 1  
8 —> 6 —> 3 —> 1  
9 —> 6 —> 3 —> 1  
7 —> 3 —> 1

Sample Input-2:
-------------
1 -1 2 -1 3 -1 4

Sample Output-2:
-------------------
4 —> 3 —> 2 —> 1

 */
import java.util.*;
class Node{
    String val;
    Node left,right;
    Node(String val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}
class LeafToRoot{
    public static Node build(String[] arr){
        if (arr.length == 0 || arr[0].equals("-1")) return null;

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();
            if (i < arr.length && !arr[i].equals("-1")) {
                current.left = new Node(arr[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("-1")) {
                current.right = new Node(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
    static List<String> rtp(Node root){
        List<String> res= new ArrayList<>();
        util(root,res,new ArrayList<>());
        return res;
    } 
    static void util(Node root, List<String> res, List<String> temp){
        if(root== null) return;
        temp.add(root.val);
        if(root.left== null && root.right==null){
            List<String> s= new ArrayList<>(temp);
            Collections.reverse(s);
            res.add(String.join(" —> ",s));
        }else{
            util(root.left,res,temp);
            util(root.right,res,temp);
        }
        temp.remove(temp.size()-1);
    }
   
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String[] arr= sc.nextLine().split(" ");
        Node root= build(arr);
        List<String> res= rtp(root);
        for(String i: res){
            System.out.println(i);
        }
    }
}
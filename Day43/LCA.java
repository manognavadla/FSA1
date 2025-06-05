package Day43;
/*
 * In a joint family, every person is assigned with an ID, an integer value.
and the entire family is arranged in the from of tree.

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

class Node {
    public int data;
    public Node left;
    public Node right;
    public Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

public class LCA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");
        String[] persons = sc.nextLine().split(" ");

        List<Integer> values = new ArrayList<>();
        for (String s : arr) {
            values.add(Integer.parseInt(s));
        }

        int p1Val = Integer.parseInt(persons[0]);
        int p2Val = Integer.parseInt(persons[1]);

        Node root = buildTreeFromLevelOrder(values);
        Node P1 = findNode(root, p1Val);
        Node P2 = findNode(root, p2Val);

        Node res = new Solution().lowestCommonAscendant(root, P1, P2);
        if (res != null)
            System.out.println(res.data);
        else
            System.out.println("LCA not found");
    }

    // Function to build a binary tree from level order input
    public static Node buildTreeFromLevelOrder(List<Integer> values) {
        if (values == null || values.isEmpty())
            return null;

        Node root = new Node(values.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int index = 1;
        while (index < values.size()) {
            Node current = q.poll();
            if (index < values.size()) {
                current.left = new Node(values.get(index++));
                q.add(current.left);
            }
            if (index < values.size()) {
                current.right = new Node(values.get(index++));
                q.add(current.right);
            }
        }
        return root;
    }

    // Helper function to find a node by value
    public static Node findNode(Node root, int val) {
        if (root == null)
            return null;
        if (root.data == val)
            return root;

        Node left = findNode(root.left, val);
        if (left != null)
            return left;

        return findNode(root.right, val);
    }
}

class Solution {
    Node lowestCommonAscendant(Node root, Node p, Node q) {
        if (root == null || root == p || root == q)
            return root;

        Node left = lowestCommonAscendant(root.left, p, q);
        Node right = lowestCommonAscendant(root.right, p, q);

        if (left != null && right != null)
            return root;

        return (left != null) ? left : right;
    } 
}

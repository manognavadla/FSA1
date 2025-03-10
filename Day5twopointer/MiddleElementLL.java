package Day5twopointer;
/*
 * You are given a singly linked list containing N nodes. 
Your task is to find the middle element of the linked list.

Input Format:
-------------
Line 1: An integer N, representing the number of nodes in the linked list.
Line 2: N space-separated integers representing the elements of the linked list.

Output Format:
--------------
Line-1: Print a single integer, the middle element of the linked list.

Sample Input-1:
---------------
5
1 2 3 4 5

Sample Output-1:
----------------
3


Sample Input-2:
---------------
6
1 2 3 4 5 6

Sample Output-2:
----------------
4

 */import java.io.*;
import java.util.*;

public class MiddleElementLL {
    Node head;

    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    void printMiddle() {
        Node slow = head;
        Node fast = head;
        while (fast.next != null) {
            slow = slow.next;
            if (fast.next.next == null) break;
            fast = fast.next.next;
        }
        System.out.print(slow.data);
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + "->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list[] = sc.nextLine().split(" ");
        MiddleElementLL llist = new MiddleElementLL();
        for (int i = 0; i < list.length; i++) {
            llist.push(Integer.parseInt(list[i]));
        }
        llist.printMiddle();
    }
}
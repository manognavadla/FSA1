package Day7;
/*
 * You are given an array nums of size n, where each element represents an object colored red, white, or blue. 
Your task is to sort the array in-place so that all objects of the same color are adjacent, following the order:
-> Red (0)
-> White (1)
-> Blue (2)

Rules:
-> You must not use the built-in sort function.
-> You must modify the array in-place with a time-efficient approach.

Input Format:
-------------
Line 1: An integer n, representing the size of the array.
Line 2: n space-separated integers representing the array nums, where each element is either 0 (red), 1 (white), or 2 (blue).

Output Format:
--------------
Line-1: Print the sorted array as n space-separated integers.

Constraints:
------------
-> 1≤n≤300
-> nums[i]∈{0,1,2} (each element is either 0, 1, or 2)

Sample Input-1:
---------------
6
2 0 2 1 1 0

Sample Output-1:
----------------
0 0 1 1 2 2

Sample Input-2:
---------------
3
2 0 1

Sample Output-2:
----------------
0 1 2
 */
import java.util.*;

public class SortColors {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void sort(int n, int[] arr) {
        int i = 0, j = n - 1, mid = 0;

   
        while (mid <= j) {
            if (arr[mid] == 0) {
                swap(arr, mid, i);
                i++;
                mid++;
            } else if (arr[mid] == 2) {  
                swap(arr, mid, j);
                j--;
            } else { 
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort(n, arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}

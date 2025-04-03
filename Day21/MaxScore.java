package Day21;
/*
 * You are given an array of positive integers. 
Your task is to find a contiguous subarray where all elements are unique 
and return the maximum possible sum that can be obtained by erasing exactly one such subarray.

A subarray is defined as a contiguous sequence of elements within the given array.

Input Format:
-------------
Line-1: An integer N, representing the number of elements in the array.
Line-2: Space-separated integers, representing the elements of the array.

Output Format:
--------------
Line-1: A single integer, representing the maximum sum of a contiguous subarray with all unique elements.

Sample Input-1:
---------------
5  
4 2 4 5 6  

Sample Output-1:
----------------
17

Explanation:
-------------
The longest unique subarray is [2, 4, 5, 6] with a sum of 2 + 4 + 5 + 6 = 17.
This is the maximum possible sum that can be obtained.


Sample Input-2:
---------------
6  
1 2 3 1 2 3  

Sample Output-2:
----------------
6


Explanation:
------------
The longest unique subarray is [1, 2, 3] with a sum of 1 + 2 + 3 = 6.
This sum cannot be improved by choosing another unique subarray.

 */
import java.util.*;
class MaxScore{
    public static int score(int n,int[] arr){
        int sum=0;
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!list.contains(arr[i])) list.add(arr[i]);
        };
        for(int s:list){
            sum+=s;
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        System.out.println(score(n, arr));
        
    }
}
/*
import java.util.*;

class MaxScore {
    public static int score(int n, int[] arr) {
        Set<Integer> uniqueElements = new HashSet<>();
        int maxSum = 0, currentSum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            while (uniqueElements.contains(arr[end])) {
                uniqueElements.remove(arr[start]); // Remove the leftmost element
                currentSum -= arr[start]; // Subtract from sum
                start++; // Move the start of the window forward
            }

            // Add the new unique element
            uniqueElements.add(arr[end]);
            currentSum += arr[end];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(score(n, arr));
        sc.close();
    }
}

 */
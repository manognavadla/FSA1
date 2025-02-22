package Day8;
/*
 You are given three sorted integer arrays A[], B[], and C[], and an integer target.

Your task is to find one element from each array (A[i], B[j], and C[k]) such that the sum of these three elements is equal to target.

If there is no exact match, return the triplet with the minimum absolute difference to the target.

Input Format:
-------------
Line 1: An integer N, the size of the first array.
Line 2: N space-separated integers representing elements of array A.
Line 3: An integer M, the size of the second array.
Line 4: M space-separated integers representing elements of array B.
Line 5: An integer P, the size of the third array.
Line 6: P space-separated integers representing elements of array C.
Line 7: An integer target, the required sum.

Output Format:
--------------
Line-1: Print the triplet (A[i], B[j], C[k]) that either matches the target or has the closest sum to the target.

Constraints:
------------
Time Complexity: O(N + M + P)
Space Complexity: O(1)

Sample Input-1:
---------------
4
5 10 20 30
4
1 3 7 10
4
2 5 8 12
25

Sample Output-1:
----------------
10 7 8

Explanation:
-------------
The sum 10 + 7 + 8 = 25, which exactly matches target.


Sample Input-2:
---------------
3
1 5 10
3
3 6 9
3
4 7 8
30

Sample Output-2:
----------------
10 9 8

Explanation:
------------
The sum 10 + 9 + 8 = 27, which is the closest sum to 30 (minimum absolute difference |30 - 27| = 3).
 */
import java.util.*;

public class ClosestTripletSum {
    
    public static int[] closestTriplet(int[] arr1, int[] arr2, int[] arr3, int target) {
        int n1 = arr1.length, n2 = arr2.length, n3 = arr3.length;
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[3];
        
        for (int i = 0; i < n1; i++) {
            int left = 0, right = n3 - 1;
            
            while (left < n2 && right >= 0) {
                int sum = arr1[i] + arr2[left] + arr3[right];
                int diff = Math.abs(target - sum);
                
                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                    result[0] = arr1[i];
                    result[1] = arr2[left];
                    result[2] = arr3[right];
                }
                
                if (sum == target) return result;
                else if (sum < target) left++;
                else right--;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) arr1[i] = sc.nextInt();
        
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) arr2[i] = sc.nextInt();
        
        int n3 = sc.nextInt();
        int[] arr3 = new int[n3];
        for (int i = 0; i < n3; i++) arr3[i] = sc.nextInt();
        
        int target = sc.nextInt();
        sc.close();
        
        int[] res = closestTriplet(arr1, arr2, arr3, target);
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }
}
/*
 * 
 * import java.util.*;

public class ClosestTripletSum {
    
    public static int closestTwoSum(int[] arr1, int[] arr2, int target, int[] bestPair) {
        int left = 0, right = arr2.length - 1;
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        
        while (left < arr1.length && right >= 0) {
            int sum = arr1[left] + arr2[right];
            int diff = Math.abs(target - sum);
            
            if (diff < minDiff) {
                minDiff = diff;
                closestSum = sum;
                bestPair[0] = arr1[left];
                bestPair[1] = arr2[right];
            }
            
            if (sum == target) return sum; // Immediate return on exact match
            else if (sum < target) left++;
            else right--;
        }
        return closestSum;
    }
    
    public static int[] closestTriplet(int[] arr1, int[] arr2, int[] arr3, int target) {
        Arrays.sort(arr1); // Sorting ensures correctness for two-pointer approach
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[3];
        
        for (int i = 0; i < arr1.length; i++) {
            int[] bestPair = new int[2];
            int twoSum = closestTwoSum(arr2, arr3, target - arr1[i], bestPair);
            int sum = arr1[i] + twoSum;
            int diff = Math.abs(target - sum);
            
            if (diff < minDiff) {
                minDiff = diff;
                closestSum = sum;
                result[0] = arr1[i];
                result[1] = bestPair[0];
                result[2] = bestPair[1];
            }
            
            if (sum == target) return result; 
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) arr1[i] = sc.nextInt();
        
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) arr2[i] = sc.nextInt();
        
        int n3 = sc.nextInt();
        int[] arr3 = new int[n3];
        for (int i = 0; i < n3; i++) arr3[i] = sc.nextInt();
        
        int target = sc.nextInt();
        sc.close();
        
        int[] res = closestTriplet(arr1, arr2, arr3, target);
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }
}

 */
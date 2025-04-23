package Day9;
/*
 * In a forest, There are N redwoord trees in a row.
You are given the heights of the trees as heights[],

You are task is to find the longest tree arrangement as follows:
	- Minimum size of the tree arrangement is 3.
	- And there exist a Tree-'i' with heights[i], where 0 < i < N-1.
		- heights[0] < heights[1] < heights[2] <...< heights[i] and
		-  heights[i] > heights[i+1] > heights[i+2] >...>heights[N-1] 

And return the length of the longest tree arrangement.
If there is no such arrangement, return 0.

Input Format:
-------------
Line-1: An integer N, number of elements.
Line-2: N space separated integers, value of the elements.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
8
4 2 5 7 4 2 3 6

Sample Output-1:
----------------
5

Explanation:
------------
The longest tree arrangement is : 2 5 7 4 2


Sample Input-2:
---------------
4
2 4 5 7

Sample Output-2:
----------------
0
 */
import java.util.*;

public class TallestTree {
    public static int longestTreeArrangement(int[] heights) {
		int n=heights.length;
		int[] inc= new int[n];
		int max=Integer.MIN_VALUE;
		int[]dec= new int[n];
		if(n<3)return 0;
		for(int i=1;i<n;i++){
			if(heights[i]>heights[i-1]){
				inc[i]=inc[i-1]+1;
			}
		}
		for(int i=n-2;i>=0;i--){
			if(heights[i]>heights[i+1]){
				dec[i]=dec[i+1]+1;
			}
		}
		for(int i=1;i<n;i++){
			if(inc[i]>0 && dec[i]>0){
				max=Math.max(max, inc[i]+dec[i]+1);

			}
		}
		return max>3? max:0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println(longestTreeArrangement(heights));
    }
}

/*
 * class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length, max = 0, i = 1;

        while (i < n - 1) {
            // Check if arr[i] is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Expand to the left
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                // Expand to the right
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                max = Math.max(max, right - left + 1);
                i = right; // skip to the end of current mountain
            } else {
                i++;
            }
        }

        return max;
    }
}

 */
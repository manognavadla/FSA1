/*
 * A financial analytics platform is monitoring short-term stock price changes 
to identify patterns of investor sentiment. 

Each price movement is recorded as an integer:
A positive number means the price increased (bullish sentiment).
A negative number means the price decreased (bearish sentiment).

Analysts are interested in finding the longest continuous period where stock sentiment alternates
—i.e., gains are followed by losses and vice versa—without interruption. 
This helps flag volatile periods for closer examination.

Your task is to identify the longest contiguous subarray of alternating stock price changes. 
The pattern must be strictly alternating in sign, and the subarray must occupy consecutive positions in the original array.


Constraints:
--------------
2 ≤ N ≤ 100,000 (length of the array).
All values are non-zero integers.
At least one alternating pair exists in the array.

Input Format:
-------------
Line-1: An integer N: number of price changes.
Line-2: N space-separated integers representing changes.

Output Format:
---------------
Line-1: List of sub array elements

Sample Input-1:
---------------
9  
-5 6 -3 2 -1 4 4 -6 7

Sample Output-1:
-----------------
[-5, 6, -3, 2, -1, 4]


Explanation:
-------------
The subarray [-5, 6, -3, 2, -1, 4] alternates in sign and is the longest such sequence. 
The sequence ends when the next element 4 repeats the positive sign.


Sample Input-2:
-------------
5
-5 -4 -3 -2 -1

Sample Output-2:
----------------
[-5]
 */
import java.util.*;

class Alternating {
    static List<Integer> alt(int n, int[] arr) {
        List<Integer> maxSub = new ArrayList<>();
        List<Integer> currSub = new ArrayList<>();
        currSub.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if ((arr[i] < 0 && currSub.get(currSub.size() - 1) > 0) ||
                (arr[i] > 0 && currSub.get(currSub.size() - 1) < 0)) {
                currSub.add(arr[i]);
                } else {
                if (currSub.size() > maxSub.size()) {
                    maxSub = new ArrayList<>(currSub);
                }
                currSub = new ArrayList<>();
                currSub.add(arr[i]);
                }
        }
        if (currSub.size() > maxSub.size()) {
            maxSub = currSub;
        }
        return maxSub;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print(alt(n, arr));
       
    }
}

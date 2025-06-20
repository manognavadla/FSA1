/*
Tejaswi playing a game. Game has a display of N numbers in a row, nums[].
Tejaswi has to pick the numbers one after the other.

Once Tejaswi picks a number num[i], she will score num[i] points and 
the number will be disappared on the board, simultaneously all the numbers 
having the value num[i]+1 or num[i]-1 also disappears. 

Tejaswi has to select the numbers, such that no more numbers will be left over 
on the board.

Tejaswi wants to score maximum number of points.

Initially Tejaswi has 0 points with her.
Can you help Tejaswi to score maximum number of points.

Input Format:
-------------
Line-1 -> an integers N, number of numbers on the game board.
Line-2 -> N space separated integers, numbers on the game board nums[].

Output Format:
--------------
Print an integer as result, maximum score she can get.


Sample Input-1:
---------------
3
4 5 3

Sample Output-1:
----------------
8

Explanation: 
------------
Pick a number 5 to score 5 points, simultaneously 4 is disappeared from display.
Then, pick number 3 to score 3 points.
Totally 8 is the score.


Sample Input-2:
---------------
6
4 4 5 5 5 6

Sample Output-2:
----------------
15

Explanation: 
-------------
Delete 5 to earn 5 points, deleting both 4's and the 6.
Then, delete 5 again to earn 5 points, and 5 again to earn 5 points.
Totally 15 is the score.

Pick a number 5 to score 5 points, simultaneously all 4's and 6 are disappeared 
from display. Then, again pick the number 5 to score 5 points.
And again pick the number 5 to score 5 points. Totally 15 is the score.
 */import java.util.*;

public class MaximumScore {
    static int how(int n, int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + arr[i]);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        int m = keys.size();
        int[] dp = new int[m];
        dp[0] = map.get(keys.get(0));
        if (m == 1) return dp[0];
        if (keys.get(1) == keys.get(0) + 1) {
            dp[1] = Math.max(dp[0], map.get(keys.get(1)));
        } else {
            dp[1] = dp[0] + map.get(keys.get(1));
        }
        for (int i = 2; i < m; i++) {
            int cur = keys.get(i);
            int prev = keys.get(i - 1);
            if (cur == prev + 1) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + map.get(cur));
            } else {
                dp[i] = dp[i - 1] + map.get(cur);
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(how(n, arr));
    }
}

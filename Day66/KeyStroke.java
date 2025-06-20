/*
 * Amogh is an Antiquarian, The person who collects antiques.
He found a rear keyboard which has following keys,
Keys are 'N', 'S', 'C' and 'P'

1st Key - 'N': Print one character 'N' on Console.
2nd Key - 'S': Select the whole Console.
3rd Key - 'C': Copy selected content to buffer.
4th Key - 'P': Print the buffer on Console, and append it after what has 
already been printed.

Now, your task is to find out maximum numbers of 'N's you can print
after K keystrokes . 

Input Format:
-------------
An integer K

Output Format:
--------------
Print an integer, maximum numbers of 'N's you can print.


Sample Input-1:
-------------------
3

Sample Output-1:
-------------------- 
3

Explanation: 
---------------
We can print at most get 3 N's on console by pressing following key sequence:
N, N, N



Sample Input-2:
-------------------
7

Sample Output-2:
---------------------
9

Explanation: 
---------------
We can print at most get 9 N's on console by pressing following key sequence:
N, N, N, S, C, P, P

 */
import java.util.*;

public class KeyStroke {
    public static int maxNs(int K) {
        int[] dp = new int[K + 1];

        for (int i = 1; i <= K; i++) {
            // Option 1: Press 'N'
            dp[i] = dp[i - 1] + 1;

            for (int j = 1; j <= i - 3; j++) {
                int current = dp[j] * (i - j - 2 + 1);
                // Option 2: Press 'S', 'C', and 'P'
                // 'S' at j, 'C' at j+1, and 'P' at j+2
                // This means we select the content printed till j, copy it,
                // and then print it (i - j - 2) times
                // (i - j - 2) is the number of times we can print the copied content
                // after the 'P' key is pressed
                // We add 1 to account for the initial 'N's printed before 'S'
                dp[i] = Math.max(dp[i], current);
            }
        }

        return dp[K];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        System.out.println(maxNs(K));
    }
}

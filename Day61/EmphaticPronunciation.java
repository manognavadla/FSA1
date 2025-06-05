/*"Emphatic Pronunciation" of a given word is where we take the word and
replicate some of the letter to emphasize their impact.

Instead of saying 'oh my god', someone may say "ohhh myyy goddd", 
We define emphatic pronunciation of a word, which is derived by replicating 
a group (or single) of letters in the original word. 

So that the replicated group is atleast 3 characters or more and 
greater than or equal to size of original group. 
For example Good -> Goood is an emphatic pronunciation,
but Goodd is not because in Goodd the 'd' are only occuring twice consecutively.
 
In the question you are given the "Emphatic pronunciation" word, 
you have to findout how many words can legal result in the 
"emphatic pronunciation" word.

Input Format:
-------------
Line-1 -> A String contains a single word, Emphatic Pronunciation word
Line-2 -> Space seperated word/s
 
Output Format:
--------------
Print an integer as your result


Sample Input-1:
---------------
goood
good goodd

Sample Output-1:
----------------
1


Sample Input-2:
---------------
heeelllooo
hello hi helo

Sample Output-2:
----------------
2
 */

import java.util.*;
public class EmphaticPronunciation {
     public static boolean isEmphaticPronunciation(String em, String word) {
        int i = 0, j = 0;
        int n = em.length(), m = word.length();
        
        while (i < n && j < m) {
            char ec = em.charAt(i);
            char wc = word.charAt(j);
            if (ec != wc) return false;
            int iStart = i;
            while (i < n && em.charAt(i) == ec) i++;
            int emGroupLen = i - iStart;
            int jStart = j;
            while (j < m && word.charAt(j) == wc) j++;
            int wordGroupLen = j - jStart;

            if (emGroupLen < 3) {
                if (emGroupLen != wordGroupLen) return false;
            } else {
                if (wordGroupLen > emGroupLen) return false;
                if (wordGroupLen < 1) return false;
            }
        }
        return i == n && j == m;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String emphaticWord = sc.nextLine();
        String[] words = sc.nextLine().split(" ");
        int count = 0;

        for (String word : words) {
            if (isEmphaticPronunciation(emphaticWord, word)) {
                count++;
            }
        }
        System.out.println(count);  
    }
}

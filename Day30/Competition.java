package Day30;
/*
 * An English competition is taking place in a school. One problem is given in the following manner 
There are words formed with lower case alphabets, participants need to find the count of characters which are repeatedly appeared in all words. 
If no such characters are there, then return 0.

Note: give solution using bit manipulation only

Input Format: 
-------------
Line-1: comma separated strings

Output Format:
--------------
Line-1: an integer

Sample Input-1:
---------------
abc,abc,bc

Sampel Output-1:
----------------
2

Explanation:
------------
The characters 'b' and 'c' appear in each word, so there output is 2 .

Sample Input-2:
---------------
abcdde,baccd,eeabg

Sample Output-2:
----------------
2

Explanation:
------------
Only 'a' and 'b' occur in every word.


Constraints
Each word consists of only lower-case letters ('a'-'z').
 */
import java.util.*;
public class Competition {
    public static int ccc(String[] words) {
        int commonMask = (1 << 26) - 1;

        for (String word : words) {
            int wordMask = 0;
            for (char ch : word.toCharArray()) {
                wordMask |= (1 << (ch - 'a')); 
            }
            commonMask &= wordMask; 
        }
        return Integer.bitCount(commonMask);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(",");
        System.out.println(ccc(words));
     
    }
}

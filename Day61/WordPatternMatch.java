/*
 * Given two strings S1 and S2, find if S2 can match S1 or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and 
distinct non-empty substring in S2, where each non-empty substring in S2
also has a corresponding letter in S1.

Return true,if S2 can match S1.
Otherwise false.

Input Format:
-------------
Line-1 -> Two strings S1 and S2

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
abab kmitngitkmitngit

Sample Output-1:
----------------
true 


Sample Input-2:
---------------
aaaa kmjckmjckmjckmjc

Sample Output-2:
----------------
true

Sample Input-3:
---------------
mmnn pqrxyzpqrxyz

Sample Output-3:
----------------
false
 */
import java.util.*;
public class WordPatternMatch {
    static boolean isMatch(String s1, String s2) {
        Map<Character, String> map = new HashMap<>();
        return isMatchHelper(s1, s2, 0, 0, map);
    }
    static boolean isMatchHelper(String s1, String s2, int i, int j, Map<Character, String> map) {
        if (i == s1.length() && j == s2.length()) return true;
        if (i == s1.length() || j == s2.length()) return false;

        char c = s1.charAt(i);
        if (map.containsKey(c)) {
            String mappedStr = map.get(c);
            if (!s2.startsWith(mappedStr, j)) return false;
            return isMatchHelper(s1, s2, i + 1, j + mappedStr.length(), map);
        } else {
            for (int k = j; k < s2.length(); k++) {
                String newStr = s2.substring(j, k + 1);
                map.put(c, newStr);
                if (isMatchHelper(s1, s2, i + 1, k + 1, map)) return true;
                map.remove(c);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(isMatch(s1, s2));
    }
}

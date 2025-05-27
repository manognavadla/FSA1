/*
 * You are given two strings. Determine whether the first string can be converted to the second 
by replacing each character with a unique character while preserving the order.

Each character from the first string must map to one and only one character in the second string and vice versa.
Note: Two characters in the first string cannot map to the same character in the second.

Explanation:
------------
Two strings are isomorphic if:
•	Each character in the first-string maps to one unique character in the second string.
•	This mapping must be consistent throughout the string.
•	No two different characters from the first-string map to the same character in the second string.


Input Format:
-------------------
Line-1: two space-separated strings

Output Format:
----------------------
Line-1: Boolean value True/False


Sample Input-1:
---------------
ACAB XCXY

Sample Output:
----------------------
True

Explanation:
------------
A → X, C → C, B → Y — all mappings are unique and consistent.


Sample Input:
---------------------
FOO BAR

Sample Output:
----------------------
False

 */
import java.util.*;
class IsomorphicStringsCheck{
    static boolean isIso(String a, String b){
        if(a.length()!=b.length()) return false;
        Map<Character,Character> hm= new HashMap<>();
        Map<Character,Character> hm2= new HashMap<>();
        int i=0,j=0;
        while(i<a.length() && j<b.length()){
            if(hm.containsKey(a.charAt(i)) && b.charAt(j)!=hm.get(a.charAt(i)))return false;
            if(hm2.containsKey(b.charAt(j)) && a.charAt(i)!=hm2.get(b.charAt(j)))return false;
            if(!hm.containsKey(a.charAt(i))) hm.put(a.charAt(i),b.charAt(j));
            if(!hm2.containsKey(b.charAt(j))) hm2.put(b.charAt(j),a.charAt(i));
            i++;j++;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String a= sc.next();
        String b=sc.next();
        System.out.print(isIso(a,b));
    }
}
/*
 * A text editor application allows users to perform automated corrections in documents. 
The feature scans the document and replaces every distinct instance of a specified incorrect phrase with a corrected one.
However, to avoid infinite loops and ambiguity, the editor replaces only non-overlapping occurrences of the phrase from left to right, one at a time.

Input Format:
-------------------------  
Line-1: A string `S` representing the original word
Line-2: A string `P` representing the pattern to be replaced
Line-3: A string `R` representing the replacement phrase (Special character) 

Output Format:
-------------------------
A string with all non-overlapping occurrences of `P` in `S` replaced with `R`

Example
--------
Input:
word = "ABCABCXABC";
pattern = "ABC";
ch = '@';
Explanation:
Original string:  A B C A B C X A B C
                  [ABC] [ABC]   [ABC] → all 3 are non-overlapping
Output:@ @ X @

Sample Input:
-------------------- 
ABABABAB
AB
@
Sample Output:
-----------------------
@@@@

 */
import java.util.*;
public class ReplaceString {
    static String replace(String s, String p, String r){
        int i=0;
        int l=s.length();
        int t=p.length();
        if(t>l) return s;
        if(l==0 || t==0) return s;
        StringBuilder sb= new StringBuilder();
        while(i<=l-t){
            if(s.substring(i,i+t).equals(p)){
                    sb.append(r);
                    i+=t;
            }else{
                sb.append(s.charAt(i));
                i++;
            }
        }
        while(i<l) {
            sb.append(s.charAt(i));i++;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        String p=sc.nextLine();
        String r= sc.nextLine();
        System.out.print(replace(s,p,r));
    }
}

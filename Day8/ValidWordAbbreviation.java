package Day8;
/*
 * Given a non-empty string s and an abbreviation abbr, 
return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Notice that only the above abbreviations are valid abbreviations of the string "word". 
Any other string is not a valid abbreviation of "word".

Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Input Format:
-------------
Line-1: A string, S contains only lowercase letters
Line-2: A string, abbr contains lowercase letters and digits

Output Format:
--------------
Line-1: A boolean value.
Sample Input-1:
---------------
internationalization
i12iz4n

Sample Output-1:
---------------
true

Sample Input-2:
---------------
apple
a2e

Sample Output-2:
---------------
false

Time Complexity: O(n) where n=max(len(word),len(abbr))
Auxiliary Space:  O(1).
 */
import java.util.*;
class ValidWordAbbreviation{
    public static boolean valid(String s, String s1){
        int i=0,j=0;
        while(i<s.length() && j<s1.length() ){
            if(s.charAt(i)==s1.charAt(j)){
                i++;j++;
                continue;
            }
            if(s1.charAt(j)<='0' || s1.charAt(j)>'9') return false;
            else if(s1.charAt(j)>'0' && s1.charAt(j)<='9'){
                int start=j;
                while(j<s1.length() && s1.charAt(j)>='0' && s1.charAt(j)<='9' ) j++;
                int num= Integer.parseInt(s1.substring(start,j));
                i+=num;
            }
        }
        
        return (i==s.length() && j==s1.length());
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s=sc.next();
        String s1=sc.next();
        System.out.print(valid(s,s1));
    }
}
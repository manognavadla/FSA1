/*
 * Alice and Bob have their own task lists represented as strings. 
Each character is a task. You need to find all valid ways to create a 
shared task schedule that includes all tasks from both lists, but without 
changing the order of tasks for either person.

Explanation:
-------------
An interleaving of two strings X and Y is a combination of characters where:
•	All characters from both strings are used exactly once.
•	The order of characters from each original string is maintained.
Example:
---------
If X = "AB" and Y = "CD", valid interleaving’s are:
•	"ABCD" (A→B→C→D),
•	"ACBD" (A→C→B→D),
•	"ACDB", "CABD", "CADB", "CDAB"

Input Format:
-------------------
Line-1: two space-separated strings

Output Format:
----------------------
Line-1: List of strings(interleaving’s) that matches order of characters.


Sample Input-1:
---------------
ABC ACB

Sample Output-1:
---------------
[AACBCB, ABCACB, ACBABC, ABACCB, ACABCB, AABCCB, ACABBC, AACBBC, ABACBC, AABCBC]


Sample Input-2:
---------------
12 AB

Sample Output-2:
----------------
[12AB, 1A2B, 1AB2, A12B, A1B2, AB12]

 */

 import java.util.*;
class InterleavingStringsFormattedInput{
    static void helper(String a, String b, int i, int j, List<String> res, StringBuilder cur){
        if(i==a.length() &&j==b.length()){
            res.add(cur.toString());
            return;
        }
       if(i<a.length()){
           cur.append(a.charAt(i));
           helper(a,b,i+1,j,res,cur);
           cur.deleteCharAt(cur.length()-1);
       }
       if(j<b.length()){
           cur.append(b.charAt(j));
           helper(a,b,i,j+1,res,cur);
           cur.deleteCharAt(cur.length()-1);
       }
    }
    public static List<String> interleave(String a, String b){
        if(a.length()==0) return Arrays.asList(b);
        if(b.length()==0) return  Arrays.asList(a);
        List<String> res= new ArrayList<>();
        helper(a,b,0,0,res, new StringBuilder());
        return res;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String a= sc.next().trim();
        String b=sc.next().trim();
        List<String> res=interleave(a,b);
       
        System.out.print(res);
        
    }
}
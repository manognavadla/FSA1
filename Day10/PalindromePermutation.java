package Day10;
/*
 * AlphaCipher is a string formed from another string by rearranging its letters

You are given a string S.
Your task is to check, can any one of the AlphaCipher is a palindrome or not.

Input Format:
-------------
A string S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
carrace

Sample Output-1:
----------------
true


Sample Input-2:
---------------
code

Sample Output-2:
----------------
false
 */
import java.util.*;
public class PalindromePermutation {
    static boolean palindrome(String s){
        int x=0;
        for(int i=0;i<s.length();i++){
            int n=s.charAt(i)-'a';
            x=x^(1<<n);
        }
        if(x==0 || ((x&(x-1))==0)) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s=sc.next();
        System.out.println(palindrome(s));
    }
}

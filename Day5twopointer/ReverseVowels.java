package Day5twopointer;
/*
 * Given a string s, reverse only all the vowels in the 
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
appear in both lower and upper cases, more than once.

Sample Input-1:
---------------
hello

Sample Output-1:
----------------
holle

Sample Input-2:
----------------
Keshavmemorial

Sample Output-2:
----------------
Kashivmomerael

 */
import java.util.*;
class ReverseVowels{
    public static String reverse(String s){
        int i=0,j=s.length()-1;
        String[] str= s.split("");
        String v="aeiouAEIOU";
        while(i<=j){
            if(v.contains(str[i]) && v.contains(str[j])){
                String t=str[i];
                str[i]=str[j];
                str[j]=t;
                i++;j--;
            }
            else if(v.contains(str[i])&& ! v.contains(str[j])) j--;
            else if(!v.contains(str[i]) && v.contains(str[j]) ) i++;
            else{
                i++;
                j--;
            }
            
        }
        StringBuilder string= new StringBuilder();
        for(String p: str){
            string.append(p);
        }
        return string.toString();
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        String s=sc.next();
        System.out.println(reverse(s));
    }
}
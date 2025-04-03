package Day4;
/*
 * A string is good if there are no repeated characters.
Given a string s, return the number of good substrings of length three in s.
Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
A substring is a contiguous sequence of characters in a string.

Sample Input-1:
---------------
xyzzaz

Sample Output-1:
----------------
1

Explanation: 
------------
There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".

Sample Input-2:
---------------
aababcabc

Sample Output-2:
----------------
4

Explanation: 
------------
There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".
 */import java.util.*;
class GoodStrings{
    public static void main(String[] args){
        Scanner sc= new Scanner (System.in);
        String s= sc.next();
        System.out.println(good(s));
    }
    public static int good(String s){
        if(s.length()<3){
            return 0;
        }
        Map<Character,Integer> map= new HashMap<>();
        int res=0,left=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            
            if(i-left+1>3){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            if(map.size()==3 ){
                res++;
            }
        }
        return res;
    }
}
/*
 * A secret agent receives a list of encrypted codewords. 
Each codeword must follow the same symbol sequence as a given prototype code. 
Your mission is to find which codewords follow the same symbol arrangement.

NOTE:
Matching is not about the actual characters, but how they repeat.
For example, “moon” = m o o n → pattern: first letter, two repeated letters, and a unique last letter.

Input Format:
-------------
Line-1: A space-separated list of words 
Line-2: A string representing the reference pattern

Output Format:
---------------------
Line-1: A list of words that follow the same pattern, if not found print -1


Sample Input-1:
---------------
Leet abcd loot geek cool for peer dear seed meet noon mess loss
moon

Sample Output-1:
----------------
leet loot geek cool peer seed meet


Sample Input-2:
----------------
leet abcd loot geek cool for peer dear
lamp

Sample Output-2:
----------------
abcd dear

 */
import java.util.*;
class FindPattern{
    static List<Integer> encode(String s){
        List<Integer> arr= new ArrayList<>();
        HashMap<Character,Integer> hm= new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),i);
            }
            arr.add(hm.get(s.charAt(i)));
        }
        return arr;
    }
    static List<String> match(String[] strs, String base){
        List<String> res= new ArrayList<>();
        List<Integer> mask=encode(base);
        for(String s: strs){
           if(encode(s).equals(mask)){
               res.add(s);
           }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String[] strs= sc.nextLine().split(" ");
        String base= sc.nextLine();
        List<String> res=match(strs,base);
        if(res.size()==0) {System.out.print("-1");
        return;}
        System.out.print(res);
    }
}
/*
 * class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (check(word, pattern)) res.add(word);
        }
        return res;
    }
    
    boolean check(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.indexOf(a.charAt(i)) != b.indexOf(b.charAt(i))) return false;
        }
        return true;
    }
}
 */
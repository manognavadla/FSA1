/*
 * In the ancient land of Palindoria, wizards write magical spells as strings of lowercase letters. However, for a spell to be effective, each segment of the spell must read the same forward and backward.

Given a magical spell 'spell', your task is to partition it into sequences of valid magical spell segments. 

Your goal is to help the wizard discover all valid combinations of magical spell segmentations.

Sample Input-1:
---------------
aab
  
Sample Output-1:  
----------------
[[a, a, b], [aa, b]]

Sample Input-2:
--------------- 
a
  
Sample Output-2:  
----------------
[[a]]

Spell Constraints:
------------------
- The length of the spell is between 1 and 16 characters.  
- The spell contains only lowercase English letters.  

 */
import java.util.*;
public class MagicSpell {
    static boolean isPaln(String s){
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
    static List<List<String>> spell(String s){
        List<List<String>> res= new ArrayList<>();
        util(s,0, new ArrayList<String>(),res);
        return res;
    }
    static void util(String s, int ind, List<String>curr, List<List<String>>res){
        if(ind==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=ind;i<s.length();i++){
            String t=s.substring(ind,i+1);
            if(isPaln(t)){
                curr.add(t);
                util(s, i+1, curr, res);
                curr.remove(curr.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s=sc.next();
        System.out.println(spell(s));
    }
}

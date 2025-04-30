package Day39;
/*
 * Vihaar is working with strings. 
He is given two strings A and B, and another string T,
where the length of A and B is same.

You can find the relative groups of letters from A and B,
using the following rule set:
- Equality rule: 'p' == 'p'
- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.

Vihaar has to form the relatively smallest string of T,
using the relative groups of letters.

For example, if A ="pqr" and B = "rst" , 
then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

The relatives groups formed using above rule set are as follows: 
[p, r, t] and [q,s] and  String T ="tts", then relatively smallest string is "ppq".

You will be given the strings A , B and T.
Your task is to help Vihaar to find the relatively smallest string of T.


Input Format:
-------------
Three space separated strings, A , B and T

Output Format:
--------------
Print a string, relatively smallest string of T.


Sample Input-1:
---------------
kmit ngit mgit

Sample Output-1:
----------------
ggit

Explanation: 
------------
The relative groups using A nd B are [k, n], [m, g], [i], [t] and
the relatively smallest string of T is "ggit"


Sample Input-2:
---------------
attitude progress apriori

Sample Output-2:
----------------
aaogoog

Explanation: 
------------
The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
the relatively smallest string of T is "aaogoog"
 */
import java.util.*;
class DisjointUnionSets{
    int[] rank,parent;
    public DisjointUnionSets(){
        parent=new int[26];
        for(int i=0;i<26;i++) parent[i]=i;
        
    }
    int find(int x){
        if(parent[x]==x) return x;
        return find(parent[x]);
    }
    void union(char xr, char yr){
        int x=find(xr-'a');
        int y=find(yr-'a');
        if(x==y){return;
        }else if(x<y){
            parent[y]=x;
        }else{
            parent[x]=y;
        }
    }
}
class SmallestString{
    static String small(String s, String t, String r,DisjointUnionSets dus){
        if (s.length() != t.length()) return r;
        for (int i = 0; i < s.length(); i++) {
            dus.union(s.charAt(i), t.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r.length(); i++) {
            int smallest = dus.find(r.charAt(i) - 'a');
            sb.append((char) (smallest + 'a'));
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s=sc.next();
        String t=sc.next();
        String r=sc.next();
        DisjointUnionSets dus= new DisjointUnionSets();
        System.out.print(small(s,t,r,dus));
    }
}
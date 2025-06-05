package Day33;
/*
 * An 8th standard student has been assigned a task as part of punishment for his mistake.

The task is, there is an input string STR(without any space) and an array of 
strings words[]. Print all the pairs of indices [s, e] where s, e are starting 
index and ending index of every string in words[] in the input string STR.

Note: Print the pairs[s, e] in sorted order.
(i.e., sort them by their first coordinate, and in case of ties sort them by 
their second coordinate).

Input Format
------------
Line-1: string STR(without any space)
Line-2: space separated strings, words[]

Output Format
-------------
Print the pairs[s, e] in sorted order.


Sample Input-1:
---------------
thekmecandngitcolleges
kmec ngit colleges

Sample Output-1:
----------------
3 6
10 13
14 21


Sample Input-2:
---------------
xyxyx
xyx xy

Sample Output-2:
----------------
0 1
0 2
2 3
2 4

Explanation: 
------------
Notice that matches can overlap, see "xyx" is found at [0,2] and [2,4].


Sample Input-3:
---------------
kmecngitkmitarecsecolleges
kmit ngit kmec cse

Sample Output-3:
----------------
0 3
4 7
8 11
15 17

 */
import java.util.*;
class Trie{
    Trie[] children=new Trie[26];
    boolean isEnd=false;
    void insert(String word){
        Trie node =this; 
        for(char c:word.toCharArray()){
            c-='a';
            if(node.children[c]==null){
                node.children[c]=new Trie();
            }
            node=node.children[c];
        }
        node.isEnd=true;
    }
}
class IndexPairs{
    public static int[][] indexPairs(String text,String[] words){
        Trie trie=new Trie();
        for(String w:words){
            trie.insert(w);
        }
        int n=text.length();
        List<int[]> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            Trie node=trie;
            for(int j=i;j<n;j++){
                int idx=text.charAt(j)-'a';
                if(node.children[idx]==null){
                    break;
                }
                node=node.children[idx];
                if(node.isEnd){
                    ans.add(new int[]{i,j});
                }
            }
        }
        // System.out.println(ans);
        return ans.toArray(new int[ans.size()][2]);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        String[] words=sc.nextLine().trim().split(" ");
        int[][] ans=indexPairs(text,words);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
 }
}
}

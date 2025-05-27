package Day30;
/*
 * You are given an array of people, which are the attributes of some people in 
a queue (not necessarily in order). 
Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki 
other people in front who have a height greater than or equal to hi.

Reconstruct and return the queue that is represented by the input array people. 
The returned queue should be formatted as an array queue, where queue[j] = [hj, kj]
is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).

Input Format : 
--------------
Line-1: An integer n
Line-2: n number of pairs

Output Format : 
--------------
list of n pairs

Sample Input-1:
---------------
6
7 0
4 4
7 1
5 0
6 1
5 2

Sample Output-1: 
---------------
[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

Explanation:
Person 0 has height 5 with no other people taller or the same height in front.
Person 1 has height 7 with no other people taller or the same height in front.
Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
Person 3 has height 6 with one person taller or the same height in front, which is person 1.
Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
Person 5 has height 7 with one person taller or the same height in front, which is person 1.
Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.

Sample Input-2:
--------------
6
6 0 
5 0 
4 0
3 2
2 2
1 4

Sample Output-2: 
----------------
[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 

Constraints:
-------------
1 <= people.length <= 2000
0 <= hi <= 106
0 <= ki < people.length
It is guaranteed that the queue can be reconstructed.
 */
import java.util.*;
public class RearrangeQueue {
    public static  List<int[]>rearrang(int[][] people){
        for (int i = 0; i < people.length; i++) {
            for (int j = i + 1; j < people.length; j++) {
                if (people[i][0] < people[j][0] || 
                    (people[i][0] == people[j][0] && people[i][1] > people[j][1])) {
                    int[] temp = people[i];
                    people[i] = people[j];
                    people[j] = temp;
                }
            }
        }
        List<int[]> result = new ArrayList  <>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result;
    }
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       int n=sc.nextInt();
       int[][]arr = new int[n][2];
       for(int i=0;i<n;i++){
        arr[i][0]=sc.nextInt();
        arr[i][1]=sc.nextInt();
       }
       List<int[]> res=rearrang(arr);
       for (int[] person : res) {
        System.out.print("[" + person[0] + "," + person[1] + "] ");
    }
    }
    
}

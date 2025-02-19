package Day9;
/*
 * Mr Bond is a spy and he is working on a mission to solve that mission he needs 
list of numbers which are password to a secret locker, he got a secret code from his informer 
which consists of a circular array code of length of n and a key k.

To decrypt the code, he must replace every number. All the numbers are replaced simultaneously.
with your programming skills help bond to decrypt the code.
The following are the rules to be followed to decrypt the code.

If k > 0, replace the ith number with the sum of the next k numbers.
If k < 0, replace the ith number with the sum of the previous k numbers.
If k == 0, replace the ith number with 0.

As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].

Input Format: 
-------------
Line-1: An integer (n)
Line-2: n space separated integers
Line-3: An integer (k)

Output Format:
---------------
Line-1: list of integers

Sample Input-1:
---------------
4
5 7 1 4
3

Sample Output-1: 
----------------
[12,10,16,13]

Explanation: Each number is replaced by the sum of the next 3 numbers. 
The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.

Sample Input-2:
---------------
4
1 2 3 4
0

Sample Output-2:
----------------
[0,0,0,0]

Explanation: When k is zero, the numbers are replaced by 0. 

Sample Input-3:
---------------
4
2 4 9 3
-2

Sample Output-3:
----------------
[12,5,6,13]

Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. 
Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
 

Constraints:

n == code.length
1 <= n <= 100
1 <= code[i] <= 100
-(n - 1) <= k <= n - 1
 */
import java.util.*;
public class Decode{
   
    public static List<Integer> pass(int n, int[] arr, int w){
  List<Integer> res= new ArrayList<>(Collections.nCopies(n,0));
  if(w==0) return res;
       int sum=0;
       if(w>=0){
       for(int i=1;i<=w;i++) sum+=arr[i%n];
       res.add(sum);
       for(int j=1;j<n;j++){
           sum-=arr[j];
           sum+=arr[(j+w)%n];
           res.add(sum);
       }
           
       }
       else if(w<0){
           w=Math.abs(w);
           for(int j=n-w;j<n;j++) sum+=arr[j%n];
           res.set(0,sum);
           for(int j=1;j<n;j++){
               sum+=arr[(j-1)%n];
               sum-=arr[Math.abs((j-w+n-1)%n)];
               res.set(j,sum);
           }
       }
       
        return res;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int w=sc.nextInt();
        System.out.println(pass(n,arr,w));
    }
}
/*
 * import java.util.*;

public class Decrypt {
    public static List<Integer> decryptCode(int n, int[] code, int k) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));

        if (k == 0) return result; // If k == 0, return an array of zeros

        int sum = 0, w = Math.abs(k); // Window size (always positive)
        int start = k > 0 ? 1 : n - w; // Start index for sum calculation

        // Compute initial window sum
        for (int i = 0; i < w; i++) {
            sum += code[(start + i) % n];
        }

        // Sliding window approach
        for (int i = 0; i < n; i++) {
            result.set(i, sum);
            sum -= code[(start + i) % n];  // Remove the outgoing element
            sum += code[(start + i + w) % n]; // Add the incoming element
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] code = new int[n];

        for (int i = 0; i < n; i++) {
            code[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        System.out.println(decryptCode(n, code, k));

        sc.close();
    }
}

 */
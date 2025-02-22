package Day11;
/*
 * Birbal is creating a new binary code system BBC (Birbal Binary Code) as follows:

I	f(I)
-------
0	""
1	"0"
2	"1"
3	"00"
4	"01"
5	"10"
6	"11"
7	"000"

You are given an integer value I, where I is positive number.
Your task is to find BBC representation of  the given number I.

Input Format:
-------------
Line-1: An integer I

Output Format:
--------------
Line-2: Print the BBC representation of I.


Sample Input-1:
---------------
23

Sample Output-1:
----------------
1000


Sample Input-2:
---------------
45

Sample Output-2:
----------------
01110

 */
import java.util.*;
public class EncodeNumber {
    public static String encode(int n){
        StringBuilder sb= new StringBuilder();
        while(n>0){
            if((n&1)==1) sb.append(1);
            else sb.append(0);
            n=n>>1;
        }
        sb.reverse();
        return sb.substring(1);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(encode(n+1));
    }
}

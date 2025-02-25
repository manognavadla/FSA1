package Day8;
/*
 * You are given an array nums of size n+1, 
where each element is an integer between 1 and n (inclusive).

The array contains exactly one duplicated number, 
which appears at least twice, while all other numbers appear exactly once.

Your task is to find and return the repeated number without modifying the array 
and using only constant extra space.

NOTE: For boundary conditions print -1.

Input Format:
-------------
Line 1: An integer N, representing n (the range of numbers).
Line 2: N+1 space-separated integers representing the array nums.

Output Format:
--------------
Line-1: A single integer representing the duplicate number.

Sample Input-1:
---------------
4
1 3 4 2 2

Sample Output-1:
----------------
2

Sample Input-2:
---------------
4
3 1 3 4 2

Sample Output-2:
----------------
3

Sample Input-3:
---------------
4
5 4 3 2 3

Sample Output-3:
---------------
-1

Constraints:
-------------
-> 1 ≤ n ≤ 10⁵
-> nums.length = n + 1
-> 1 ≤ nums[i] ≤ n
-> All numbers appear exactly once except for one number which appears at least twice.

 */
import java.util.*;
public class RemoveOneDuplicate {
    public static void main(String[] args) {
        System.out.println((1^2^3^4));
        System.out.println((1^2^3^4^3));
        System.out.println(((1^2^3^4)^(1^2^3^4^3)));
    }
}

package Day15;
/*
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:
input =1432219
3
output =1219

num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.


Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

 */import java.util.*;
public class RemoveKdigits{
    public static int kdigit(String s, int k){
        int n=s.length();
        if(k==n) return 0;
        if(k==0) return Integer.parseInt(s);
        // List<Character> res= new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i;
        for(i=0;i<n-1 && k>0;i++){
            if(s.charAt(i) < s.charAt(i+1)){
                if(sb.length()==0){
                    sb.append(s.charAt(i));
                }
                else{
                    while((sb.charAt(sb.length()-1)>s.charAt(i)) && k>0){
                        sb.deleteCharAt(sb.length()-1);
                        k--;
                        }
                    sb.append(s.charAt(i));
                }                
            }else{
                k--;
            }
        }
        if(i<n-1){
            while(i<n){
                sb.append(s.charAt(i));i++;
                }
        }
        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s= sc.next();
        int k= sc.nextInt();
        System.out.println(kdigit(s,k));
    }

}
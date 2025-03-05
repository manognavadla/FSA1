package Day17;
/*
 * Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.

Your task is to solve this problem using Fenwick Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input-1:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
2 2 18	//update
2 4 17	//update
1 2 7		//sumRange

Sample Output-1:
----------------
75
86
80



Sample Input-2:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		
1 0 7		
2 2 18	
2 4 17	
1 0 7

Sample Output-2:
----------------
75
86
83

 */
import java.util.*;
class FenWickTree{
    static int[] BITS;
     static void init(int i, int val, int n){
        i++;
        while(i<=n){
            BITS[i]+=val;
            i+=(i& -i);
        }
    }
    static void update(int i, int val,int[] arr){
        int d=val-arr[i];
        arr[i]=val;
        init(i,d,arr.length);
    }
    static int getSum(int i){
        i++;int sum=0;
        while(i>0){
            sum+=BITS[i];
            i-=(i&-i);
        }
        return sum;
    }
    static int sumRange(int i, int j){
        return getSum(j)-getSum(i-1);
    }
     static void fenwick(int[]arr,int[][]oper,int n, int op){
        int i=0;
        while(i<n){
            init(i,arr[i],n);i++;
        }
        for( i=0;i<op;i++){
            if(oper[i][0]==1){
                System.out.println(sumRange(oper[i][1],oper[i][2]));
            }else if(oper[i][0]==2){
                update(oper[i][1],oper[i][2], arr);
            }
        }
        
    }
    
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int op=sc.nextInt();
        int [] arr= new int[n];
        BITS= new int[n+1];
        int[][] oper= new int[op][3];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        for(int i=0;i<op;i++){
            for(int j=0;j<3;j++){
                oper[i][j]=sc.nextInt();
            }
        }
        fenwick(arr,oper,n,op);
    }
}
package Day18;
/*
 * Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.

Your task is to solve this problem using Segment Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input:
-------------
5 5
4 2 13 3 25
1 0 4		//sumRange
1 1 3		//sumRange
2 2 18	//update
2 4 17	//update
1 0 4		//sumRange

5 5
4 2 13 3 25
1 0 4
1 1 3
2 2 18	
2 4 17
1 0 4	

Sample Output:
--------------
47
18
44

 */
import java.util.*;
class Segment{
    int start,end,sum;
    Segment left,right;
    Segment(int start , int end){
        this.start=start;
        this.end= end;
        this.left=null;
        this.right=null;
        this.sum=0;
    }
}
class SegmentTreeTest{
    public static Segment build(int[] nums, int start, int end){
        if(start>end) return null;
        else
       { Segment ret= new Segment(start,end);
        if(start==end) ret.sum=nums[start];
        else{
            int mid= start+(end-start)/2;
            ret.left=build(nums,start,mid);
            ret.right=build(nums,mid+1,end);
            ret.sum=ret.left.sum+ret.right.sum;
        }
        return ret;
        }
    }
    public static int sumRange(Segment root, int start, int end) {
        if (root == null || start > root.end || end < root.start) return 0; // Out of range
        if (start <= root.start && end >= root.end) return root.sum; // Full coverage
        return sumRange(root.left, start, end) + sumRange(root.right, start, end); // Partial overlap
    }

    // Update Query
    public static void update(Segment root, int index, int value) {
        if (root == null) return;
        if (root.start == root.end && root.start == index) { // Leaf node
            root.sum = value;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (index <= mid) update(root.left, index, value);
        else update(root.right, index, value);
        root.sum = root.left.sum + root.right.sum; // Recalculate sum
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int op=sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        int[][]oper= new int[op][3];
        for(int i=0;i<op;i++){
            for(int j=0;j<3;j++){
                oper[i][j]=sc.nextInt();
            }
        }
    }
}
package Day19;
/*
 * Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.
3. Find the min value in the given range
4. Find the max value in the given range 

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
8 7
4 2 13 3 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
3 2 6       //get max value in the range
2 2 18	    //update
2 4 17	    //update
1 2 6		//sumRange
4 1 5       // get min value in the range
 

Sample Output:
--------------
74
88
25
71
2
 */
import java.util.*;
class Segment{
    int sum,min, max,start,end;
    Segment left,right;
    Segment(int start, int end){
        this.start=start;
        this.end= end;
        this.min=Integer.MAX_VALUE;
        this.max=Integer.MIN_VALUE;
        this.sum=0;
        this.left=null;
        this.right=null;
    }
}

class SegmentTreeTest{
    public static void segmenttree(int n, int op, int[] arr, int[][]oper){
        Segment head= build(arr, 0, n-1);
        for(int i=0;i<op;i++){
             if(oper[i][0]==1){
                 System.out.println(sumRange(head,oper[i][1],oper[i][2]));
            }else if(oper[i][0]==2){
                update(head,oper[i][2],oper[i][1]);
            }else if(oper[i][0]==3){
                System.out.println(maximum(head,oper[i][1],oper[i][2]));
            }else{
            System.out.println(minimum(head,oper[i][1],oper[i][2]));       
        }
    }
    }
    public static Segment build(int[] arr, int start, int end){
        if(start>end) return null;
        else{
            Segment head= new Segment(start,end);
            if(start==end){
                head.sum=arr[start];
                head.min=Math.min(head.min,arr[start]);
                head.max=Math.max(head.max,arr[start]);
            }
            else{
                int mid= start+(end-start)/2;
                head.left=build(arr,start, mid);
                head.right= build(arr, mid+1, end);
                head.sum=head.left.sum+ head.right.sum;
                 head.min=Math.min(head.right.min,head.left.min);
                head.max=Math.max(head.left.max,head.right.max);
            }
            return head;
        }
    }
    public static int sumRange(Segment root, int start, int end){
        if(start> end || root==null) return 0;
        if(start<=root.start && end>=root.end) return root.sum;
        return sumRange(root.left,start,end)+sumRange(root.right,start,end);
    }
    public static int minimum(Segment root , int start, int end){
        if(start>root.end|| end<root.start || root==null) return Integer.MAX_VALUE;
        if(start<= root.start && end>=root.end) return root.min;
        return Math.min(minimum(root.left,start,end),minimum(root.right,start,end));

    }
    public static int maximum(Segment root , int start, int end){
        if(start>root.end|| end<root.start || root==null) return Integer.MIN_VALUE;
        if(start<= root.start && end>=root.end) return root.max;
        return Math.max(maximum(root.left,start,end),maximum(root.right,start,end));

    }
    public static void update(Segment root, int val, int index){
        if(root==null) return;
        if(root.start==root.end && root.start==index){
            root.sum=val;
            root.min=val;
            root.max=val;
            return;
        }
        int mid= root.start+(root.end-root.start)/2;
        if(index<=mid) update(root.left, val, index);
        else update(root.right, val, index);
        root.sum=root.left.sum+root.right.sum;
        root.min=Math.min(root.left.min, root.right.min);
        root.max= Math.max(root.left.max, root.right.max);
    }
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int op = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int[][] oper = new int[op][3];
        for (int i = 0; i < op; i++) {
            for (int j = 0; j < 3; j++) {
                oper[i][j] = sc.nextInt();
            }
        }
        segmenttree(n, op,arr,oper);
    }
}
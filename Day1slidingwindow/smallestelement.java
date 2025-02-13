package Day1slidingwindow;
/*
CP_U1_AP1_SmallestElement
 * You are given an array consisting of N integers, and an integer, K. 
Your task is to determine the minimum element in subarrays of size K.

Sample Input1:
--------------
5
10 12 14 11 15
3

Sample Output1:
---------------
10 11 11

Sample Input2:
--------------
5
5 2 1 1 1
4

Sample Output2:
---------------
1 1


 */
import java.util.*;
class smallestelement{
    public static List<Integer> small(int n, int[] arr, int win){
        TreeMap<Integer,Integer> tm= new TreeMap<>();
        List<Integer> res= new ArrayList<>();
        for(int i=0;i<win;i++){
            tm.put(arr[i], tm.getOrDefault(arr[i],0)+1);
        }
        res.add(tm.firstKey());
        for(int j=win;j<n;j++){
            tm.put(arr[j-win], tm.get(arr[j-win])-1);
            if(tm.get(arr[j-win])==0){
            tm.remove(arr[j-win]);
            }
            tm.put(arr[j],tm.getOrDefault(arr[j],0)+1);
            res.add(tm.firstKey());
        }
        return res;
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        int win=sc.nextInt();
        System.out.println(small(n,arr,win));
    }
}
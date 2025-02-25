package Day2;
/*
CP_U1_AP2_DuplicateWindow
 * Given an integer array of nums and an integer window size X, 
return true if there are duplicate values (nums[i]== nums[j])in that Window(X)
X size is always <= abs(i - j) where i and j are two distinct indices of array.

Input Format:
-------------
Line-1: An integer N, Array Size
Line-2: Space separated integers, array elements
Line-3: An integer X, window size

Output Format:
--------------
Line-1: Booelan value, true/false


Sample Input-1:
---------------
4
1 2 3 1  
3 

Sample Output-1: 
----------------
false

Sample Input-2:
---------------
6
1 2 3 3 2 3
2

Sample Output-2: 
----------------
true
 */ 
import java.util.*;

 public class DuplicateWindow{
    public static boolean duplicate(int n, int[] arr, int k){
        // boolean b=false;
        HashMap<Integer,Integer> hmap= new HashMap<>();
        for(int i=0;i<k;i++){
            hmap.put(arr[i], hmap.getOrDefault(arr[i], 0)+1);
            if(hmap.get(arr[i])>1) return true;
        }
        for(int j=k;j<n;j++){
            hmap.put(arr[j-k],hmap.get(arr[j-k])-1);
            if(hmap.get(arr[j-k])==0){
                hmap.remove(arr[j-k]);
            }
            hmap.put(arr[j], hmap.getOrDefault(arr[j], 0)+1);
            if(hmap.get(arr[j])>1){
                return true;
            }
        }
    
        return false;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        int w=sc.nextInt();
        System.out.println(duplicate(n,arr,w));
    }
 }
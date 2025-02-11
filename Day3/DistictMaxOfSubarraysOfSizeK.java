import java.util.*;
class DistictMaxOfSubarraysOfSizeK {
    static int sumh(Map<Integer,Integer> hmap){
        int sum=0;
        for(int val:hmap.keySet()){
            sum+=val;
            }
        return sum;
        }
    static int Distinct(int[] arr, int win){
        int result=Integer.MIN_VALUE;
        Map<Integer,Integer> hmap= new HashMap<>();
        for(int i=0;i<win;i++){
            hmap.put(arr[i],hmap.getOrDefault(arr[i],0)+1);
        }
        int sum=0;
        if(win==hmap.size()){
              sum=sumh(hmap);
            }
            result=Math.max(result, sum);
        for(int i=win;i<arr.length;i++){
            int j=i-win;
            if(hmap.get(arr[j])==1){
                hmap.remove(arr[j]);
                }
            else{
                hmap.put(arr[j],hmap.get(arr[j])-1);
                }
            hmap.put(arr[i], hmap.getOrDefault(arr[i],0)+1);
            sum=0;
        if(win==hmap.size()){
                sum=sumh(hmap);
        }
        result=Math.max(result, sum);
}
        return result;
}
    public static void main(String[] arg){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int win= sc.nextInt();
        int arr[] =new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
}
        System.out.print(Distinct(arr,win));
}
}


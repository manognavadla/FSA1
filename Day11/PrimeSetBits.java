package Day11;

import java.util.*;

public class PrimeSetBits {
    public static boolean isPrime(int n){
        if(n==0 || n==1) return false;
        if(n==2) return true;
        for(int i=2;i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static int ones(int n){
        int count=0;
        while(n>0){
            if((n&1)==1) count++;
            n=n>>1;
        }
        return count;
    }
    public static int psb(int m, int n){
        int c=0;
        for(int i=m;i<=n;i++){
            if(isPrime(ones(i))) c++;
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(psb(m, n));
    }
}

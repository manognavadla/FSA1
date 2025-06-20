
import java.util.*;
class BinarySubString{
    public static boolean sub(String s,int n){
        Set<String> hs= new HashSet<>();
        for(int i=0;i<=s.length()-n;i++){
            hs.add(s.substring(i,i+n));
            if(hs.size()==Math.pow(2,n)) return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s= sc.next();
        int n= sc.nextInt();
        System.out.println(sub(s,n));
    }
}

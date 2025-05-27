import java.util.*;
class LetterCombination{
 
    static Map<String, List<String>> map= new HashMap<>();
    static{
        map.put("2",Arrays.asList("a","b","c"));
        map.put("3",Arrays.asList("d","e","f"));
        map.put("4",Arrays.asList("g","h","i"));
        map.put("5",Arrays.asList("j","k","l"));
        map.put("6",Arrays.asList("m","n","o"));
        map.put("7",Arrays.asList("p","q","r","s"));
        map.put("8", Arrays.asList("t","u","v"));
        map.put("9",Arrays.asList("w","x","y","z"));
    
        }
    static List<String> sol(String digits){
        List<String> res= new ArrayList<>();
        util(digits,new StringBuilder(), 0,res);
        return res;
    }
    static void util(String digits, StringBuilder sb, int i,List<String> res){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
            return;
        }
        List<String> c= map.get(String.valueOf(digits.charAt(i)));
        for(String s: c){
            sb.append(s);
            util(digits,sb,i+1,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String digits= sc.nextLine();
        System.out.print(sol(digits));
    }
}
/*  */
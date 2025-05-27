import java.util.*;

class UniqueSplits {

    public static int maxUniqueChunks(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private static int backtrack(String s, int start, HashSet<String> seen) {
        if (start == s.length()) return 0;

        int maxChunks = 0;
        for (int end = start + 1; end <= s.length(); end++) {
            String chunk = s.substring(start, end);
            if (!seen.contains(chunk)) {
                seen.add(chunk);
                int nextChunks = 1 + backtrack(s, end, seen);
                maxChunks = Math.max(maxChunks, nextChunks);
                seen.remove(chunk); 
            }
        }
        return maxChunks;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int result = maxUniqueChunks(s);
        System.out.println(result);
    }
}

/*
 * Problem Statement
In the realm of Numeria, a land where numbers hold ancient secrets, you are presented with a set of magical prefix integers. These prefixes serve as keys to unlock hidden prime numbers scattered throughout the kingdom. However, only the prime numbers that fall within the sacred range from 1 to 100,000 are of interest.

Your task is to embark on a quest to count the total number of unique prime numbers that start with any of the given prefix integers. A prime number is said to have a prefix if its decimal representation begins with the sequence making up that prefix. For instance, if one of the given prefixes is 23, then any prime number that starts with 23 (such as 23, 233, 2371, etc.) would be considered.

Important Considerations:
Unique Counting:
A prime number might have multiple valid prefixes. For example, the prime 293 has prefixes 2, 29, and 293. Despite this, it should be counted only once.

Only of Interest:
Only consider prime numbers between 1 and 100,000.

Example Scenario:
If the provided prefix integers are {23, 5, 19}, your challenge is to determine how many unique prime numbers within the specified range begin with "23", "5", or "19".

Can you harness your mathematical prowess and algorithmic skills to traverse Numeria’s prime landscape, ensuring that each prime number is counted only once, and ultimately reveal the total count of these elusive prime numbers?

Input Format
The first line of input contains a single integer N representing the number of prefix integers.

The next line contains N space-separated integers representing the prefix integers.

Output Format
Print a single integer representing the count of unique prime numbers that have any of these integers as a prefix.

Constraints
1 ≤ N ≤ 5 × 10⁶

1 ≤ prefix ≤ 10⁹

1 ≤ prime ≤ 100,000


 */
import java.util.*;

public class PrimePrefixCounter {
    
    // Generate all primes up to 100000 using Sieve of Eratosthenes
    static List<Integer> generatePrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        // Read prefixes and store in a HashSet for O(1) lookup
        Set<String> prefixSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            prefixSet.add(sc.next());
        }

        // Generate all primes up to 100000
        List<Integer> primes = generatePrimes(100000);

        Set<Integer> uniquePrimes = new HashSet<>();

        for (int prime : primes) {
            String primeStr = String.valueOf(prime);
            // Check all possible prefixes of primeStr
            for (int len = 1; len <= primeStr.length(); len++) {
                String sub = primeStr.substring(0, len);
                if (prefixSet.contains(sub)) {
                    uniquePrimes.add(prime);
                    break; // Count each prime only once
                }
            }
        }

        System.out.println(uniquePrimes.size());
    }
}
/*
 * A communication researcher is analyzing a trail of signal frequencies encoded as a lowercase string. 
Each character in the string represents a frequency tone recorded in a timeline.

To evaluate the diversity of communication, the researcher wants 
to count how many distinct contiguous frequency patterns (substrings) are present in the entire signal trail. 
These patterns can be of any length and must be unique.

To accomplish this, you are tasked with writing an efficient algorithm using Trie (Prefix Tree) 
based suffix structures to count all distinct substrings of the given signal trail.

Input Format:
-------------
Line-1: A lowercase string s representing the frequency trail.

Output Format:
--------------
Line-1: Print a single integer — the number of distinct substrings of the input string.

Constraints:
-------------
-> 1 ≤ |s| ≤ 10^4
-> s contains only lowercase English letters.


Sample Input-1:
---------------
abc

Sample Output-1:
----------------
6

Explanation:
------------
The substrings are: "a", "b", "c", "ab", "bc", "abc".
Total = 6 distinct substrings.


Sample Input-1:
---------------
abc

Sample Output-1: 
----------------
6

Explanation:
------------
The substrings are: "a", "b", "c", "ab", "bc", "abc".
Total = 6 distinct substrings.


Sample Input-2:
---------------
aaa

Sample Output-2:
----------------
3

Explanation:
------------
Substrings: "a", "aa", "aaa" → 3 unique substrings.

// To find the count of distinct substring of a string using trie data structure*/

import java.util.*;

class Suffix
{
	static class SuffixTrieNode
	{
		static final int MAX_CHAR = 26;
		SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];

		SuffixTrieNode()
		{
			for (int i = 0; i < MAX_CHAR; i++)
				children[i] = null;
		}
		void insertSuffix(String s)
		{
			if (s.length() > 0)
			{
				char cIndex = (char) (s.charAt(0) - 'a');
				if (children[cIndex] == null)
				{
					children[cIndex] = new SuffixTrieNode();
				}
				children[cIndex].insertSuffix(s.substring(1));
			}
		}
	}
	static class Suffix_trie
	{
		static final int MAX_CHAR = 26;
		SuffixTrieNode root;
		Suffix_trie(String s) 
		{
			root = new SuffixTrieNode();
			for (int i = 0; i < s.length(); i++)
				root.insertSuffix(s.substring(i));
		}

	}
	static int countNodes(SuffixTrieNode node) {
		if (node == null) return 0;

		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (node.children[i] != null) {
				count += countNodes(node.children[i]);
			}
		}
		return count + 1;
	}

	static int countDistinctSubstring(String str) {
		Suffix_trie trie = new Suffix_trie(str);
		return countNodes(trie.root);
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any string to construct suffix tree");
		String str=sc.nextLine();		

		System.out.println((countDistinctSubstring(str) - 1));
		
	}
}
import java.util.*;

class Trie 
{	
	static final int NUM_CHARS = 26;
	// To handle prefix deletion
	static boolean isDeleted = false;	
	// trie node
	static class TrieNode
	{
		TrieNode[] children = new TrieNode[NUM_CHARS];
	
		// isEndOfWord is true if the node represents end of a word
		boolean isEndOfWord;
		
		TrieNode()
		{
			isEndOfWord = false;
			for (int i = 0; i < NUM_CHARS; i++)
				children[i] = null;
		} 
	};
	
	static TrieNode root;
	
	
	// If the key is prefix of trie node, just marks leaf node
	static void insert(String key)
	{
		int level;
		int length = key.length();
		int index;
	
		TrieNode currentNode = root;
	
		for (level = 0; level < length; level++){
			index = key.charAt(level) - 'a';
			if (currentNode.children[index] == null)
				currentNode.children[index] = new TrieNode();
	
			currentNode = currentNode.children[index];
		}
	
		// mark last node as leaf
		currentNode.isEndOfWord = true;

	}
	
	// Returns true if key (prefix or complete word) is present in trie, else false
	static boolean search(String key)
	{
		int level;
		int length = key.length();
		int index;
		TrieNode currentNode = root;
	
		for (level = 0; level < length; level++)
		{
			index = key.charAt(level) - 'a';
	
			if (currentNode.children[index] == null)
				return false;
	
			currentNode = currentNode.children[index];
		}
		return (currentNode.isEndOfWord);
	}
    static boolean isEmpty(TrieNode root)
    {
        for (int i = 0; i < NUM_CHARS; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }
    static TrieNode delete(TrieNode root, String key, int depth)
    {
        if (root == null)
            return null;
        if (depth == key.length()) 
		{ 
			isDeleted = root.isEndOfWord;
            if (root.isEndOfWord)
                root.isEndOfWord = false;
            if (isEmpty(root)) 
			{
                return null;
            } 
            return root;
        }
        int index = key.charAt(depth) - 'a';
		if (root.children[index] == null)
				return null;
        root.children[index] = delete(root.children[index], key, depth + 1);
        if (isEmpty(root) && root.isEndOfWord == false)
		{
            return null;
        } 
        return root;
    }
	static boolean isLeafNode(TrieNode root) 
	{
		return root.isEndOfWord == true;
	}
 
	// print Trie
	static void print(TrieNode root, char[] str, int level) 
	{
		// If node is leaf node, it indicates end of string, 
		// so a null character is added and string is printed
		if (isLeafNode(root)) 
		{
			for (int k = level; k < str.length; k++)
				str[k] = 0;
			System.out.println(str);
		}
	 
		int i;
		for (i = 0; i < NUM_CHARS; i++) 
		{
			// if NON NULL child is found add parent key to str and
			// call the print function recursively for child node
			if (root.children[i] != null) 
			{
				str[level] = (char) (i + 'a');
				print(root.children[i], str, level + 1);
			}
		}
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String keys[]=sc.nextLine().split(" ");	
		root = new TrieNode();
		// Construct trie
		int i;
		for (i = 0; i < keys.length ; i++)
			insert(keys[i]);

		char[] str = new char[50];
		String word;
	LABEL1: while(true)
		{
			int opt = sc.nextInt();
			sc.nextLine();
			switch(opt)
			{
				case 4:
					System.out.println("Content of Trie: ");
					print(root, str, 0);
					break;
				case  1:
					String s = sc.nextLine();
					insert(s);
					System.out.println("Content of Trie: ");
					print(root, str, 0);
					break;
				case 2:
					word = sc.next();
					if(search(word) == true)
						System.out.println(word + " is present ");
					else 
						System.out.println(word + " is not present");
					break;
				case 3:
					word = sc.next();
					if(delete(root, word, 0) != null & isDeleted == true)
						System.out.println(word + " is deleted ");
					else
						System.out.println(word + " is not present in Trie to be deleted");
					System.out.println("Content of Trie after deletion: ");
					print(root, str, 0);
					break;
				case 5:
					break LABEL1;
			}
		}
	}	
}
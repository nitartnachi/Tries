/*
 * Trie is an efficient information retrieval data structure. In our previous post on trie we have discussed about basics of trie and how to insert and search a key in trie. In this post we will discuss about displaying all of the content of a trie. That is, to display all of the keys present in the Trie.

Examples:

Input: If Trie is      root
                    /   \    \
                    t   a     b
                    |   |     |
                    h   n     y
                    |   |  \  |
                    e   s  y  e
                 /  |   |
                 i  r   w
                 |  |   |
                 r  e   e
                        |
                        r
Output: Contents of Trie:
        answer
        any
        bye
        their
        there
 */

package com.nitin.algo;

public class DisplayContents {
	
	private static TrieNode root;
	private static final int SIZE = 27;

	public DisplayContents() {
		System.out.println("Initialized Root");
		root = new TrieNode();
	}
	
	static class TrieNode{
		TrieNode[] children;
		String word; // to store the string for leaf node
		public TrieNode() {
			children = new TrieNode[SIZE];
		}
	}
	
	private static void insert(String city) {
		TrieNode node  = root;
		for(int i = 0 ; i < city.length(); i++) {
			char c = city.charAt(i);
			int index  = ((c - 'a') >= 0) ? c - 'a' : 26;
			if(node.children[index] == null) {
				TrieNode temp = new TrieNode();
				node.children[index] = temp;
				node = temp;
			}
			else {
				node = node.children[index];
			}
		}
		node.word = city;
		
	}
	
	public static void main(String[] args) {
		new DisplayContents();
		String[] cities = {"san francisco", "san ramon", "santa clara", "albany", "sunnyvale", "houston", "san jose"};
		for(String city : cities)
			insert(city);
		System.out.println("The cities are : ");
		displayContents(root);
	}

	private static void displayContents(TrieNode node) {
		if(node == null)
			return;
		for(int i = 0; i < SIZE; i++) {
			if(node.children[i] != null) {
				if(node.children[i].word != null)
					System.out.println(node.children[i].word);
				displayContents(node.children[i]);
			}
		}
	}

}

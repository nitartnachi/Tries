/*
 * Given a set of strings, sort them in lexographical(dictionary/alphabetic) order
 */

package com.nitin.algo;

public class LexographicSortingStrings {

	private static TrieNode root;
	private static final int SIZE = 27;

	public LexographicSortingStrings() {
		root  = new TrieNode();
	}

	static class TrieNode{
		TrieNode[] children;
		String word;
		public TrieNode() {
			children = new TrieNode[SIZE];
		}
	}

	private static void insert(String word) {
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = (c - 'a' >= 0) ? c - 'a' : 26; //setting 26 for space
			if(node.children[index] == null) {
				TrieNode temp = new TrieNode();
				node.children[index] = temp;
				node = temp;
			}else {
				node  = node.children[index];
			}
		}
		node.word = word;
	}

	private static void preOrder(TrieNode node) {
		if(node == null)
			return;
		for(int i = 0; i < SIZE; i++) {
			if(node.children[i] != null) {
				if(node.children[i].word != null)
					System.out.println(node.children[i].word);
				preOrder(node.children[i]);
			}
		}

	}

	public static void main(String[] args) {
		new LexographicSortingStrings();
		String[] arr = {"lexo", "champ", "zest", "pest", "pet", "peta", "zen", "pea", "peet", "peter", "zee", "san francisco", "san ramon", "santa clara", "albany", "sunnyvale", "houston", "san jose"};
		for(String word : arr)
			insert(word);
		preOrder(root);	
	}
}

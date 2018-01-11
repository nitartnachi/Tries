/*
 * Given an array of words find the most occurring word in it
 * Examples:

Input : arr[] = {"geeks", "for", "geeks", "a", 
                "portal", "to", "learn", "can",
                "be", "computer", "science", 
                 "zoom", "yup", "fire", "in", 
                 "be", "data"}
Output : Geeks 
"geeks" is the most frequent word as it 
occurs 3 times
 */

package com.nitin.algo;

public class MostFrequentWords {
	
	private static TrieNode root;
	private static final int SIZE = 26;
	private static String frequentWord = "";
	private static int maxCount = 0;
	
	public MostFrequentWords() {
		root  = new TrieNode();
	}
	
	static class TrieNode{
		TrieNode[] children;
		String word;
		int count;
		
		public TrieNode() {
			children = new TrieNode[SIZE];
		}
	}
	
	private static void insert(String word) {
		TrieNode node = root;
		for(int i = 0 ; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if(node.children[index] == null) {
				TrieNode temp = new TrieNode();
				node.children[index] = temp;
				node = temp;
			}
			else {
				node  = node.children[index];
			}
		}
		node.word = word;
		node.count++;
	}
	
	private static void mostFrequent(TrieNode root2) {
		traverse(root);
	}
	
	private static void traverse(TrieNode node) {
		if(node == null)
			return;
		
		for(int i = 0; i < SIZE; i++) {
			if(node.children[i] != null) {
				if(node.children[i].word != null) {
					if(node.children[i].count > maxCount) {
						maxCount = node.children[i].count;
						frequentWord = node.children[i].word;
					}
				}
				traverse(node.children[i]);
			}
		}
		
	}

	public static void main(String[] args) {
		new MostFrequentWords();
		String words[] = {"geeks","for","geeks","is", "a","portal","to","learn","can","be","geeks", "computer","science","zoom","yup","fire","in","be","data"};
		for(String word : words)
			insert(word);
		mostFrequent(root);
		System.out.println("The word with maximum occurence is: " + frequentWord);
	}

	

}

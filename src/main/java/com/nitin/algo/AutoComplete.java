/*
 * We are given a Trie with a set of cities stored in it. Now the user types in a prefix of his search query, 
 * we need to give him all recommendations to auto-complete his query based on the cities stored in the Trie.
 * For example if the Trie store {“san francisco”, “san ramon”, “santa clara”, “albany”, “sunnyvale”, "houston", "san jose"} and the User types in “san ” 
 * then he must be shown {“san francisco”, “san ramon”, "san jose"}.
 */

package com.nitin.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoComplete {
	private static final int SIZE = 27;
	private static TrieNode root = null;

	public AutoComplete() {
		root = new TrieNode();
	}

	static class TrieNode{
		TrieNode[] children = new TrieNode[SIZE];
		String word; // to store the string for leaf node
		public TrieNode() {}
	}

	private static void insert(String word) {
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++) {
			char c  = word.charAt(i);
			int index = ((c - 'a') >= 0) ? c - 'a' : 26; //setting 26 for space
			if(node.children[index] == null) {
				TrieNode temp = new TrieNode();
				node.children[index] = temp;
				node = temp;
			}else {
				node = node.children[index];
			}
		}
		node.word = word;
	}

	private static TrieNode search(String word) {
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++) {
			char c  = word.charAt(i);
			int index = (c - 'a' >= 0) ? c - 'a' : 26; //setting 26 for space
			if(node.children[index] == null)
				return null;
			else {
				node = node.children[index];
			}
		}
		return node;
	}

	private static void traverse(TrieNode node, List<String> list) {
		for(int i = 0; i < SIZE; i++) {
			if(node.children[i] != null) {
				if(node.children[i].word != null)
					list.add(node.children[i].word);
				else
					traverse(node.children[i], list);
			}
		}
	}

		private static List<String> autoComplete(String prefix) {
			TrieNode node = search(prefix);
			if(node == null)
				return Collections.emptyList();

			List<String> list = new ArrayList<>();
			if(node.children != null) 
				traverse(node, list);
			return list;
		}
		
		public static void main(String[] args) {
			new AutoComplete();
			String[] cities = {"san francisco", "san ramon", "santa clara", "albany", "sunnyvale", "houston", "san jose"};
			for(String city : cities)
				insert(city);
			System.out.println("The cities are : " + autoComplete("san ").toString());
		}

	}

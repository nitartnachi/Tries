package com.nitin.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DuplicateRowsBinaryMatrix {
	private static TrieNode root;
	
	public DuplicateRowsBinaryMatrix() {
		root = new TrieNode();
	}
	
	static class TrieNode{
		TrieNode[] children;
		boolean isLeaf;
		public TrieNode() {
			children = new TrieNode[2];
		}
	}
	
	public static void main(String[] args) {
		int[][] mat = {
					{1,0,0,1,0},
					{0,1,1,0,0},
					{1,0,0,1,0},
					{0,0,1,1,0},
					{0,1,1,0,0} };

		new DuplicateRowsBinaryMatrix();
		System.out.println("Duplicate rows are: " + findDups(mat).toString());
	}

	private static List<Integer> findDups(int[][] mat) {
		if(mat == null || mat.length == 0 || mat[0].length == 0)
			return Collections.emptyList();
		
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < mat.length; i++) {
			if(!insert(mat[i]))
				result.add(i + 1);
		}
	
		return result;
	}

	private static boolean insert(int[] mat) {
		TrieNode node = root;
		for(int i = 0; i < mat.length; i++) {
			int index = mat[i];
			if(node.children[index] == null) {
				TrieNode temp = new TrieNode();
				node.children[index] = temp;
				node = temp;
			}else {
				node = node.children[index];
			}
		}
		if(node.isLeaf)
			return false;
		
		return node.isLeaf = true;
		
	}

}

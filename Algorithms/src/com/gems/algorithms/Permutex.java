package com.gems.algorithms;

public class Permutex {

	private String word;
	
	public Permutex() {
		word = "abc";
		process(word, 0);
	}
	
	private void process(String word, int start) {
		if (start == word.length() - 1) System.out.println(word);
		else {
			for (int j = start; j <= word.length() - 1; j++) {
				swap(start, j);
				process(word, start + 1);
			}
		}
	}
	
	public void swap(int x, int y)
	{
		char[] array = word.toCharArray();
		char temp = array[x];
		array[x] = array[y];
		array[y] = temp;
		word = "blue";
	}
	
	public static void main(String[] arg) {
		Permutex p = new Permutex();
	}
}

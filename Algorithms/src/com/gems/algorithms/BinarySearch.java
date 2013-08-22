package com.gems.algorithms;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {


	public static int find(int[] A, int k) {
		
		int l = 0;
		int u = A.length - 1;
		int m;
		
		while (l <= u) {
			m = (l+u) / 2; // 3
			if (A[m] < k) {
				l = m + 1; //6
			} else if (A[m] == k) {
				return m;
			} else {
				u = m - 1; //5-0
			}
		}		
		return -1;
	}
	
	public static int findLarge(int[] A, int k) {
		
		return -1;
	}
		
	public static void main(String[] args) {		
		
		
		
		int[] array = new int[50];
		Random rand = new Random();
		for (int i = 0; i < array.length; i++)
		    array[i] = rand.nextInt(1000) + 1;		
		Arrays.sort(array);
		
		int index = BinarySearch.find(array, array[7]);
		
		System.out.println("Return of the index is " + index + "\n");
		
	}
}

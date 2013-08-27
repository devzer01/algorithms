package com.gems.algorithms;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {


	public static int find(int[] A, int k) {
		
		int l = 0;
		int u = A.length - 1;
		int m;
		
		while (l <= u) {
			m = (l+u) / 2;
			if (A[m] < k) {
				l = m + 1;
			} else if (A[m] == k) {
				return m;
			} else {
				u = m - l;
			}
		}
		
		return -1;
	}
	
	
	
	public static int findSqrt(int key)
	{
		
		int l = 0;
		int u = 65536;

		while (l+1 <= u) {
			
			int mid = l + (u - l) / 2;
			int midSqr = mid * mid;
			
			if (key == midSqr) return mid;
			
			if (midSqr > key) {
				u = mid;
			} else {
				l = mid;
			}
		}
		return -1;
	}
		
	public static void main(String[] args) {		
		System.out.println("Sqrt of " + (49 * 49) + " -- " + BinarySearch.findSqrt(49 * 49));		
		
		
		
		int[] array = new int[50];
		Random rand = new Random();
		for (int i = 0; i < array.length; i++)
		    array[i] = rand.nextInt(1000) + 1;		
		Arrays.sort(array);
		
		int index = BinarySearch.find(array, array[7]);
		
		System.out.println("Return of the index is " + index + "\n");
		
	}
}

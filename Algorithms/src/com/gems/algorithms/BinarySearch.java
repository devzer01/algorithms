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
				u = m - 1;
			}
		}
		
		return -1;
	}
	
	public static int bs(int[] ar, int k)
	{
		int begin = 0;
		int end = ar.length - 1;
		int middle;
		
		while (begin <= end) {
			middle = begin + (end - begin) / 2;
			if (ar[middle] < k) {
				end = middle + 1;
			} else if (ar[middle] > k) {
				begin = middle - 1;
			} else {
				return ar[middle];
			}
		}
		
		return -1;
	}
	
	
	public static int binaryFind(int[] a, int key)
	{
		int start = 0;
		int end = a.length;
		int mid;
		
		while (start <= end) {
			mid = (start+end)/2;
			if (a[mid] > key) {
				end = mid + 1;
			} else if (a[mid] == key) {
				return mid;
			} else {
				start = mid - 1;
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
		
		int index = BinarySearch.binaryFind(array, array[7]);
		
		System.out.println("Return of the index is " + index + "\n");
		
	}
}

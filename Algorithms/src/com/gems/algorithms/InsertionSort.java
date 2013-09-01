package com.gems.algorithms;

public class InsertionSort {

	public static boolean less(int a, int b)
	{
		if (a < b) return true;
		return false;
	}
	
	public static int[] exch(int[] a, int b, int c)
	{
//		a[b] ^= a[c];
//		a[c] ^= a[b];
//		a[b] ^= a[c];
		int temp = a[b];
		a[b] = a[c];
		a[c] = temp;
		return a;
	}
	
	public static int[] sort(int[] a)
	{
		for (int i=0; i < a.length; i++) {
			for (int j=i; j > 0 && less(a[j], a[j-1]); j--) 
				a = exch(a, j, j-1);
		}
		return a;
	}
	
	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i=0; i < 10; i++) {
			a[i] = (int) (Math.random() * 1000);
		}
		
		for (int i=0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.print("\n");
		
		a = InsertionSort.sort(a);
		
		for (int i=0; i < a.length; i++)
			System.out.print(a[i] + " ");

	}

}

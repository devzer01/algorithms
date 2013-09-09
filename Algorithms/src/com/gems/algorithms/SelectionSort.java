package com.gems.algorithms;

public class SelectionSort {

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
			
			int min = i;
			
			for (int j=i+1; j < a.length; j++) 
				if (less(a[j], a[min])) min = j;
			a = exch(a, i, min);
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
		
		a = SelectionSort.sort(a);
		
		for (int i=0; i < a.length; i++)
			System.out.print(a[i] + " ");

	}

}

package com.gems.algorithms;

public class CountingQuickPerm {

	public void swap(char[] ar, int i, int j)
	{
		char temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
	
	public void print(char[] ar)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(ar);
		System.out.println(sb.toString());
	}
	
	public void quickPermutation(char[] ar)
	{
		System.out.println(ar);
		int N = ar.length;
		int[] p = new int[N];
		int i = 1;
		
		while (i < N) {
			if (p[i] < i) {
				int j = i % 2 * p[i];
				swap(ar, i, j);
				print(ar);
				p[i]++;
				i = 1;
			} else {
				p[i] = 0;
				i++;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcd";
		CountingQuickPerm cqp = new CountingQuickPerm();
		cqp.quickPermutation(str.toCharArray());
	
	}

}

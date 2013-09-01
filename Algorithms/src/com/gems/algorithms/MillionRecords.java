package com.gems.algorithms;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MillionRecords 
{
	public static void main(String[] args)
	{
		
		long build_start = System.nanoTime();
		int[] array = new int[100000];
		for (int i=0; i < 100000; i++) {
			int needle = (int) (Math.random() * 1000000);
			array[i] = needle; //TODO: add code to check collision 
		}
		long build_end = System.nanoTime();
		
		long n_start = System.nanoTime();
		List<Integer> list = new ArrayList<Integer>();
		for (int i=0; i < 1000000; i++) {
			if (!Arrays.asList(array).contains(i)) {
				list.add(i);
			}
		}
		long n_end = System.nanoTime();
		
		long logn_start = System.nanoTime();
		List<Integer> list2 = new ArrayList<Integer>();
		Arrays.sort(array);
		for (int i=0; i < 100000 - 1; i++) {
			if (array[i + 1] - array[i] == 1) continue;
			
			for (int x = array[i] + 1; x < array[i + 1]; x++)
				list2.add(x);
		}
		long logn_end = System.nanoTime();
		
		long n_delta = (n_end - n_start);
		long logn_delta = (logn_end - logn_start);
		
		System.out.println("O(n) search took " + n_delta + " nano Seconds \n");
		System.out.println("O(m Log n) search took " + logn_delta + " nano Seconds \n");
		System.out.println("Efficency " + new BigDecimal(n_delta / logn_delta) + " \n");
		
		
	}
}

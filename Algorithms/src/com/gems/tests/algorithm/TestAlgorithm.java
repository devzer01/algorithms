package com.gems.tests.algorithm;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import com.gems.algorithms.BinarySearch;

public class TestAlgorithm {

	@Test
	public void test() {
		int[] array = new int[10];
		Random rand = new Random();
		for (int i = 0; i < array.length; i++)
		    array[i] = rand.nextInt(100) + 1;		
		Arrays.sort(array);
		
		int index = BinarySearch.find(array, array[7]);
		
		System.out.println("Return of the index is " + index + "\n");
	}

}

package com.gems.algorithms;

public class FooBar {

	private FooBar()
	{
		Queue<Integer> foo = new Queue<Integer>();
	}
	
	public static void main(String[] args)
	{
		
		
	}
	
	public class Queue<T> {
		
		private Node first;
		private Node last;
		private int N = 0;
		
		private class Node {
			T item;
			Node next;
		}
		
		public boolean isEmpty()
		{
			return (N == 0); //first == null;
		}
		
		public int size()
		{
			return N;
		}
		
		public Queue()
		{
			
		}
		
		public void enqueue(T val)
		{
			Node oldlast = last;
			last = new Node();
			last.item = val;
			last.next = null;
			if (isEmpty()) first = last;
			else oldlast.next = last;
			N++;
		}
		
		public T dequeue()
		{
			T val = first.item;
			first = first.next;
			N--;
			if (isEmpty()) last = null;
			return val;
		}
	}
}

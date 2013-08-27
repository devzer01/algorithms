package com.gems.algorithms;

public class SequentialSearchST<Key, Value> {

	private Node first;
	
	class Node {
		
		Key key;
		Value val;
		Node next;
		
		Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public Value get(Key key)
	{
		for (Node x = first; x.next != null; x = x.next)
			if (x.key == key) return x.val;
		
		return null;
	}
	
	public void set(Key key, Value val)
	{
		
		for (Node x = first; x != null; x = x.next)
			if (x.key == key) {
				x.val = val;
				return;
			}
		
		first = new Node(key, val, first);
		return;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

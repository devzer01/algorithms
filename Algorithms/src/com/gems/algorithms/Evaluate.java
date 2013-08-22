package com.gems.algorithms;

import java.util.Stack;

public class Evaluate {

	public static void main(String[] args)
	{
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		
		while (!StdIn.isEmpty()) {
			
			String s = StdIn.readString();
			if (s.equals("(")) ;
			else if (s.equals("+")) ops.push(s);
			else if (s.equals(")")) {
				String op = ops.pop();
				double v = vals.pop();
				if (op.equals("+")) v = vals.pop() + v;
				vals.push(v);
			}
			else vals.push(Double.parseDouble(s));
		}
		System.out.println(vals.pop());
	}
}

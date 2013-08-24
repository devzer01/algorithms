package com.gems.tests.algorithm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.gems.algorithms.Stack;

public class TestStack {
	
	protected Stack<String> stack;

	@Before 
	public void setup()
	{
		stack = new Stack<String>(5);
		stack.push("Hello");
	}
	
	@Test
	public void testStack() {
		assertNotNull("Stack is Not Null", stack);
	}
	
	@Test
	public void testSize() {
		stack.push("One");
		stack.push("Two");
		stack.push("Three");
		stack.push("Four");
		stack.push("Five");
		assertEquals("Stack size is 10", 10, stack.size());
	}

	@Test
	public void testPush() {
		assertNotNull("Pushing to Stack", stack);
	}

	@Test
	public void testPop() {
		String pop = stack.pop();
		assertEquals("Pops Five", "Hello", pop);
	}

}

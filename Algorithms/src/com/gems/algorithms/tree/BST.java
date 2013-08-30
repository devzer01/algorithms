package com.gems.algorithms.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import com.gems.algorithms.In;

public class BST {

//	private Integer value;
//	
////	private BST left;
////	
////	private BST right;
	
	private Node<Integer> root;
	
	
	public void add(int val)
	{
		System.out.println("Here");
		root = add(root, val);
	}
	
	private Node<Integer> add(Node<Integer> root, Integer val)
	{
		if (root == null) {
			System.out.println("Node Null");
			root = new Node<Integer>(val);
		}
		else if (root.data.compareTo(val) < 0) {
			System.out.println("Help");
			root.right = add(root.right, val);
		}
		else if (root.data.compareTo(val) > 0) {
			System.out.println("More");
			root.left = add(root.left, val);
		}
		
		return root;
		
	}
	
	public void print()
	{
		BTreePrinter.printNode(root);
	}
	
	public int findlowans(Integer first, Integer second)
	{
		return findlowans(root, first, second);
	}
	
	private int findlowans(Node<Integer> root, Integer first, Integer second)
	{
		if (root.data > first && root.data > second) {
			return findlowans(root.left, first, second);
		} else if (root.data < first && root.data < second) {
			return findlowans(root.right, first, second);
		} else {
			return root.data;
		}
	}
	
	public static void main(String[] args) {
		
		BST bst = new BST();
		
		int max = 10;
		int counter = 0;
		while (counter++ < max) {
			int seed = (int) (Math.random() * 100);
			bst.add(seed);
			//System.out.println(seed);
		}
		bst.print();
		
		System.out.println("Enter two numbers whos lowest common ancestor you want to find");
		Scanner in = new Scanner(System.in);
		int first = in.nextInt();
		int second = in.nextInt();
		
		int common = bst.findlowans(first, second);
		
		System.out.println("Common Anscestor Is " + common);
		
	}

}

class Node<T extends Comparable<?>> {
    Node<T> left, right;
    T data;

    public Node(T data) {
        this.data = data;
    }
}

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}

package com.gems.algorithms;

public class InFix {

	public static void main(String[] args) {
		
		Stack<String> operator = new Stack<String>(20);
		Stack<String> oprand = new Stack<String>(20);
		
		while (!StdIn.isEmpty()) {
			String var = StdIn.readString();
			
			switch (var) {
				case "*":
				case "/":
				case "-":
				case "+":
					operator.push(var);
					break;
				case "0":
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
					oprand.push(var);
					break;
				case ")":
					String a = oprand.pop();
					String b = oprand.pop();
					StringBuilder sb = new StringBuilder();
					sb.append("(");
					sb.append(b);
					sb.append(operator.pop());
					sb.append(a);
					sb.append(")");
					oprand.push(sb.toString());
					break;
			}
		}
			System.out.println(oprand.pop());
		
	}

}

package com.gems.algorithms;

import java.util.Stack;

import java.util.Scanner;

public class InFixer {
 
        public static void main(String[] args)
        {
                Scanner sc = new Scanner(System.in);
                String line = sc.nextLine();
               
                Stack<Character> operators = new Stack<Character>();
                Stack<String> operands = new Stack<String>();
 
                for (int i = 0; i < line.length(); i++)
                {
                        switch (line.charAt(i))
                        {
                                case '+':
                                case '-':
                                case '*':
                                case '/':
                                        // Operator case
                                        operators.push(line.charAt(i));
                                        break;
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                        // "operand" case
                                        String s = "";
                                        s += line.charAt(i);
                                        operands.push(s);
                                        break;
                                case ')':
                                        // closing paren case
                                        String a = operands.pop();
                                        String b = operands.pop();
                                        char c = operators.pop();
                                       
                                        StringBuilder buf = new StringBuilder();
                                        buf.append("(");
                                        buf.append(b);
                                        buf.append(c);
                                        buf.append(a);
                                        buf.append(")");
                                       
                                        operands.push(buf.toString());
                                        break;
                                case ' ':
                                        break;
                        }
                }
               
                System.out.println(operands.pop());
                sc.close();
        }
}
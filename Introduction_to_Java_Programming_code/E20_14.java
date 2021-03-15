/*
  Postfix notation is a way of writing expressions without using parentheses.
  For example, the expression (1 + 2) * 3 would be written as 1 2 + 3 *. A
  postfix expression is evaluated using a stack. Scan a postfix expression from
  left to right. A variable or constant is pushed onto the stack. When an
  operator is encountered, apply the operator with the top two operands in the
  stack and replace the two operands with the result.
*/

import java.util.Stack;

public class E20_14 {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java E20_14 [postfix expression]");
      System.exit(1);
    }

    String[] tokens = args[0].split(" ");

    try {
      System.out.println(evaluatePostfix(tokens));
    } catch (Exception ex) {
      System.out.println("Invalid expression");
    }
  }

  public static double evaluatePostfix(String[] tokens) {
    Stack<Double> stack = new Stack<>();
    for (int i = 0; i < tokens.length; i++) {
      if (tokens[i].equals("+")) {
        stack.push(stack.pop() + stack.pop());
      } else if (tokens[i].equals("-")) {
        double op2 = stack.pop();
        double op1 = stack.pop();
        stack.push(op1 - op2);
      } else if (tokens[i].equals("*")) {
        stack.push(stack.pop() * stack.pop());
      } else if (tokens[i].equals("/")) {
        double op2 = stack.pop();
        double op1 = stack.pop();
        stack.push(op1 / op2);
      } else {
        stack.push(Double.parseDouble(tokens[i]));
      }
    }
    return stack.pop();
  }

  public static String addSpaces(String expression) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (c == '+' || c == '-' || c == '*' || c == '/') {
        sb.append(" " + c + " ");
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}

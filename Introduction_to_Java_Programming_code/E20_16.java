/*
  Write a method that converts an infix expression into a postfix expression
  using the following header:

  public static String infixToPostfix(String expression)

  For example, the method should convert the infix expression (1 + 2) * 3 to
  1 2 + 3 * and 2 * (1 + 3) to 2 1 3 + *.
*/

import java.util.Stack;

public class E20_16 {
  public static void main(String[] args) {
    String e1 = addSpaces("(1 + 2) * 3");
    String e2 = addSpaces("2 * (1 + 3)");
    String e3 = addSpaces("(1 * 2 + 2 * 3 / 3) * (1 + 3)");


    System.out.println(infixToPostfix(e1));
    System.out.println(infixToPostfix(e2));
    System.out.println(infixToPostfix(e3));
  }

  public static String infixToPostfix(String expression) {
    Stack<String> opStack = new Stack<>();
    String[] tokens = expression.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < tokens.length; i++) {
      if (tokens[i].isEmpty()) { continue; }
      String t = tokens[i];
      if (t.equals("+") || t.equals("-")) {
        while (!opStack.empty() && !opStack.peek().equals("(")) {
          sb.append(opStack.pop() + " ");
        }
        opStack.push(t);
      } else if (t.equals("*") || t.equals("/")) {
        while (!opStack.empty() &&
              (opStack.peek().equals("*") || opStack.peek().equals("/"))) {
          sb.append(opStack.pop() + " ");
        }
        opStack.push(t);
      } else if (t.equals("(")) {
        opStack.push(t);
      } else if (t.equals(")")) {
        while (!opStack.empty() && !opStack.peek().equals("(")) {
          sb.append(opStack.pop() + " ");
        }
        opStack.pop();
      } else {
        sb.append(t + " ");
      }
    }
    while (!opStack.empty()) {
      sb.append(opStack.pop() + " ");
    }
    return sb.toString();
  }

  public static String addSpaces(String expression) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (c == '+' || c == '-' || c == '*' ||
          c == '/' || c == '(' || c == ')') {
        sb.append(" " + c + " ");
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}

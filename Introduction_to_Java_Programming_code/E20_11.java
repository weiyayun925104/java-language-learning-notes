/*
  A Java program contains various pairs of grouping symbols, such as:

  - Parentheses: ( and )
  - Braces: { and }
  - Brackets: [ and ]

  Note that the grouping symbols cannot overlap. For example, (a{b)} is illegal.
  Write a program to check whether a Java source-code file has correct pairs of
  grouping symbols. Pass the source-code file name as a command-line argument.
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class E20_11 {
  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.out.println("Usage: java E20_11 filename.java");
      System.exit(1);
    }

    if (!args[0].endsWith(".java")) {
      System.out.println("Argument must be a Java source file");
      System.exit(2);
    }

    File file = new File(args[0]);

    if (!file.exists()) {
      System.out.println("File " + file.getName() + " does not exist");
      System.exit(3);
    }

    if (!file.isFile()) {
      System.out.println(file.getName() + " is not a file");
      System.exit(4);
    }

    if (groupingSymbolsCorrect(file)) {
      System.out.println("Grouping symbols correct");
    } else {
      System.out.println("Grouping symbols incorrect");
    }
  }

  public static boolean groupingSymbolsCorrect(File file) throws IOException {
    try (
      Scanner input = new Scanner(file);
    ) {
      Stack<Character> stack = new Stack<>();
      while (input.hasNext()) {
        // replaceAll excludes literal references to grouping symbol chars
        String s = input.next().replaceAll("\'.*\'", "");
        for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          System.out.println(stack);
          if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
          } else if (c == ')' || c == '}' || c == ']') {
            if (stack.empty()) { return false; }
            if (!(stack.pop() == getOpeningSymbol(c))) { return false; }
          }
        }
      }
    }
    return true;
  }

  public static char getOpeningSymbol(char c) {
    char[] opening = {'(', '{', '['};
    char[] closing = {')', '}', ']'};
    for (int i = 0; i < closing.length; i++) {
      if (c == closing[i]) { return opening[i]; }
    }
    return 'z';
  }
}

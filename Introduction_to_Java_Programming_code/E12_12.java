/*
  Write a program that converts the java source code from the next-line brace
  style to the end-of-line brace style. Your program can be invoked from the
  command line with the Java source-code file as the argument. It converts the
  Java source code to a new format. For example, the following command converts
  the Java source-code file Test.java to the end-of-line brace style.

  java Exercise12_12 Test.java
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class E12_12 {
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.out.println("Usage: java E12_12 [filename]");
      System.exit(1);
    }

    File file = new File(args[0]);

    if (!file.exists()) {
      System.out.println("File " + args[0] + " not found");
      System.exit(2);
    }

    String s = "";

    try (
      Scanner input = new Scanner(file);
    ) {
      while (input.hasNext()) {
        s += input.nextLine() + "\n";
      }
      s = s.replaceAll("\n\\s*\\{", " {");
    }

    try (
      PrintWriter output = new PrintWriter(file);
    ) {
      output.print(s);
    }
  }
}

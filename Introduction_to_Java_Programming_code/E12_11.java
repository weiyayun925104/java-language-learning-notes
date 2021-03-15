/*
  Write a program that removes all the occurrences of a specified string from
  a text file. For example, invoking

  java E12_11 John filename

  removes the string John from the specified file. Your program should get the
  arguments from the command line.
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class E12_11 {
  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.out.println("Usage: java E12_11 " +
        "[string to remove from file] [file name]");
      System.exit(1);
    }

    File file = new File(args[1]);

    if (!file.exists()) {
      System.out.println("No file " + args[1] + " was found.");
      System.exit(2);
    }

    String s = "";

    try (
      Scanner input = new Scanner(file);
    ) {
      while (input.hasNext()) {
        s += input.nextLine() + "\n";
      }
      s = s.replaceAll(args[0], "");
    }

    try (
      PrintWriter output = new PrintWriter(file);
    ) {
      output.print(s);
    }
  }
}

/*
  Write a program that replaces all occurrences of a word with a new word in all
  the files under a directory, recursively. Pass the parameters from the
  command line as follows:

  java E18_31 dirName oldWord newWord
*/

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class E18_31 {
  public static void main(String[] args) throws IOException {
    if (args.length != 3) {
      System.out.println("Usage: java E18_31 dirName oldWord newWord");
      System.exit(1);
    }

    File directory = new File(args[0]);

    if (!directory.exists()) {
      System.out.println(
        "Directory " + directory.getName() + " does not exist");
      System.exit(2);
    }

    if (!directory.isDirectory()) {
      System.out.println(directory.getName() + " is not a directory");
      System.exit(3);
    }

    replace(directory, args[1], args[2]);
  }

  public static void replace(File directory, String oldWord, String newWord)
    throws IOException {
    File[] directoryListing = directory.listFiles();
    replace(directoryListing, directoryListing.length - 1, oldWord, newWord);
  }

  public static void replace(
    File[] listing, int position, String oldWord, String newWord)
    throws IOException {
    if (position < 0) { return; }
    if (!listing[position].isDirectory()) {
      StringBuilder sb = new StringBuilder();
      try (
        Scanner input = new Scanner(listing[position]);
      ) {
        while (input.hasNext()) {
          sb.append(input.nextLine() + "\n");
        }
      }
      try (
        PrintWriter output = new PrintWriter(listing[position]);
      ) {
        output.print(sb.toString().replaceAll(oldWord, newWord));
      }
    }
    replace(listing, position - 1, oldWord, newWord);
  }
}

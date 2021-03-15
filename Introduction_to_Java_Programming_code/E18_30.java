/*
  Write a program that finds all occurrences of a word in all the files under a
  directory, recursively. Pass the parameters from the command line as follows:

  java E18_30 dirName word
*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class E18_30 {
  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.out.println("Usage: java E18_30 dirName word");
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

    System.out.println(countOccurrences(directory, args[1]));
  }

  public static int countOccurrences(File directory, String word)
    throws IOException {
    File[] directoryListing = directory.listFiles();
    return countOccurrences(
      directoryListing, word, directoryListing.length - 1, 0);
  }

  public static int countOccurrences(
    File[] listing, String word, int position, int count) throws IOException {
    if (position < 0) { return count; }
    if (!listing[position].isDirectory()) {
      try (
        Scanner input = new Scanner(listing[position]);
      ) {
        while (input.hasNext()) {
          if (input.next().toLowerCase().contains(word.toLowerCase())) {
            count++;
          }
        }
      }
    }
    return countOccurrences(listing, word, position - 1, count);
  }
}

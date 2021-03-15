/*
  Write a program that reads words from a text file and displays all the
  nonduplicate words in ascending order. The text file is passed as a
  command-line argument.
*/

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class E21_02 {
  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.out.println("Usage: java E21_02 filename");
      System.exit(1);
    }

    File file = new File(args[0]);

    if (!file.exists()) {
      System.out.println("File " + file.getName() + " does not exist");
      System.exit(2);
    }

    if (!file.isFile()) {
      System.out.println(file.getName() + " is not a file");
      System.exit(3);
    }

    try (
      Scanner input = new Scanner(file);
    ) {
      Set<String> words = new TreeSet<>();
      while (input.hasNext()) {
        words.add(input.next());
      }

      for (String word: words) {
        System.out.println(word);
      }
    }
  }
}

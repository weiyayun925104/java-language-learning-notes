/*
  Write a program that will count the number of characters, words, and lines
  in a file. Words are separated by whitespace characters. The file name should
  be passed as a command-line argument.
*/

import java.io.File;
import java.util.Scanner;

public class E12_13 {
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.out.println("Usage: java E12_13 [filename]");
      System.exit(1);
    }

    File file = new File(args[0]);

    if (!file.exists()) {
      System.out.println("File " + args[0] + " not found");
      System.exit(2);
    }

    int characters = 0;
    int words = 0;
    int lines = 0;

    // count characters and words
    try (
      Scanner input = new Scanner(file);
    ) {
      while (input.hasNext()) {
        String s = input.next();
        characters += s.length();
        words++;
      }
    }

    // count lines
    try (
      Scanner input = new Scanner(file);
    ) {
      while (input.hasNext()) {
        input.nextLine();
        lines++;
      }
    }

    System.out.println("characters: " + characters);
    System.out.println("words: " + words);
    System.out.println("lines: " + lines);
  }
}

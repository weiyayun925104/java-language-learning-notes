/*
  Write a program that prompts the user to enter a file name and displays the
  occurrences of each letter in the file. Letters are case-insensitive.
*/

import java.io.File;
import java.util.Scanner;

public class E12_30 {
  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a filename: ");
    String filename = input.nextLine();

    File file = new File(filename);

    if (!file.exists()) {
      System.out.println("File not found");
      System.exit(1);
    }

    int[] alpha = new int[26];

    try (
      Scanner in = new Scanner(file);
    ) {
      while (in.hasNext()) {
        countLetters(in.next().toUpperCase(), alpha);
      }

      for (int i = 0; i < alpha.length; i++) {
        System.out.println("Number of " + (char)(i + 65) + "'s: " + alpha[i]);
      }
    }
  }

  public static void countLetters(String s, int[] alpha) {
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c >= 'A' && c <= 'Z') {
        alpha[c - 65]++;
      }
    }
  }
}

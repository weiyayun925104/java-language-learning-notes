/*
  Write a program that prompts the user to enter a text file name and displays
  the number of vowels and consonants in the file. Use a set to store the
  vowels A, E, I, O, and U.
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class E21_04 {
  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.out.println("Usage: java E21_04 filename.txt");
      System.exit(1);
    }

    File file = new File(args[0]);

    if (!file.exists()) {
      System.out.println(file.getName() + " does not exist");
      System.exit(2);
    }

    if (!file.isFile()) {
      System.out.println(file.getName() + " is not a file");
      System.exit(3);
    }

    Character[] vowels = {'A', 'E', 'I', 'O', 'U'};
    Set<Character> vowelSet = new HashSet<>(Arrays.asList(vowels));

    try (
      Scanner input = new Scanner(file);
    ) {
      int vCount = 0;
      int cCount = 0;
      while (input.hasNext()) {
        String line = input.nextLine();
        for (int i = 0; i < line.length(); i++) {
          char c = Character.toUpperCase(line.charAt(i));
          if (Character.isLetter(c)) {
            if (vowelSet.contains(c)) {
              vCount++;
            } else {
              cCount++;
            }
          }
        }
      }
      System.out.println("vowels: " + vCount);
      System.out.println("consonants: " + cCount);
    }
  }
}

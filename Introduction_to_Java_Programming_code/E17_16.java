/*
  Write a program that prompts the user to enter the name of an ASCII text file
  and displays the frequency of the characters in the file.
*/

import java.io.File;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class E17_16 {
  public static void main(String[] args) throws IOException {
    Scanner userInput = new Scanner(System.in);
    System.out.print("Enter an ASCII text file: ");
    File textFile = new File(userInput.nextLine());

    if (!textFile.exists()) {
      System.out.println("File " + textFile.getName() + " does not exist");
      System.exit(1);
    }

    int[] chars = new int[128];
    try (
      Scanner input = new Scanner(
        new BufferedInputStream(new FileInputStream(textFile)));
    ) {
      while (input.hasNext()) {
        String s = input.nextLine();
        for (int i = 0; i < s.length(); i++) {
          chars[(int)s.charAt(i)]++;
        }
      }
    }

    for (int i = 0; i < chars.length; i++) {
      if (chars[i] > 0) {
        System.out.println(i + " *" + (char)i + "* " + chars[i]);
      }
    }
  }
}

/*
  Write a program that counts the number of words in President Abraham Lincoln's
  Gettysburg address.
*/

import java.io.File;
import java.util.Scanner;

public class E12_19 {
  public static void main(String[] args) {
    File file = new File("Lincoln.txt");

    if (!file.exists()) {
      System.out.println("File " + file.getName() + " does not exist");
      System.exit(1);
    }

    int words = 0;

    try (
      Scanner input = new Scanner(file);
    ) {
      while (input.hasNext()) {
        input.next();
        words++;
      }
    } catch (Exception e) {
      System.out.println("File not found");
      System.exit(2);
    }

    System.out.println("words: " + words);
  }
}

/*
  Suppose that a text file contains an unspecified number of scores separated
  by blanks. Write a program that prompts the user to enter the file, reads the
  scores from the file, and displays their total and average.
*/

import java.io.File;
import java.util.Scanner;

public class E12_14 {
  public static void main(String[] args) throws Exception {
    File file = getFile();

    if (!file.exists()) {
      System.out.println("File " + file.getName() + " does not exist");
      System.exit(1);
    }

    try (
      Scanner input = new Scanner(file);
    ) {
      int total = 0;
      int count = 0;
      while (input.hasNext()) {
        total += input.nextInt();
        count++;
      }

      System.out.println("Total: " + total);
      System.out.printf("Average: %.2f\n", ((double)total / count));
    }
  }

  public static File getFile() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the file name: ");
    String filename = input.nextLine();
    return new File(filename);
  }
}

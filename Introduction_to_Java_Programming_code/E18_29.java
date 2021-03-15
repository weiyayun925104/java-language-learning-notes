/*
  Write a program that prompts the user to enter a directory and displays the
  number of files in the directory.
*/

import java.util.Scanner;
import java.io.File;

public class E18_29 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a directory: ");
    File directory = new File(input.nextLine());

    if (!directory.exists()) {
      System.out.println(
        "Directory " + directory.getName() + " does not exist");
      System.exit(1);
    }

    if (!directory.isDirectory()) {
      System.out.println(directory.getName() + " is not a directory");
      System.exit(2);
    }

    System.out.println("Files: " + countFiles(directory));
  }

  public static int countFiles(File directory) {
    File[] directoryListing = directory.listFiles();
    return countFiles(directoryListing, directoryListing.length - 1, 0);
  }

  public static int countFiles(File[] directoryListing, int position, int count) {
    if (position < 0) { return count; }
    count += directoryListing[position].isDirectory() ? 0 : 1;
    return countFiles(directoryListing, position - 1, count);
  }
}

/*
  Write a program that prompts the user to enter a directory name and creates
  a directory using File's mkdirs method. The program displays the message
  "Directory created successfully" if a directory is created or "Directory
  already exists" if the directory already exists.
*/

import java.io.File;
import java.util.Scanner;

public class E12_26 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a directory name: ");
    String directoryName = input.nextLine();

    File file = new File(directoryName);

    if (file.mkdirs()) {
      System.out.println("Directory created successfully");
    } else {
      System.out.println("Directory already exists");
    }
  }
}

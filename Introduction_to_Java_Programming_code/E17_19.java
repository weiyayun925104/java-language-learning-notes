/*
  Write a program that prompts the user to enter a file name, reads bytes from
  the file, and displays each byte's hex representation.
*/

import java.io.File;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.util.Scanner;

public class E17_19 {
  public static void main(String[] args) throws IOException {
    Scanner userInput = new Scanner(System.in);
    System.out.print("Enter a file: ");
    File file = new File(userInput.nextLine());

    if (!file.exists()) {
      System.out.println("File " + file.getName() + " does not exist");
      System.exit(1);
    }

    try (
      DataInputStream input = new DataInputStream(
        new FileInputStream(file));
    ) {
      while (true) {
        System.out.println(Integer.toHexString(input.readByte()));
      }
    } catch (EOFException ex) {
      // do nothing
    }
  }
}

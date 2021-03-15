/*
  Write the following method that displays the bit representation for the last
  byte in an integer:

  public static String getBits(int value)

  Write a program that prompts the user to enter a file name, reads bytes from
  the file, and displays each byte's binary representation;
*/

import java.io.File;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.util.Scanner;

public class E17_18 {
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
        System.out.println(getBits(input.readByte()));
      }
    } catch (EOFException ex) {
      // do nothing
    }
  }

  public static String getBits(int value) {
    StringBuilder sb = new StringBuilder();
    sb.append(value % 2 == 0 ? "0" : "1");
    for (int i = 1; i < 8; i++) {
      value = value >> 1;
      sb.insert(0, (value % 2 == 0) ? "0" : "1");
    }
    return sb.toString();
  }
}

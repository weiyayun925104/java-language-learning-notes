/*
  Write a program that reads lines of characters from a text file and writes
  each line as a UTF-8 string into a binary file. Display the sizes of the
  text file and the binary file. Use the following command to run the program:

  java E17_04 Welcome.java Welcome.utf
*/

import java.io.File;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

public class E17_04 {
  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.out.println("Usage: java E17_04 sourceText targetBinary");
      System.exit(1);
    }

    File sourceText = new File(args[0]);

    if (!sourceText.exists()) {
      System.out.println("Source file " + args[0] + " does not exist");
      System.exit(2);
    }

    try (
      Scanner input = new Scanner(sourceText);
      DataOutputStream output = new DataOutputStream(
        new BufferedOutputStream(new FileOutputStream(args[1])));
    ) {
      while (input.hasNext()) {
        output.writeUTF(input.nextLine() + "\n");
      }
    }

    // test the above code
    try (
      DataInputStream input = new DataInputStream(
        new BufferedInputStream(new FileInputStream(args[1])));
    ) {
      while (true) {
        System.out.print(input.readUTF());
      }
    } catch (EOFException ex) {
      // do nothing
    }
  }
}

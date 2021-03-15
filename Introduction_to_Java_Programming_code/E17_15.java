/*
  Suppose a file is encrypted using the scheme in Programming Exercise 17.14.
  Write a program to decode an encrypted file. Your program should prompt the
  user to enter an input file name for the encrypted file and an output file
  name for the unencrypted version of the input file.
*/

import java.util.Scanner;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.FileOutputStream;
import java.io.IOException;

public class E17_15 {
  public static void main(String[] args) throws IOException {
    Scanner userInput = new Scanner(System.in);
    System.out.print("Enter a source file: ");
    String sourceFileName = userInput.nextLine();
    System.out.print("Enter a target file: ");
    String targetFileName = userInput.nextLine();

    File sourceFile = new File(sourceFileName);

    if (!sourceFile.exists()) {
      System.out.println("File " + sourceFile.getName() + " does not exist");
      System.exit(1);
    }

    try (
      RandomAccessFile raf = new RandomAccessFile(sourceFile, "r");
      FileOutputStream output = new FileOutputStream(targetFileName);
    ) {
      for (long i = 0; i < raf.length(); i++) {
        byte b = raf.readByte();
        output.write((byte)(b - 5));
      }
    }
  }
}

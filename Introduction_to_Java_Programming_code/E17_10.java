/*
  Suppose you want to back up a huge file (e.g. a 10GB AVI file) to a CD-R.
  You can achieve it by splitting the file into smaller pieces and backing up
  these pieces separately. Write a utility program that splits a large file
  into smaller ones using the following command:

  java E17_10 SourceFile numberOfPieces

  The command creates the files SourceFile.1, SourceFile.2, ...,
  SourceFile.n, where n is numberOfPieces and the output files are about the
  same size.
*/

import java.io.File;
import java.io.RandomAccessFile;
import java.io.FileOutputStream;
import java.io.IOException;

public class E17_10 {
  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.out.println("Usage: java E17_10 SourceFile numberOfPieces");
      System.exit(1);
    }

    if (!isInteger(args[1])) {
      System.out.println("Second argument must be an integer");
      System.exit(2);
    }

    File sourceFile = new File(args[0]);
    long numberOfPieces = Long.parseLong(args[1]);

    if (!sourceFile.exists()) {
      System.out.println(
        "The file " + sourceFile.getName() + " does not exist");
      System.exit(3);
    }

    try (
      RandomAccessFile raf = new RandomAccessFile(sourceFile, "r");
    ) {
      long pieceSize = raf.length() / numberOfPieces;
      for (int i = 0; i < numberOfPieces; i++) {
        byte[] bytes;
        if (i < numberOfPieces - 1) {
          bytes = new byte[(int)pieceSize];
        } else {
          bytes = new byte[(int)(raf.length() - raf.getFilePointer())];
        }

        raf.read(bytes);

        try (
          FileOutputStream output =
            new FileOutputStream(sourceFile + "." + (i + 1));
        ) {
          output.write(bytes);
        }
      }
    }
  }

  private static boolean isInteger(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}

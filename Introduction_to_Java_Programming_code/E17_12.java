/*
  Write a utility program that combines the files together into a new file
  using the following command:

  java E17_12 SourceFile1 ... SourceFilen TargetFile

  The command combines SourceFile1, ..., and SourceFilen into TargetFile.
*/

import java.io.File;
import java.io.RandomAccessFile;
import java.io.FileOutputStream;
import java.io.IOException;

public class E17_12 {
  public static void main(String[] args) throws IOException {
    if (args.length < 2) {
      System.out.println("Usage: java E17_12 SourceFile... TargetFile");
      System.exit(1);
    }

    if (!sourceFilesValid(args)) {
      System.out.println("One or more source files could not be found");
      System.exit(2);
    }

    for (int i = 0; i < args.length - 1; i++) {
      try (
        RandomAccessFile raf = new RandomAccessFile(args[i], "r");
        FileOutputStream output = new FileOutputStream(args[args.length - 1], true);
      ) {
        byte[] bytes = new byte[(int)raf.length()];
        raf.read(bytes);
        output.write(bytes);
      }
    }
  }

  private static boolean sourceFilesValid(String[] args) {
    for (int i = 0; i < args.length - 1; i++) {
      File file = new File(args[i]);
      if (!file.exists()) { return false; }
    }
    return true;
  }
}

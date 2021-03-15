/*
  Revise Programming Exercise 12.16 to replace a string in a file with a new
  string for all files in the specified directory using the command:

  java E12_22 dir oldString newString
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class E12_22 {
  public static void main(String[] args) throws Exception {
    // handle commandline arguments
    if (args.length != 3) {
      System.out.println("Usage: java E12_22 dir oldString newString");
      System.exit(1);
    }

    File dir = new File(args[0]);

    // check existence of file
    if (!dir.exists()) {
      System.out.println("Directory " + dir.getName() + "does not exist");
      System.exit(2);
    }

    // check whether file is directory
    if (!dir.isDirectory()) {
      System.out.println(dir.getName() + " is not a directory");
      System.exit(3);
    }

    // list files in directory
    File[] list = dir.listFiles();


    for (File f: list) {
      // if it's a file
      if (f.isFile()) {
        String s = "";
        // replace all oldString with newString
        try (
          Scanner fileInput = new Scanner(f);
        ) {
          while (fileInput.hasNext()) {
            s += fileInput.nextLine() + "\n";
          }
          s = s.replaceAll(args[1], args[2]);
        }
        // and output the result back into the file
        try (
          PrintWriter fileOutput = new PrintWriter(f);
        ) {
          fileOutput.print(s);
        }
      }
    }
  }

  // Generate test data consisting of a folder and a random number of text files
  // with dummy text
  public static void generateFileStructure() throws Exception {
    File folder = new File("a");
    if (folder.mkdir()) {
      System.out.println("folder " + folder.getName() + " was created");
    }

    int ran = (int)(Math.random() * 10) + 20;
    for (int i = 1; i < ran; i++) {
      File file = new File("a/text" + i + ".txt");
      try (
        PrintWriter p = new PrintWriter(file);
      ) {
        p.println("george is a cat.");
        p.println("cat cat cat");
        p.println("stupid cat stupid hat.");
      }
    }
  }
}

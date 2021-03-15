/*
  Suppose you have Java source files under the directories chapter1, chapter2,
  ..., chapter34. Write a program to insert the statement package chapteri; as
  the first line for each Java source file under the directory chapteri.
  Suppose chapter1, chapter2, ..., chapter34 are under the root directory
  srcRootDirectory. The root directory and chapteri directory may contain
  other folders and files. Use the following command to run the program:

  java E12_18 srcRootDirectory
*/

import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.Scanner;

public class E12_18 {
  public static void main(String[] args) throws Exception {
    // handle the commandline argument
    if (args.length != 1) {
      System.out.println("Usage: java E12_18 srcRootDirectory");
      System.exit(1);
    }

    File rootDir = new File(args[0]);

    if (!rootDir.exists()) {
      System.out.println("Directory " + rootDir.getName() + " not found");
      System.exit(2);
    }

    // get a list of all the chaptersi folders in the root directory
    File[] chapterList = rootDir.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        if (name.toLowerCase().contains("chapter")) {
          return true;
        }
        return false;
      }
    });

    // for each chapteri folder, get a list of its .java files
    for (File f: chapterList) {
      if (f.isDirectory()) {
        File[] fileList = f.listFiles(new FilenameFilter() {
          public boolean accept(File dir, String name) {
            if (name.toLowerCase().endsWith(".java")) {
              return true;
            }
            return false;
          }
        });
        // and for each .java file, insert a package statement for the
        // current chapteri folder
        for (File source: fileList) {
          String s = "";
          try (
            Scanner sourceInput = new Scanner(source);
          ) {
            while (sourceInput.hasNext()) {
              s += sourceInput.nextLine() + "\n";
            }
            StringBuilder sb = new StringBuilder(s);
            sb.insert(0, "package " + f.getName() + ";\n\n");
            s = sb.toString();
          }

          try (
            PrintWriter sourceOutput = new PrintWriter(source);
          ) {
            sourceOutput.print(s);
          }
        }
      }
    }
  }

  // This method creates a file structure for testing purposes, with target
  // folders and files, as well as dummy folders and files.
  public static void generateFileStructure() throws Exception {
    // create the chapters root directory
    File rootDir = new File("chapters");
    if (rootDir.mkdir()) {
      System.out.println("rootDir " + rootDir.getName() + " created");
    }

    // create some dummy data in root directory
    int ran = (int)(Math.random() * 5) + 5;
    // directories
    for (int i = 1; i < ran; i++) {
      File folder = new File("chapters/dummyFolder" + i);
      if (folder.mkdir()) {
        System.out.println("dummy folder " + folder.getName() + " created");
      }
    }
    // text files
    for (int i = 1; i < ran; i++) {
      File file = new File("chapters/dummyFile" + i + ".txt");
      try (
        PrintWriter p = new PrintWriter(file);
      ) {
        p.println("some text");
      }
    }

    // create chapteri folders
    for (int i = 1; i <= 34; i++) {
      File folder = new File("chapters/chapter" + i);
      if (folder.mkdir()) {
        System.out.println("folder " + folder.getName() + " created");
      }

      ran = (int)(Math.random() * 10) + 2;
      // create dummy folders and text files in each chapteri folder
      for (int j = 1; j < ran; j++) {
        File dummyFolder = new File("chapters/chapter" + i + "/dummy" + j);
        if (dummyFolder.mkdir()) {
          System.out.println("folder " + dummyFolder.getName() + " created");
        }
        File dummyText = new File("chapters/chapter" + i + "/text" + j +
          ".txt");
        try (
          PrintWriter p = new PrintWriter(dummyText);
        ) {
          p.println("some text");
        }
      }

      // create java source files
      ran = (int)(Math.random() * 10) + 10;
      for (int j = 1; j < ran; j++) {
        File sourceFile = new File("chapters/chapter" + i + "/Source" + j +
          ".java");
        try (
          PrintWriter p = new PrintWriter(sourceFile);
        ) {
          p.println("public class Source" + j + " {");
          p.println("  public static void main(String[] args) {");
          p.println("    // some code");
          p.println("  }");
          p.println("}");
        }
      }
    }
  }
}

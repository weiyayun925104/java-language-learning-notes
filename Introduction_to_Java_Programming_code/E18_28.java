/*
  Rewrite Listing 18.7, DirectorySize.java, without using recursion.
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class E18_28 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter directory: ");
    File startDirectory = new File(input.nextLine());

    if (!startDirectory.exists()) {
      System.out.println(
        "Directory " + startDirectory.getName() + " does not exist");
      System.exit(1);
    }

    if (!startDirectory.isDirectory()) {
      System.out.println(startDirectory.getName() + " is not a directory");
      System.exit(2);
    }

    // Put the user-entered directory into a list
    ArrayList<File> directories = new ArrayList<>();
    directories.add(startDirectory);

    // Maintain a count of file sizes
    long count = 0;

    // While the list of directories is not empty
    while (!directories.isEmpty()) {
      // Get the first directory in the list
      File dir = directories.get(0);

      // List its contents, counting up the file lengths and adding
      // newly found directories to the list
      for (File file: dir.listFiles()) {
        if (!file.isDirectory()) { count += file.length(); }
        else { directories.add(file); }
      }

      // Remove the currently-viewed directory from the list
      directories.remove(dir);
    }

    System.out.println("Size: " + count);
  }
}

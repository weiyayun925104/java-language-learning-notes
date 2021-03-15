/*
  Listing 20.7, DirectorySize.java, gives a recursive method for finding a
  directory size. Rewrite this method without using recursion. Your program
  should use a queue to store the subdirectories under a directory.
*/

import java.io.File;
import java.util.LinkedList;

public class E20_18 {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java E20_18 directoryName");
      System.exit(1);
    }

    File startingDir = new File(args[0]);

    if (!startingDir.exists()) {
      System.out.println("Directory " + startingDir.getName() + " does not exist");
      System.exit(2);
    }

    if (!startingDir.isDirectory()) {
      System.out.println(startingDir.getName() + " is not a directory");
      System.exit(3);
    }

    LinkedList<File> queue = new LinkedList<>();
    queue.offer(startingDir);

    long count = 0;

    while (!queue.isEmpty()) {
      File f = queue.poll();
      File[] listing = f.listFiles();

      for (File elem: listing) {
        if (elem.isFile()) { count += elem.length(); }
        else { queue.offer(elem); }
      }
    }

    System.out.println(count);
  }
}

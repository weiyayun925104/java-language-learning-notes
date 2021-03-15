/*
  Rewrite Programming Exercise 18.28 using a stack instead of a queue.
*/

import java.io.File;
import java.util.Stack;

public class E20_20 {
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

    Stack<File> stack = new Stack<>();
    stack.push(startingDir);

    long count = 0;

    while (!stack.isEmpty()) {
      File f = stack.pop();
      File[] listing = f.listFiles();

      for (File elem: listing) {
        if (elem.isFile()) { count += elem.length(); }
        else { stack.push(elem); }
      }
    }

    System.out.println(count);
  }
}

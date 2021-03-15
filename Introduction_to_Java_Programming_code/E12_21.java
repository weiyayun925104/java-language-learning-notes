/*
  Write a program that reads the strings from file SortedStrings.txt and reports
  whether the strings in the files are stored in increasing order. If the
  strings are not sorted in the file, display the first two strings that are
  out of order.
*/

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class E12_21 {
  public static void main(String[] args) {
    File file = new File("SortedStrings.txt");

    if (!file.exists()) {
      System.out.println("File " + file.getName() + " does not exist");
      System.exit(1);
    }

    ArrayList<String> strs = new ArrayList<>();

    try (
      Scanner input = new Scanner(file);
    ) {
      while (input.hasNext()) {
        strs.add(input.next());
      }
    } catch (Exception e) {
      System.out.println("File not found");
      System.exit(2);
    }

    for (int i = 0; i < strs.size() - 1; i++) {
      String s1 = strs.get(i);
      String s2 = strs.get(i + 1);
      if (s1.compareTo(s2) > 0) {
        System.out.println(s1 + " and " + s2 + " are out of order");
        break;
      }
    }
  }
}

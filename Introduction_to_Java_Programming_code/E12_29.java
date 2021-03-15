/*
  Suppose you have a lot of files in a directory named Exercisei_j, where i and
  j are digits. Write a program that pads a 0 before j if j is a single digit.
  For example, a file named Exercise2_1 in a directory will be renamed to
  Exercise2_01. Use the following command to run your program:

  java E12_29 *
*/

import java.io.File;

public class E12_29 {
  public static void main(String[] args) {
    for (String s: args) {
      StringBuilder sb = new StringBuilder(s);
      File file = new File(s);
      if (s.matches("Exercise\\d+_\\d")) {
        int index = s.indexOf("_");
        sb.insert((index + 1), "0");
      }
      File newName = new File(sb.toString());
      file.renameTo(newName);
    }
  }
}

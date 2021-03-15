/*
  Suppose you have a lot of files in a directory named Exercisei_j, where
  i and j are digits. Write a program that pads a 0 before i if i is a single
  digit. For example, a file named Exercise2_1 in a directory will be renamed
  to Exercise02_1. Use the following command to run your program:

  java E12_28 *
*/

import java.io.File;

public class E12_28 {
  public static void main(String[] args) {
    for (String s: args) {
      File file = new File(s);
      StringBuilder sb = new StringBuilder(s);
      if (s.matches("Exercise\\d_\\d+")) {
        sb.insert(8, "0");
      }
      File newName = new File(sb.toString());
      file.renameTo(newName);
    }
  }
}

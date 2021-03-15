/*
  Write a program to create a file named E17_01.txt if it does not exist.
  Append new data to it if it already exists. Write 100 integers created
  randomly into the file using text I/O. Integers are separated by a space.
*/

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class E17_01 {
  public static void main(String[] args) throws IOException {
    try (
      PrintWriter output = new PrintWriter(new FileWriter("E17_01.txt", true));
    ) {
      for (int i = 0; i < 100; i++) {
        int ran = (int)(Math.random() * 100);
        output.write(ran + " ");
      }
    }
  }
}

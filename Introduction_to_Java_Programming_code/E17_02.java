/*
  Write a program to create a file named E17_02.dat if it does not exist.
  Append new data to it if it already exists. Write 100 integers created
  randomly into the file using binary I/O.
*/

import java.io.DataOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class E17_02 {
  public static void main(String[] args) throws IOException {
    try (
      DataOutputStream output =
        new DataOutputStream(
          new BufferedOutputStream(new FileOutputStream("E17_02.dat", true)));
    ) {
      for (int i = 0; i < 100; i++) {
        int ran = (int)(Math.random() * 100);
        output.writeInt(ran);
      }
    }
  }
}

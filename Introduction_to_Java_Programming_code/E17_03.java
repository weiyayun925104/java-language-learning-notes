/*
  Suppose a binary data file named E17_03.dat has been created and its data
  are created using writeInt(int) in DataOutputStream. The file contains an
  unspecified number of integers. Write a program to find the sum of the
  integers.
*/

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.File;

public class E17_03 {
  public static void main(String[] args) throws IOException {
    // Create E17_03.dat if it doesn't already exist
    File file = new File("E17_03.dat");

    if (!file.exists()) {
      try (
        DataOutputStream output =
          new DataOutputStream(
            new BufferedOutputStream(new FileOutputStream(file)));
      ) {
        int ran = (int)(Math.random() * 100) + 10;
        for (int i = 0; i < ran; i++) {
          ran = (int)(Math.random() * 100);
          output.writeInt(ran);
        }
      }
    }

    // Sum the contents of E17_03.dat
    int sum = 0;
    try (
      DataInputStream input =
        new DataInputStream(
          new BufferedInputStream(new FileInputStream(file)));
    ) {
      int r;
      while ((r = input.readInt()) != -1) {
        sum += r;
      }
    } catch (EOFException ex) {
      // do nothing
      System.out.println("The sum is " + sum);
    }
  }
}

/*
  Suppose you wish to track how many times a program has been executed. You can
  store an int to count the file. Increase the count by 1 each time this program
  is executed. Let the program be E17_08 and store the count in E17_08.dat.
*/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.EOFException;

public class E17_08 {
  public static void main(String[] args) throws IOException {
    File file = new File("E17_08.dat");

    if (!file.exists()) {
      try (
        DataOutputStream output =
          new DataOutputStream(
            new BufferedOutputStream(new FileOutputStream(file)));
      ) {
        output.writeInt(1);
      }
    } else {
      int count;
      try (
        DataInputStream input =
          new DataInputStream(
            new BufferedInputStream(new FileInputStream(file)));
      ) {
        count = input.readInt();
      }

      try (
        DataOutputStream output =
          new DataOutputStream(
            new BufferedOutputStream(new FileOutputStream(file)));
      ) {
        output.writeInt(count + 1);
      }
    }
  }
}

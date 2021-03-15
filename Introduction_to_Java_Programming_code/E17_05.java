/*
  Write a program that stores an array of the five int values 1, 2, 3, 4, and
  5, a Date object for the current time, and the double value 5.5 into the file
  named E17_05.dat.
*/

import java.io.File;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.util.Date;

public class E17_05 {
  public static void main(String[] args)
    throws IOException, ClassNotFoundException {
    File file = new File("E17_05.dat");

    try (
      ObjectOutputStream output =
        new ObjectOutputStream(
          new BufferedOutputStream(new FileOutputStream(file)));
    ) {
      for (int i = 1; i <= 5; i++) {
        output.writeInt(i);
      }
      output.writeObject(new Date());
      output.writeDouble(5.5);
    }

    // test the above code
    try (
      ObjectInputStream input =
        new ObjectInputStream(
          new BufferedInputStream(new FileInputStream(file)));
    ) {
      for (int i = 0; i < 5; i++) {
        System.out.println(input.readInt());
      }

      System.out.println((Date)input.readObject());
      System.out.println(input.readDouble());
    } catch (EOFException ex) {
      // do nothing
    }
  }
}

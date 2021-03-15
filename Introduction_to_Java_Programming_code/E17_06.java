/*
  The Loan class in Listing 10.2 does not implement Serializable. Rewrite the
  Loan class to implement Serializable. Write a program that creates five Loan
  objects and stores them in a file named E17_06.dat.
*/

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.IOException;

public class E17_06 {
  public static void main(String[] args)
    throws IOException, ClassNotFoundException {
    try (
      ObjectOutputStream output =
        new ObjectOutputStream(
          new BufferedOutputStream(new FileOutputStream("E17_06.dat")));
    ) {
      for (int i = 0; i < 5; i++) {
        double rate = Math.random() * 8 + 2;
        int years = (int)(Math.random() * 10) + 2;
        double amount = Math.random() * 100_000 + 10_000;
        output.writeObject(new Loan(rate, years, amount));
      }
    }

    // test the program
    try (
      ObjectInputStream input =
        new ObjectInputStream(
          new BufferedInputStream(new FileInputStream("E17_06.dat")));
    ) {
      while (true) {
        System.out.println((Loan)input.readObject());
      }
    } catch (EOFException ex) {
      // do nothing
    }
  }
}

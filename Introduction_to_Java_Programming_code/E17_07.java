/*
  Suppose a file named E17_07.dat has been created using the ObjectOutputStream.
  The file contains Loan objects. The Loan class in Listing 10.2 does not
  implement Serializable. Rewrite the Loan class to implement Serializable.
  Write a program that reads the Loan objects from the file and displays the
  total loan amount. Suppose you don't know how many Loan objects are there in
  the file. Use EOFException to end the loop.
*/

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.EOFException;

public class E17_07 {
  public static void main(String[] args)
    throws IOException, ClassNotFoundException {
    // create E17_07.dat
    try (
      ObjectOutputStream output =
        new ObjectOutputStream(new BufferedOutputStream(
          new FileOutputStream("E17_07.dat")));
    ) {
      int ran = (int)(Math.random() * 100) + 10;
      for (int i = 0; i < ran; i++) {
        double rate = Math.random() * 8 + 2;
        int years = (int)(Math.random() * 10) + 2;
        double amount = Math.random() * 100_000 + 10_000;
        output.writeObject(new Loan(rate, years, amount));
      }
    }

    // display the total of the loan amounts
    double sum = 0.0;
    try (
      ObjectInputStream input =
        new ObjectInputStream(new BufferedInputStream(
          new FileInputStream("E17_07.dat")));
    ) {
      while (true) {
        Loan loan = (Loan)input.readObject();
        sum += loan.getLoanAmount();
      }
    } catch (EOFException ex) {
      System.out.println("The total of the loan amounts is " + sum);
    }
  }
}

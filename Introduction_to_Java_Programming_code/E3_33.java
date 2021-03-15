/*
  Suppose you shop for rice in two different packages. You would like to write
  a program to compare the cost. The program prompts the user to enter the
  weight and price of each package and displays the one with the better price.
*/

import java.util.Scanner;

public class E3_33 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter weight and price for package 1: ");
    double aWeight = input.nextDouble();
    double aPrice = input.nextDouble();
    System.out.print("Enter weight and price for package 2: ");
    double bWeight = input.nextDouble();
    double bPrice = input.nextDouble();

    double aPricePerOz = aPrice / aWeight;
    double bPricePerOz = bPrice / bWeight;

    StringBuilder output = new StringBuilder(" has a better price.");
    if (aPricePerOz < bPricePerOz)
      output.insert(0, "Package 1");
    else if (bPricePerOz < aPricePerOz)
      output.insert(0, "Package 2");
    else
      output.replace(0, output.length(),
        "Two packages have the same price.");

    System.out.println(output);
  }
}

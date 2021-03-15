/*
  Write a program that reads an unspecified number of integers, determines
  how many positive and negative values have been read, and computes the
  total and average of the input values (not counting zeros). Your program ends
  with the input 0. Display the average as a floating-point number.
*/

import java.util.Scanner;

public class E5_01 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a series of integers, input ends with 0: ");
    int entry;
    int posCount = 0;
    int negCount = 0;
    double sum = 0.0;
    do {
      entry = input.nextInt();
      if (entry > 0) { posCount++; };
      if (entry < 0) { negCount++; };
      sum += entry;
    } while (entry != 0);

    double average = sum / (posCount + negCount);

    if (posCount == 0 && negCount == 0) {
      System.out.println("No numbers are entered except 0");
    } else {
      System.out.println("The number of positives is " + posCount);
      System.out.println("The number of negatives is " + negCount);
      System.out.println("The total is " + sum);
      System.out.println("The average is " + average);
    }
  }
}

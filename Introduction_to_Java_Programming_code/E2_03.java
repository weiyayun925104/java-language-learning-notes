/*
  Write a program that reads a number in feet, converts it to meters, and
  displays the result. One foot is 0.305 meter.
*/

import java.util.Scanner;

public class E2_03 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a value for feet: ");
    double feet = input.nextDouble();

    double meters = feetToMeters(feet);

    System.out.println(feet + " feet is " + meters + " meters");
  }

  private static double feetToMeters(double feet) {
    return feet * 0.305;
  }
}

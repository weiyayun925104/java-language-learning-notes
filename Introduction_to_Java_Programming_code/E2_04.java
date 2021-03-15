/*
  Write a program that converts pounds into kilograms. The program prompts the
  user to enter a number in pounds, converts it to kilograms, and displays the
  result. One pound is 0.454 kilograms.
*/

import java.util.Scanner;

public class E2_04 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number in pounds: ");
    double pounds = input.nextDouble();

    double kilograms = poundsToKilograms(pounds);

    System.out.println(pounds + " pounds is " + kilograms + " kilograms");
  }

  private static double poundsToKilograms(double pounds) {
    return pounds * 0.454;
  }
}

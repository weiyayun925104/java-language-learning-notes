/*
  Body Mass Index (BMI) is a measure of health on weight. It can be calculated
  by taking your weight in kilograms and dividing by the square of your height
  in meters. Write a program that prompts the user to enter a weight in pounds
  and height in inches and displays the BMI. Note that one pound is
  0.45359273 kilograms and one inch is 0.0254 meters.
*/

import java.util.Scanner;

public class E2_14 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter weight in pounds: ");
    double pounds = input.nextDouble();
    System.out.print("Enter height in inches: ");
    double inches = input.nextDouble();

    double bmi = calculateBMI(pounds, inches);

    System.out.println("BMI is " + bmi);
  }

  private static double calculateBMI(double pounds, double inches) {
    final double KILOGRAMS_PER_POUND = 0.45359273;
    final double METERS_PER_INCH = 0.0254;

    double kilograms = pounds * KILOGRAMS_PER_POUND;
    double meters = inches * METERS_PER_INCH;

    return kilograms / (meters * meters);
  }
}

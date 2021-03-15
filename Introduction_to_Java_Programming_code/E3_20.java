/*
  Programming Exercise 2.17 gives a formula to compute the wind-chill
  temperature. The formula is valid for temperatures in the range between
  -58F and 41F and wind speed greater than or equal to 2. Write a program that
  prompts the user to enter a temperature and a wind speed. The program
  displays the wind-chill temperature if the input is valid; otherwise, it
  displays a message indicating whether the temperature and/or wind speed is
  valid.
*/

import java.util.Scanner;

public class E3_20 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the temperature in Fahrenheit between -58F " +
      "and 41F: ");
    double temperature = input.nextDouble();
    System.out.print("Enter the wind speed (>=2) in miles per hour: ");
    double windSpeed = input.nextDouble();

    // Validate the input
    boolean validTemp = temperature >= -58 && temperature <= 41;
    boolean validWind = windSpeed >= 2;
    if (!validTemp && !validWind) {
      System.out.println("Temperature and windspeed are invalid.");
      System.exit(1);
    } else if (!validTemp) {
      System.out.println("Temperature is invalid.");
      System.exit(2);
    } else if (!validWind) {
      System.out.println("Windspeed is invalid.");
      System.exit(3);
    }

    double windChillIndex = windChillIndex(temperature, windSpeed);

    System.out.println("The wind chill index is " + windChillIndex);
  }

  private static double windChillIndex(double ta, double v) {
    return 35.74 + (0.6215 * ta) - (35.75 * Math.pow(v, 0.16)) +
      (0.4275 * ta * Math.pow(v, 0.16));
  }
}

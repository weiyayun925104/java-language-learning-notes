/*
  Wrote a program that prompts the user to enter the minutes (e.g. 1 billion),
  and displays the number of years and days for the minutes. For simplicity,
  assume a year has 365 days.
*/

import java.util.Scanner;
import java.math.BigInteger;

public class E2_07 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of minutes: ");
    String minutesString = input.nextLine();

    BigInteger minutes = new BigInteger(minutesString);
    BigInteger[] yearsAndDays = yearsAndDaysInMinutes(minutes);

    System.out.println(minutes + " minutes is approximately " +
      yearsAndDays[0] + " years and " + yearsAndDays[1] + " days");
  }

  private static final BigInteger MINUTES_PER_YEAR = new BigInteger("525600");
  private static final BigInteger MINUTES_PER_DAY = new BigInteger("1440");

  private static BigInteger[] yearsAndDaysInMinutes(BigInteger minutes) {
    BigInteger[] yearsAndDays = new BigInteger[2];
    BigInteger currentMinutes = minutes;

    BigInteger years = yearsInMinutes(currentMinutes);
    currentMinutes = currentMinutes.subtract(years.multiply(MINUTES_PER_YEAR));
    BigInteger days = daysInMinutes(currentMinutes);

    yearsAndDays[0] = years;
    yearsAndDays[1] = days;

    return yearsAndDays;
  }

  private static BigInteger yearsInMinutes(BigInteger minutes) {
    return minutes.divide(MINUTES_PER_YEAR);
  }

  private static BigInteger daysInMinutes(BigInteger minutes) {
    return minutes.divide(MINUTES_PER_DAY);
  }
}

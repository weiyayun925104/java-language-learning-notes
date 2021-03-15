/*
  Assume a runner runs 24 miles in 1 hour, 40 minutes, and 35 seconds. Write
  a program that displays the average speed in kilometers per hour.
*/

public class E1_12 {
  public static void main(String[] args) {
    System.out.println("kph: " + mphToKph(milesPerHour(24, 100.58)));
  }

  private static double milesPerHour(double miles, double minutes) {
    return 60.0 * (miles / minutes);
  }

  private static double mphToKph(double mph) {
    return mph * 1.6;
  }
}

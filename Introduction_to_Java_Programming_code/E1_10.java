/*
  Assume a runner runs 14 kilometers in 45 minutes and 30 seconds. Write a
  program that displays the average speed in miles per hour. (Note that 1 mile
  is 1.6 kilometers.)
*/

public class E1_10 {
  public static void main(String[] args) {
    System.out.println("mph: " + kphToMph(kilometersPerHour(14, 45.5)));
  }

  private static double kilometersPerHour(double kilometers, double minutes) {
    return 60.0 * (kilometers / minutes);
  }

  private static double kphToMph(double kph) {
    return kph / 1.6;
  }
}

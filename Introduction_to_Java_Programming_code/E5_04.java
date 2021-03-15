/*
  Write a program that displays the following table (note that 1 miles is
  1.609 kilometers):

  Miles     Kilometers
  1         1.609
  2         3.218
  ...       ...
  9         14.481
  10        16.090
*/

public class E5_04 {
  public static void main(String[] args) {
    final double KILOMETERS_PER_MILE = 1.609;

    System.out.println("Miles     Kilometers");
    for (int i = 1; i <= 10; i++) {
      System.out.printf("%-5d     %-10.3f\n", i, KILOMETERS_PER_MILE * i);
    }
  }
}

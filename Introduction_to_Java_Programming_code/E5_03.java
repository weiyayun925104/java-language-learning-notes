/*
  Write a program that displays the following table (note that 1 kilogram
  is 2.2 pounds):

  Kilograms      Pounds
  1              2.2
  3              6.6
  ...            ...
  197            433.4
  199            437.8
*/

public class E5_03 {
  public static void main(String[] args) {
    final double KILOGRAMS_PER_POUND = 2.2;

    System.out.println("Kilograms     Pounds");
    for (int i = 1; i < 200; i += 2) {
      System.out.printf("%-9d     %6.1f\n", i, KILOGRAMS_PER_POUND * i);
    }
  }
}

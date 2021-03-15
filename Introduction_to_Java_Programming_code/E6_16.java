/*
  Write a method that returns the number of days in a year using the following
  header:

  public static int numberOfDaysInAYear(int year)

  Write a test program that displays the number of days in year from 2000
  to 2020.
*/

public class E6_16 {
  public static void main(String[] args) {
    System.out.println("Year    Days");
    for (int i = 2000; i <= 2020; i++) {
      System.out.printf("%-4d    %-3d\n", i, numberOfDaysInAYear(i));
    }
  }

  public static int numberOfDaysInAYear(int year) {
    return isLeapYear(year) ? 366 : 365;
  }

  public static boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
  }
}

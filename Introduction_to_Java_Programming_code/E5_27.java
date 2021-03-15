/*
  Write a program that displays all the leap years, ten per line, from 101 to
  2100, separated by exactly one space. Also display the number of leaps years
  in this period.
*/

public class E5_27 {
  public static void main(String[] args) {
    final int LEAP_YEARS_PER_LINE = 10;
    int count = 0;
    for (int i = 101; i <= 2100; i++) {
      if (isLeapYear(i)) {
        System.out.printf("%4d ", i);
        count++;
        if (count % LEAP_YEARS_PER_LINE == 0) {
          System.out.println();
        }
      }
    }
    System.out.println();
    System.out.println("count: " + count);
  }

  private static boolean isLeapYear(int y) {
    return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
  }
}

/*
  Write a program that prompts the user to enter the year and first day of the
  year, and displays the first day of each month in the year. For example, if
  the user entered the year 2013, and 2 for Tuesday, January 1, 2013, your
  program should display the following output:

  January 1, 2013 is Tuesday
  ...
  December 1, 2013 is Sunday
*/

import java.util.Scanner;

public class E5_28 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the year: ");
    int year = input.nextInt();
    System.out.print("Enter first day of year (0-6): ");
    int firstDay = input.nextInt();

    String dayName = getDayName(firstDay);
    for (int i = 1; i <= 12; i++) {
      String monthName = getMonthName(i);
      System.out.println(monthName + " 1, " + year + " is " + dayName);
      firstDay += getDaysInMonth(i, year);
      dayName = getDayName(firstDay % 7);
    }
  }

  private static int getDaysInMonth(int m, int y) {
    int days = -1;
    if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
      days = 31;
    } else if (m == 4 || m == 6 || m == 9 || m == 11) {
      days = 30;
    } else if (m == 2) {
      days = isLeapYear(y) ? 29 : 28;
    }
    return days;
  }

  private static boolean isLeapYear(int y) {
    return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
  }

  private static String getMonthName(int m) {
    StringBuilder s = new StringBuilder();
    switch (m) {
      case 1: s.append("January"); break;
      case 2: s.append("February"); break;
      case 3: s.append("March"); break;
      case 4: s.append("April"); break;
      case 5: s.append("May"); break;
      case 6: s.append("June"); break;
      case 7: s.append("July"); break;
      case 8: s.append("August"); break;
      case 9: s.append("September"); break;
      case 10: s.append("October"); break;
      case 11: s.append("November"); break;
      case 12: s.append("December");
    }
    return s.toString();
  }

  private static String getDayName(int d) {
    StringBuilder s = new StringBuilder();
    switch (d) {
      case 0: s.append("Sunday"); break;
      case 1: s.append("Monday"); break;
      case 2: s.append("Tuesday"); break;
      case 3: s.append("Wednesday"); break;
      case 4: s.append("Thursday"); break;
      case 5: s.append("Friday"); break;
      case 6: s.append("Saturday");
    }
    return s.toString();
  }
}

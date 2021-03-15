/*
  Programming Exercise 3.21 uses Zeller's congruence to calcuate the day of the
  week. Simplify Listing 6.12, PrintCalendar.java, using Zeller's algorithm
  to get the start day of the month.
*/

import java.util.Scanner;

public class E6_34 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter full year (eg 2012): ");
    int year = input.nextInt();
    System.out.print("Enter month as a number between 1 and 12: ");
    int month = input.nextInt();

    printMonth(year, month);
  }

  public static void printMonth(int year, int month) {
    printMonthTitle(year, month);
    printMonthBody(year, month);
  }

  public static void printMonthTitle(int year, int month) {
    System.out.println("         " + getMonthName(month) + " " + year);
    System.out.println(" ---------------------------");
    System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
  }

  public static String getMonthName(int month) {
    String monthName = "";
    switch (month) {
      case 1: monthName = "January"; break;
      case 2: monthName = "February"; break;
      case 3: monthName = "March"; break;
      case 4: monthName = "April"; break;
      case 5: monthName = "May"; break;
      case 6: monthName = "June"; break;
      case 7: monthName = "July"; break;
      case 8: monthName = "August"; break;
      case 9: monthName = "September"; break;
      case 10: monthName = "October"; break;
      case 11: monthName = "November"; break;
      case 12: monthName = "December";
    }
    return monthName;
  }

  public static void printMonthBody(int year, int month) {
    int startDay = getStartDay(year, month, 1);
    int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

    int i = 0;
    for (i = 0; i < startDay; i++) {
      System.out.print("    ");
    }
    for (i = 1; i <= numberOfDaysInMonth; i++) {
      System.out.printf("%4d", i);

      if ((i + startDay) % 7 == 0) {
        System.out.println();
      }
    }
    System.out.println();
  }

  public static int getStartDay(int year, int month, int day) {
    // Zeller's congruence algorithm
    if (month == 1) { month = 13; year--; }
    if (month == 2) { month = 14; year--; }
    int k = year % 100;
    int j = year / 100;
    int h = (day + ((26 * (month + 1)) / 10) + k + (k / 4) + (j / 4) +
      (5 * j)) % 7;

    // Zeller result starts with 0 for Saturday, so we subtract 1 here.
    // To prevent 0 result from going negative, we wrap it back around to 6.
    if (h == 0) { h = 6; }
    else { h--; }
    return h;
  }

  public static int getNumberOfDaysInMonth(int year, int month) {
    if (month == 1 || month == 3 || month == 5 || month == 7 ||
        month == 8 || month == 10 || month == 12) {
      return 31;
    }
    if (month == 4 || month == 6 || month == 9 || month == 11) {
      return 30;
    }
    if (month == 2) {
      return isLeapYear(year) ? 29 : 28;
    }
    return 0;
  }

  public static boolean isLeapYear(int year) {
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  }
}

/*
  Write a program that prompts the user to enter the year and first day of the
  year and displays the calendar table for the year on the console. For
  example, if the user entered the year 2013, and 2 for Tuesday, January 1,
  2013, your program should display the calendar for each month in the year.
*/

import java.util.Scanner;

public class E5_29 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the year: ");
    int year = input.nextInt();
    System.out.print("Enter first day of year (0-6): ");
    int firstDay = input.nextInt();

    for (int i = 1; i <= 12; i++) {
      displayCalendar(i, firstDay, year);
      firstDay = (getDaysInMonth(i, year) + firstDay) % 7;
    }
  }

  private static void displayCalendar(int month, int firstDay, int year) {
    String monthName = getMonthName(month);
    int daysInMonth = getDaysInMonth(month, year);
    String padding = "      ";
    System.out.println();
    System.out.println(monthName + " " + year);
    System.out.println("---------------------------------------");
    System.out.println("Sun   Mon   Tue   Wed   Thu   Fri   Sat");
    // print padding
    for (int i = 0; i < firstDay; i++) {
      System.out.print(padding);
    }
    int count = firstDay;
    for (int i = 1; i <= daysInMonth; i++) {
      if (count == 7) {
        System.out.println();
        count = 0;
      }
      System.out.printf("%3d   ", i);
      count++;
    }
    System.out.println();
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
}

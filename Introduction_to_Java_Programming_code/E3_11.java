/*
  Write a program that prompts the user to enter the month and year and
  displays the number of days in the month. For example, if the user entered
  2 and year 2012, the program should display that February 2012 had 29 days.
  If the user entered month 3 and year 2015, the program should display that
  March 2015 had 31 days.
*/

import java.util.Scanner;

public class E3_11 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a month (1-12): ");
    int month = input.nextInt();
    System.out.print("Enter a year: ");
    int year = input.nextInt();

    String monthName = getMonthName(month);
    int daysInMonth = getDaysInMonth(month, year);

    System.out.println(monthName + " " + year + " has " + daysInMonth +
      " days");
  }

  private static String getMonthName(int m) {
    StringBuilder output = new StringBuilder();
    if (m < 1 || m > 12) {
      output.append("Invalid entry. Months are denoted by numbers 1-12.");
    } else {
      switch (m) {
        case 1: output.append("January"); break;
        case 2: output.append("February"); break;
        case 3: output.append("March"); break;
        case 4: output.append("April"); break;
        case 5: output.append("May"); break;
        case 6: output.append("June"); break;
        case 7: output.append("July"); break;
        case 8: output.append("August"); break;
        case 9: output.append("September"); break;
        case 10: output.append("October"); break;
        case 11: output.append("November"); break;
        case 12: output.append("December");
      }
    }
    return output.toString();
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
    return (y % 4 == 0 && !(y % 100 == 0)) || y % 400 == 0;
  }
}

/*
  Zeller's congruence is an algorithm developed by Christian Zeller to
  calculate the day of the week. The formula is

                  (complicated formula)

  Note that the division in the formula performs an integer division. Write a
  program that prompts the user to enter a year, month, and day of the month,
  and displays the name of the day of the week.
*/

import java.util.Scanner;

public class E3_21 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter year (e.g. 2012): ");
    int year = input.nextInt();
    System.out.print("Enter month: ");
    int month = input.nextInt();
    // formula needs Jan to be 13 and Feb to be 14
    // in these cases, the year must also be decremented
    if (month == 1) { month = 13; year--; }
    if (month == 2) { month = 14; year--; }
    System.out.print("Enter the day of the month (1-31): ");
    int dayOfMonth = input.nextInt();

    String day = dayName(zeller(year, month, dayOfMonth));
    System.out.println("Day of the week is " + day);
  }

  private static int zeller(int y, int m, int d) {
    int k = y % 100;
    int j = y / 100;
    int h = (d + ((26 * (m + 1)) / 10) + k + (k / 4) + (j / 4) + (5 * j)) % 7;
    return h;
  }

  private static String dayName(int day) {
    StringBuilder s = new StringBuilder();
    switch (day) {
      case 0: s.append("Saturday"); break;
      case 1: s.append("Sunday"); break;
      case 2: s.append("Monday"); break;
      case 3: s.append("Tuesday"); break;
      case 4: s.append("Wednesday"); break;
      case 5: s.append("Thursday"); break;
      case 6: s.append("Friday"); break;
    }
    return s.toString();
  }
}

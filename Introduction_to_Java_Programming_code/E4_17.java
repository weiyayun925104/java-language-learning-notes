
import java.util.Scanner;

public class E4_17 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a year: ");
    String year = input.nextLine();
    if (!isValidYear(year)) {
      System.out.println("Error: Invalid year.");
      System.exit(1);
    }

    System.out.print("Enter a month: ");
    String month = input.nextLine();
    if (!isValidMonth(month)) {
      System.out.println("Error: Invalid month.");
      System.exit(2);
    }

    System.out.println(getMonthPrefix(month, false) + " " + year + " has " +
      getDaysInMonth(month, year) + " days");
  }

  private static int getDaysInMonth(String month, String year) {
    int days = -1;
    int n = getMonthNumber(month);
    if (n == 1 || n == 3 || n == 5 || n == 7 || n == 8 || n == 10 || n == 12) {
      days = 31;
    } else if (n == 4 || n == 6 || n == 9 || n == 1) {
      days = 30;
    } else if (n == 2) {
      days = isLeapYear(Integer.parseInt(year)) ? 29 : 28;
    }
    return days;
  }

  private static boolean isLeapYear(int year) {
    return (year % 4 == 0 && !(year % 100 == 0)) || year % 400 == 0;
  }

  private static boolean isValidYear(String year) {
    boolean valid = true;
    try {
      Integer.parseInt(year);
    } catch (Exception e) {
      valid = false;
    }
    return valid;
  }

  private static boolean isValidMonth(String month) {
    boolean valid = true;
    if (month.length() < 3) {
      valid = false;
    } else {
      int monthNumber = getMonthNumber(month);
      if (monthNumber == -1) {
        valid = false;
      }
    }
    return valid;
  }

  private static String getMonthPrefix(String month, boolean lowercase) {
    String prefix = month.substring(0, 3);
    String firstLetter = month.substring(0, 1);
    StringBuilder s = new StringBuilder();
    if (lowercase) {
      s.append(prefix.toLowerCase());
    } else {
      s.append(prefix);
      s.replace(0, 1, firstLetter.toUpperCase());
    }
    return s.toString();
  }

  private static int getMonthNumber(String month) {
    int n = -1;
    switch (getMonthPrefix(month, true)) {
      case "jan": n = 1; break;
      case "feb": n = 2; break;
      case "mar": n = 3; break;
      case "apr": n = 4; break;
      case "may": n = 5; break;
      case "jun": n = 6; break;
      case "jul": n = 7; break;
      case "aug": n = 8; break;
      case "sep": n = 9; break;
      case "oct": n = 10; break;
      case "nov": n = 11; break;
      case "dec": n = 12;
    }
    return n;
  }
}

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class PrintCalendar {
  public static void printMonth(GregorianCalendar g) {
    printMonthTitle(g);
    printMonthBody(g);
  }

  public static void printMonthTitle(GregorianCalendar g) {
    String monthString =
      g.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
    System.out.println("         " + monthString + " " + g.get(Calendar.YEAR));
    System.out.println("-----------------------------");
    System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
  }

  public static void printMonthBody(GregorianCalendar g) {
    int startDay = getStartDay(g);
    int numberOfDaysInMonth = getNumberOfDaysInMonth(g);
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

  public static int getStartDay(GregorianCalendar g) {
    // decrement by one, since Calendar uses a different numbering scheme
    // for days of the week
    return g.get(Calendar.DAY_OF_WEEK) - 1;
  }

  public static int getNumberOfDaysInMonth(GregorianCalendar g) {
    int month = g.get(Calendar.MONTH);
    if (month == 0 || month == 2 || month == 4 || month == 6 ||
        month == 7 || month == 9 || month == 11) {
      return 31;
    }
    if (month == 3 || month == 5 || month == 8 || month == 10) {
      return 30;
    }
    if (month == 1) {
      return isLeapYear(g) ? 29 : 28;
    }
    return 0;
  }

  public static boolean isLeapYear(GregorianCalendar g) {
    int year = g.get(Calendar.YEAR);
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  }
}

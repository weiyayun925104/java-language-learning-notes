
import java.util.Calendar;
import java.util.GregorianCalendar;

public class E13_04 {
  public static void main(String[] args) {
    if (!isValidInput(args)) {
      System.out.println("Usage: java E13_04 [month(1-12)] [year(4 digits)]");
      System.exit(1);
    }

    // create a GregorianCalendar for the current date in order to handle
    // default input values
    GregorianCalendar g = new GregorianCalendar();
    int month = 0;
    int year = 0;

    // if input is ordinary (month year)
    if (args.length == 2) {
      month = Integer.parseInt(args[0]) - 1; // decrement input month by 1
      year = Integer.parseInt(args[1]);
    // if input is month only
  } else if (args.length == 1 && (args[0].length() == 1 || args[0].length() == 2)) {
      month = Integer.parseInt(args[0]) - 1; // decrement input month by 1
      year = g.get(Calendar.YEAR);
    // if input is year only
    } else if (args.length == 1 && args[0].length() == 4) {
      month = g.get(Calendar.MONTH);
      year = Integer.parseInt(args[0]);
    // if input is default (blank)
    } else {
      month = g.get(Calendar.MONTH);
      year = g.get(Calendar.YEAR);
    }

    g = new GregorianCalendar(year, month, 1);
    PrintCalendar.printMonth(g);
  }

  public static boolean isValidInput(String[] args) {
    if (args.length > 2) {
      return false;
    }

    if (args.length == 2) {
      if (!args[0].matches("[1-9]") && !args[0].matches("1[012]")) {
        return false;
      }
      if (!args[1].matches("\\d\\d\\d\\d")) {
        return false;
      }
    }

    if (args.length == 1) {
      if (!args[0].matches("[1-9]") && !args[0].matches("1[012]") &&
          !args[0].matches("\\d\\d\\d\\d")) {
        return false;
      }
    }

    return true;
  }
}

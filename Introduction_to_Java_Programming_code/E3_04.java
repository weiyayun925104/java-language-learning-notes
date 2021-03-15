/*
  Write a program that randomly generates an integer between 1 and 12 and
  displays the English month name January, February, ..., December for the
  number 1, 2, ..., 12, accordingly.
*/

public class E3_04 {
  public static void main(String[] args) {
    int random = (int)(Math.random() * 12) + 1;
    System.out.println(getMonthName(random));
  }

  private static String getMonthName(int n) {
    StringBuilder output = new StringBuilder();

    if (n < 1 || n > 12) {
      output.append("Error. Number must be between 1 and 12, inclusive.");
    } else {
      switch (n) {
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
        case 12: output.append("December"); break;
      }
    }
    return output.toString();
  }
}

/*
  Write a program that prompts the user to enter two characters and displays
  the major and status represented in the characters. The first character
  indicates the major and the second is the number character 1, 2, 3, 4 which
  indicates whether a student is a freshman, sophomore, junior, or senior.
  Suppose the following characters are used to denote the majors:

  M: Mathematics
  C: Computer Science
  I: Information Technology
*/

import java.util.Scanner;

public class E4_18 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter two characters: ");
    String entry = input.nextLine();
    if (!isValidEntry(entry)) {
      System.out.println("Invalid entry.");
      System.exit(1);
    }

    String major = getMajorName(parseMajor(entry));
    String year = getYearName(parseYear(entry));

    System.out.println(major + " " + year);
  }

  private static char parseMajor(String entry) {
    return entry.toLowerCase().charAt(0);
  }

  private static char parseYear(String entry) {
    return entry.toLowerCase().charAt(1);
  }

  private static String getMajorName(char major) {
    StringBuilder majorName = new StringBuilder();
    switch (major) {
      case 'm': majorName.append("Mathematics"); break;
      case 'c': majorName.append("Computer Science"); break;
      case 'i': majorName.append("Information Technology");
    }
    return majorName.toString();
  }

  private static String getYearName(char year) {
    StringBuilder yearName = new StringBuilder();
    switch (year) {
      case '1': yearName.append("Freshman"); break;
      case '2': yearName.append("Sophomore"); break;
      case '3': yearName.append("Junior"); break;
      case '4': yearName.append("Senior");
    }
    return yearName.toString();
  }

  private static boolean isValidEntry(String entry) {
    boolean valid = true;
    if (entry.length() != 2) {
      valid = false;
    } else {
      String sLC = entry.toLowerCase();
      char c1 = sLC.charAt(0);
      char c2 = sLC.charAt(1);

      if ((c1 != 'm' && c1 != 'c' && c1 != 'i') ||
          (c2 != '1' && c2 != '2' && c2 != '3' && c2 != '4')) {
        valid = false;
      }
    }
    return valid;
  }
}

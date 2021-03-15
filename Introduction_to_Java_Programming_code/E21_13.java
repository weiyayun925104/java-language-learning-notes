/*
  Revise Programming Exercise 21.11 to prompt the user to enter year, gender,
  and name and display the ranking for the name. Prompt the user to enter
  another inquiry or exit the program.
*/

import java.util.Scanner;
import java.io.IOException;

public class E21_13 {
  public static void main(String[] args) throws IOException {
    BabyNames bn = new BabyNames();

    Scanner input = new Scanner(System.in);
    do {
      System.out.print("Enter the year: ");
      int year = input.nextInt();

      if (year < 2001 || year > 2010) {
        System.out.println("Year must be between 2001 and 2010");
        continue;
      }

      System.out.print("Enter the gender (M/F): ");
      String gender = input.next().toLowerCase();

      if (!gender.equals("m") && !gender.equals("f")) {
        System.out.println("Please enter either M or F for gender");
        continue;
      }

      System.out.print("Enter the name: ");
      String name = input.next();

      printRanking(bn, year, gender, name);

      System.out.print("Enter another inquiry? (N to exit): ");
      if (input.next().toLowerCase().equals("n")) {
        System.exit(1);
      }

    } while (true);
  }

  private static void printRanking(
    BabyNames bn, int year, String gender, String name) {
    int index = getIndexForYear(year);
    String rank = "";
    StringBuilder result = new StringBuilder();
    if (gender.equals("m")) {
      rank = bn.getBoyData().get(index).get(name);
      result.append("Boy ");
    } else {
      rank = bn.getGirlData().get(index).get(name);
      result.append("Girl ");
    }
    if (rank == null) {
      System.out.println("Name not found ");
      return;
    }
    result.append("name " + name + " is ranked #" + rank + " in year " + year);
    System.out.println(result);
  }

  private static int getIndexForYear(int year) {
    for (int i = 0, j = 2001; i < 10; i++, j++) {
      if (j == year) { return i; }
    }
    return -1; // shouldn't happen
  }
}

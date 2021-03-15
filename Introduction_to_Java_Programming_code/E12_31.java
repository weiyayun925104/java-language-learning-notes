/*
  The popularity ranking of baby names from years 2001 to 2010 is downloaded
  from (ssa.gov) and stored in files named babynameranking2001.txt, and so on.
  Each file contains one thousand lines. Each line contains a ranking, a boy's
  name, number for the boy's name, a girl's name, and number for the girl's
  name.

  Write a program that prompts the user to enter the year, gender, and a name,
  then displays the ranking of the name for the year.
*/

import java.io.File;
import java.util.Scanner;

public class E12_31 {
  public static void main(String[] args) throws Exception {
    // get user input
    Scanner userInput = new Scanner(System.in);
    System.out.print("Enter the year: ");
    String year = userInput.nextLine();
    System.out.print("Enter the gender: ");
    String gender = userInput.nextLine().toLowerCase();
    System.out.print("Enter the name: ");
    String name = userInput.nextLine();

    File babyNames = new File("babynameranking" + year + ".txt");

    // check whether the file exists
    if (!babyNames.exists()) {
      System.out.println("No file for " + year + " was found");
      System.exit(1);
    }

    try (
      Scanner fileInput = new Scanner(babyNames);
    ) {
      while (fileInput.hasNext()) {
        String rank = fileInput.next();
        String mName = fileInput.next().toLowerCase();
        String mBirths = fileInput.next();
        String fName = fileInput.next().toLowerCase();
        String fBirths = fileInput.next();
        if ((gender.equals("m") && mName.equals(name.toLowerCase())) ||
            (gender.equals("f") && fName.equals(name.toLowerCase()))) {
          System.out.println(name + " is ranked #" + rank + " in year " + year);
          System.exit(0);
        }
      }
      System.out.println("The name " + name + " is not ranked in year "
        + year);
    }
  }
}

/*
  Rewrite Listing 4.3, GuessBirthday.java, to prompt the user to enter the
  character Y for Yes and N for No rather than entering 1 for Yes and 0 for No.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class E4_10 {
  public static void main(String[] args) {
    ArrayList<String> sets = new ArrayList<>();

    String set1 =
      " 1  3  5  7\n" +
      " 9 11 13 15\n" +
      "17 19 21 23\n" +
      "25 27 29 31";

    String set2 =
      " 2  3  6  7\n" +
      "10 11 14 15\n" +
      "18 19 22 23\n" +
      "26 27 30 31";

    String set3 =
      " 4  5  6  7\n" +
      "12 13 14 15\n" +
      "20 21 22 23\n" +
      "28 29 30 31";

    String set4 =
      " 8  9 10 11\n" +
      "12 13 14 15\n" +
      "24 25 26 27\n" +
      "28 29 30 31";

    String set5 =
      "16 17 18 19\n" +
      "20 21 22 23\n" +
      "24 25 26 27\n" +
      "28 29 30 31";

    sets.add(set1);
    sets.add(set2);
    sets.add(set3);
    sets.add(set4);
    sets.add(set5);

    Scanner input = new Scanner(System.in);
    String answer;

    int day = 0;
    for (int i = 1, count = 1; i <= 5; i++, count *= 2) {
      System.out.print("Is your birthday in Set" + i + "?\n");
      System.out.print(sets.get(i - 1));
      System.out.print("\nEnter Y for Yes or N for No: ");
      answer = input.nextLine();

      if (answer.toLowerCase().equals("y")) {
        day += count;
      } else if (answer.toLowerCase().equals("n")) {
        continue;
      } else {
        System.out.println("Invalid entry.");
        System.exit(1);
      }
    }

    System.out.println("\nYour birthday is " + day + "!");
  }
}

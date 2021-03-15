/*
  Write a program that repeatedly prompts the user to enter a capital for a
  state. Upon receiving the user input, the program reports whether the answer
  is correct. Assume that 50 states and their capitals are stored in a two-
  dimensional array. The program prompts the user to answer all states' capitals
  and displays the total correct count. The user's answer is not case-sensitive.
*/

import java.util.Scanner;

public class E8_37 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("The correct count is " + startTest(input));
  }

  public static int startTest(Scanner input) {
    String[][] capitals = {
      {"Alabama", "Montgomery"},
      {"Alaska", "Juneau"},
      {"Arizona", "Phoenix"},
      {"Arkansas", "Little Rock"},
      {"California", "Sacramento"},
      {"Colorado", "Denver"},
      {"Connecticut", "Hartford"},
      {"Delaware", "Dover"},
      {"Florida", "Tallahassee"},
      {"Georgia", "Atlanta"},
      {"Hawaii", "Honolulu"},
      {"Idaho", "Boise"},
      {"Illinois", "Springfield"},
      {"Indiana", "Indianapolis"},
      {"Iowa", "Des Moines"},
      {"Kansas", "Topeka"},
      {"Kentucky", "Frankfort"},
      {"Louisiana", "Baton Rouge"},
      {"Maine", "Augusta"},
      {"Maryland", "Annapolis"},
      {"Massachusetts", "Boston"},
      {"Michigan", "Lansing"},
      {"Minnesota", "St. Paul"},
      {"Mississippi", "Jackson"},
      {"Missouri", "Jefferson City"},
      {"Montana", "Helena"},
      {"Nebraska", "Lincoln"},
      {"Nevada", "Carson City"},
      {"New Hampshire", "Concord"},
      {"New Jersey", "Trenton"},
      {"New Mexico", "Santa Fe"},
      {"New York", "Albany"},
      {"North Carolina", "Raleigh"},
      {"North Dakota", "Bismarck"},
      {"Ohio", "Columbus"},
      {"Oklahoma", "Oklahoma City"},
      {"Oregon", "Salem"},
      {"Pennsylvania", "Harrisburg"},
      {"Rhode Island", "Providence"},
      {"South Carolina", "Columbia"},
      {"South Dakota", "Pierre"},
      {"Tennessee", "Nashville"},
      {"Texas", "Austin"},
      {"Utah", "Salt Lake City"},
      {"Vermont", "Montpelier"},
      {"Virginia", "Richmond"},
      {"Washington", "Olympia"},
      {"West Virginia", "Charleston"},
      {"Wisconsin", "Madison"},
      {"Wyoming", "Cheyenne"}
    };

    int count = 0;

    for (int i = 0; i < capitals.length; i++) {
      System.out.print("What is the capital of " + capitals[i][0] + "? ");
      if (input.nextLine().toLowerCase().equals(capitals[i][1].toLowerCase())) {
        System.out.println("Your answer is correct");
        count++;
      } else {
        System.out.println("The correct answer should be " + capitals[i][1]);
      }
    }

    return count;
  }
}

/*
  Rewrite Programming Exercise 8.37 to store the pairs of states and capitals
  so that the questions are displayed randomly.
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class E20_03 {
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

    List<String[]> list = new ArrayList<>(Arrays.asList(capitals));
    Collections.shuffle(list);

    int count = 0;

    for (int i = 0; i < list.size(); i++) {
      System.out.print("What is the capital of " + list.get(i)[0] + "? ");
      if (input.nextLine().toLowerCase().equals(list.get(i)[1].toLowerCase())) {
        System.out.println("Your answer is correct");
        count++;
      } else {
        System.out.println("The correct answer should be " + list.get(i)[1]);
      }
    }

    return count;
  }
}

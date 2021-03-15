/*
  Rewrite Programming Exercise 8.37 to store pairs of each state and its capital
  in a map. Your program should prompt the user to enter a state and should
  display the capital for the state.
*/

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class E21_09 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a state: ");
    String state = input.nextLine().toLowerCase();

    Map<String, String> statesAndCapitals = getStatesAndCapitals();

    if (statesAndCapitals.containsKey(state)) {
      System.out.println(statesAndCapitals.get(state));
    } else {
      System.out.println("Not a state");
    }
  }

  public static HashMap<String, String> getStatesAndCapitals() {
    HashMap<String, String> map = new HashMap<>();
    map.put("alabama", "Montgomery");
    map.put("alaska", "Juneau");
    map.put("arizona", "Phoenix");
    map.put("arkansas", "Little Rock");
    map.put("california", "Sacramento");
    map.put("colorado", "Denver");
    map.put("connecticut", "Hartford");
    map.put("delaware", "Dover");
    map.put("florida", "Tallahassee");
    map.put("georgia", "Atlanta");
    map.put("hawaii", "Honolulu");
    map.put("idaho", "Boise");
    map.put("illnois", "Springfield");
    map.put("indiana", "Indianapolis");
    map.put("iowa", "Des Moines");
    map.put("kansas", "Topeka");
    map.put("kentucky", "Frankfort");
    map.put("kouisiana", "Baton Rouge");
    map.put("maine", "Augusta");
    map.put("maryland", "Annapolis");
    map.put("massachusetts", "Boston");
    map.put("michigan", "Lansing");
    map.put("minnesota", "St. Paul");
    map.put("mississippi", "Jackson");
    map.put("missouri", "Jefferson City");
    map.put("montana", "Helena");
    map.put("nebraska", "Lincoln");
    map.put("nevada", "Carson City");
    map.put("new hampshire", "Concord");
    map.put("new jersey", "Trenton");
    map.put("new mexico", "Santa Fe");
    map.put("new york", "Albany");
    map.put("north carolina", "Raleigh");
    map.put("north dakota", "Bismarck");
    map.put("ohio", "Columbus");
    map.put("oklahoma", "Oklahoma City");
    map.put("oregon", "Salem");
    map.put("pennsylvania", "Harrisburg");
    map.put("rhode island", "Providence");
    map.put("south carolina", "Columbia");
    map.put("south dakota", "Pierre");
    map.put("tennessee", "Nashville");
    map.put("texas", "Austin");
    map.put("utah", "Salt Lake City");
    map.put("vermont", "Montpelier");
    map.put("virginia", "Richmond");
    map.put("washington", "Olympia");
    map.put("west virginia", "Charleston");
    map.put("wisconsin", "Madison");
    map.put("wyoming", "Cheyenne");
    return map;
  }
}

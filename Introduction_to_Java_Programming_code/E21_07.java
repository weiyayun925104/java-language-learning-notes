/*
  Rewrite Listing 21.9 to display the words in ascending order of occurrence
  counts.
*/

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class E21_07 {
  public static void main(String[] args) {
    String text = "Good morning. Have a good class. " +
      "Have a good visit. Have fun!";

    Map<String, Integer> map = new TreeMap<>();

    String[] words = text.split("[ \n\t\r.,;:!?(){]");
    for (int i = 0; i < words.length; i++) {
      String key = words[i].toLowerCase();

      if (key.length() > 0) {
        if (!map.containsKey(key)) {
          map.put(key, 1);
        } else {
          int value = map.get(key);
          value++;
          map.put(key, value);
        }
      }
    }

    Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

    List<WordOccurrence> wordOccurrenceList = new ArrayList<>();
    for (Map.Entry<String, Integer> e: entrySet) {
      wordOccurrenceList.add(new WordOccurrence(e.getKey(), e.getValue()));
    }

    Collections.sort(wordOccurrenceList);
    System.out.println(wordOccurrenceList);
  }
}

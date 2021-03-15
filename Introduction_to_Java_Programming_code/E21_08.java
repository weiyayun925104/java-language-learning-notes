/*
  Rewrite Listing 21.9 to read the text from a text file. The text file is
  passed as a command-line argument. Words are delimited by whitespace
  characters, punctuation marks (,;.:?), quotation marks('"), and parentheses.
  Count words in case-insensitive fashion (e.g. consider Good and good to be
  the same word). The words must start with a letter. Display the output in
  alphabetical order of words, with each word preceded by its occurrence count.
*/

import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class E21_08 {
  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.out.println("Usage: java E21_08 filename.txt");
      System.exit(1);
    }

    File file = new File(args[0]);

    if (!file.exists()) {
      System.out.println(file.getName() + " does not exist");
      System.exit(2);
    }

    if (!file.isFile()) {
      System.out.println(file.getName() + " is a directory");
      System.exit(3);
    }

    String text = getText(file);

    Map<String, Integer> map = new TreeMap<>();

    String[] words = text.split("[ \n\t\r.,;:!?(){]");
    for (int i = 0; i < words.length; i++) {
      String key = words[i].toLowerCase();

      if (key.length() > 0 && Character.isLetter(key.charAt(0))) {
        if (!map.containsKey(key)) {
          map.put(key, 1);
        } else {
          int value = map.get(key);
          value++;
          map.put(key, value);
        }
      }
    }

    for (Map.Entry<String, Integer> entry: map.entrySet()) {
      System.out.println(entry.getValue() + "\t" + entry.getKey());
    }
  }

  public static String getText(File file) throws IOException {
    StringBuilder sb = new StringBuilder();

    Scanner input = new Scanner(file);
    while (input.hasNext()) {
      sb.append(input.nextLine() + "\n");
    }
    input.close();

    return sb.toString();
  }
}

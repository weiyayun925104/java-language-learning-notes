/*
  Rewrite Listing 12.18, WebCrawler.java, to improve performance by using
  appropriate new data structures for listOfPendingURLs and listOfTraversedURLs.
*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class E21_14 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a URL: ");
    String url = input.nextLine();
    crawler(url);
  }

  public static void crawler(String startingURL) {
    Queue<String> listOfPendingURLs = new LinkedList<>();
    Set<String> setOfTraversedURLs = new HashSet<>();

    listOfPendingURLs.add(startingURL);
    while (!listOfPendingURLs.isEmpty() &&
           setOfTraversedURLs.size() <= 100) {
      String urlString = listOfPendingURLs.poll();
      setOfTraversedURLs.add(urlString);
      System.out.println("Craw " + urlString);
      for (String s: getSubURLs(urlString)) {
        if (!setOfTraversedURLs.contains(s)) {
          listOfPendingURLs.add(s);
        }
      }
    }
  }

  public static Set<String> getSubURLs(String urlString) {
    Set<String> set = new HashSet<>();

    try {
      java.net.URL url = new java.net.URL(urlString);
      Scanner input = new Scanner(url.openStream());
      int current = 0;
      while (input.hasNext()) {
        String line = input.nextLine();
        current = line.indexOf("http:", current);
        while (current > 0) {
          int endIndex = line.indexOf("\"", current);
          if (endIndex > 0) {
            set.add(line.substring(current, endIndex));
            current = line.indexOf("http:", endIndex);
          } else {
            current = -1;
          }
        }
      }
    } catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    }

    return set;
  }
}

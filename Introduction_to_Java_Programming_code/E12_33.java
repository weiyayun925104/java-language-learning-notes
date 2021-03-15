import java.util.Scanner;
import java.util.ArrayList;
import java.net.URL;

public class E12_33 {
  public static void main(String[] args) {
    String url = "http://cs.armstrong.edu/liang";
    crawler(url);
  }

  public static void crawler(String startingURL) {
    ArrayList<String> listOfPendingURLs = new ArrayList<>();
    ArrayList<String> listOfTraversedURLs = new ArrayList<>();

    listOfPendingURLs.add(startingURL);
    while (!listOfPendingURLs.isEmpty()) {
      String urlString = listOfPendingURLs.remove(0);
      if (!listOfTraversedURLs.contains(urlString)) {
        listOfTraversedURLs.add(urlString);
        System.out.println("Craw " + urlString);

        for (String s: getSubURLs(urlString)) {
          if(!listOfTraversedURLs.contains(s)) {
            listOfPendingURLs.add(s);
          }
        }
      }
    }
  }

  public static ArrayList<String> getSubURLs(String urlString) {
    ArrayList<String> list = new ArrayList<>();

    try {
      URL url = new URL(urlString);
      Scanner input = new Scanner(url.openStream());
      int current = 0;
      while (input.hasNext()) {
        String line = input.nextLine();
        // if the line contains the phrase, print the url and exit
        if (line.contains("Computer Programming")) {
          System.out.println("FOUND at " + urlString);
          System.exit(1);
        }
        current = line.indexOf("http:", current);
        while (current > 0) {
          int endIndex = line.indexOf("\"", current);
          if (endIndex > 0) {
            list.add(line.substring(current, endIndex));
            current = line.indexOf("http:", endIndex);
          } else {
            current = -1;
          }
        }
      }
    } catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    }

    return list;
  }
}

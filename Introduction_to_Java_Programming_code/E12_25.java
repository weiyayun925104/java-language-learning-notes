/*
  A university posts its employees' salaries at
  http://cs.armstrong.edu/liang/data/Salary.txt. Each line in the file consists
  of a faculty member's first name, last name, rank, and salary. Write a
  program to display the total salary for assistant professors, associate
  professors, full professors, and all faculty, respectively, and display the
  average salary for assistant professors, associate professors, full
  professors, and all faculty, respectively.
*/

import java.net.URL;
import java.util.Scanner;

public class E12_25 {
  public static void main(String[] args) {
    try {
      URL url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
      Scanner input = new Scanner(url.openStream());
      String[] ranks = {"assistant", "associate", "full"};
      double assistantSalaries = 0.0;
      double associateSalaries = 0.0;
      double fullSalaries = 0.0;
      double allSalaries = 0.0;
      int assistantCount = 0;
      int associateCount = 0;
      int fullCount = 0;
      int allCount = 0;
      while (input.hasNext()) {
        // move past the first and last names
        input.next(); input.next();
        String rank = input.next();
        double salary = input.nextDouble();
        allSalaries += salary;
        allCount++;
        if (rank.equals(ranks[0])) {
          assistantSalaries += salary;
          assistantCount++;
        } else if (rank.equals(ranks[1])) {
          associateSalaries += salary;
          associateCount++;
        } else if (rank.equals(ranks[2])) {
          fullSalaries += salary;
          fullCount++;
        }
      }

      double assistantAverage = assistantSalaries / assistantCount;
      double associateAverage = associateSalaries / associateCount;
      double fullAverage = fullSalaries / fullCount;
      double allAverage = allSalaries / allCount;

      System.out.printf("Assistant Total: %.2f\n", assistantSalaries);
      System.out.printf("Associate Total: %.2f\n", associateSalaries);
      System.out.printf("Full Total: %.2f\n", fullSalaries);
      System.out.printf("TOTAL: %.2f\n", allSalaries);
      System.out.println();
      System.out.printf("Assistant Average: %.2f\n", assistantAverage);
      System.out.printf("Associate Average: %.2f\n", associateAverage);
      System.out.printf("Full Average: %.2f\n", fullAverage);
      System.out.printf("AVERAGE: %.2f\n", allAverage);
    } catch (Exception e) {
      System.out.println("Unable to form URL or open connection");
      System.exit(1);
    }
  }
}

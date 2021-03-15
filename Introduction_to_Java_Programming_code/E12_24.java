/*
  Create a data file with 1,000 lines. Each line in the file consists of a
  faculty member's first name, last name, rank, and salary. The faculty
  member's first name and last name for the ith line are FirstNamei and
  LastNamei. The rank is randomly generated as assistant, associate, and full.
  The salary is randomly generated as a number with two digits after the
  decimal point. The salary for an assistant professor should be in the range
  from 50,000 to 80,000, for associate professor from 60,000 to 110,000, and
  for full professor from 75,000 to 130,000. Save the file in Salary.txt.
*/

import java.io.File;
import java.io.PrintWriter;

public class E12_24 {
  public static void main(String[] args) throws Exception {
    File file = new File("Salary.txt");

    if (file.exists()) {
      System.out.println("File " + file.getName() + " already exists");
      System.exit(1);
    }

    String[] ranks = {"assistant", "associate", "full"};

    try (
      PrintWriter output = new PrintWriter(file);
    ) {
      for (int i = 1; i <= 1000; i++) {
        int rank = (int)(Math.random() * ranks.length);
        double salary = getSalary(rank);
        output.printf("FirstName%d LastName%d %s %.2f\n",
          i, i, ranks[rank], salary);
      }
    }
  }

  public static double getSalary(int rank) {
    double salary = 0.0;
    switch (rank) {
      case 0: salary = (Math.random() * 30_000) + 50_000; break;
      case 1: salary = (Math.random() * 50_000) + 60_000; break;
      case 2: salary = (Math.random() * 55_000) + 75_000;
    }
    return salary;
  }
}

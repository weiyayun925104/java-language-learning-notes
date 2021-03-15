/*
  Write a program to create a file named E12_15.txt if it does not exist. Write
  100 integers created randomly into the file using text I/O. Integers are
  separated by spaces in the file. Read the data back from the file and display
  the data in increasing order.
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class E12_15 {
  public static void main(String[] args) throws Exception {
    File file = new File("E12_15.txt");

    if (file.exists()) {
      System.out.println("File " + file.getName() + " already exists");
      System.exit(1);
    }

    // write 100 random integers to the file
    try (
      PrintWriter output = new PrintWriter(file);
    ) {
      for (int i = 0; i < 100; i++) {
        int random = (int)(Math.random() * 100);
        output.print(random + " ");
      }
    }

    // read the integers from the file
    ArrayList<Integer> numbers = new ArrayList<>();
    try (
      Scanner input = new Scanner(file);
    ) {
      while (input.hasNext()) {
        numbers.add(input.nextInt());
      }
    }

    // display the integers in increasing order
    Collections.sort(numbers);

    for (int i = 0; i < numbers.size(); i++) {
      if (i % 10 == 0) {
        System.out.println();
      }
      System.out.printf("%2d ", numbers.get(i));
    }
    System.out.println();
  }
}

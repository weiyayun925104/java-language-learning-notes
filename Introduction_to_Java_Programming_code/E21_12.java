/*
  Write a program that prompts the user to enter one of the filenames described
  in Programming Exercise 12.31 and displays the names that are used for both
  genders in the file. Use sets to store names and find common names in two
  sets.
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class E21_12 {
  public static void main(String[] args) throws IOException{
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a file name for baby name ranking: ");
    File file = new File(input.nextLine());
    input.close();

    if (!file.exists()) {
      System.out.println(file.getName() + " does not exist");
      System.exit(1);
    }

    if (!file.isFile()) {
      System.out.println(file.getName() + " is a directory");
      System.exit(2);
    }

    Set<String> boyNames = new HashSet<>();
    Set<String> girlNames = new HashSet<>();

    Scanner fileReader = new Scanner(file);
    while (fileReader.hasNext()) {
      fileReader.next(); // skip unused data
      boyNames.add(fileReader.next());
      fileReader.next(); // skip unused data
      girlNames.add(fileReader.next());
      fileReader.next(); // skip unused data
    }
    fileReader.close();

    boyNames.retainAll(girlNames); // now contains intersectiono of two sets
    System.out.println(boyNames.size() + " names used for both genders");
    for (String name: boyNames) {
      System.out.print(name + " ");
    }
    System.out.println();
  }
}

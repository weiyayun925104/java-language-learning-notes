/*
  Write a test program that stores 5 million integers in a linked list and
  test the time to traverse the list using an iterator vs. using the
  get(index) method.
*/

import java.util.LinkedList;

public class E20_06 {
  public static void main(String[] args) {
    System.out.print("Created linked list of 5,000,000 integers: ");
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 5_000_000; i++) {
      int random = (int)(Math.random() * 5_000_000);
      list.add(random);
    }
    System.out.print("Done");

    System.out.println("\n\nIteration speed using iterator: ");
    // Iterator test
    long startTime = System.currentTimeMillis();
    for (Integer i: list) {}
    stop(startTime);

    System.out.println("\n\nIteration speed using get(index)");
    // get(index) test
    startTime = System.currentTimeMillis();
    for (int i = 0; i < list.size(); i++) {
      list.get(i);
    }
    stop(startTime);
  }

  public static void stop(long startTime) {
    long endTime = System.currentTimeMillis();
    System.out.print(endTime - startTime + "ms");
  }
}

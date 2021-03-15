/*
  Write a program that reads an unspecified number of integers and finds the
  one that has the most occurrences. The input ends when the input is 0.
  For example, if you entered 2 3 40 3 5 4 -3 3 3 2 0, the number 3 occurred
  most often. If not one but several numbers have the most occurrences, all
  of them should be reported. For example, since 9 and 3 appear twice in the
  list 9 30 3 9 3 2 4, both occurrences should be reported.
*/

import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class E21_06 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter integers (0 terminates input): ");
    TreeMap<Integer, Integer> numFrequency = new TreeMap<>();
    while (true) {
      int num = input.nextInt();
      if (num == 0) { break; }
      if (numFrequency.containsKey(num)) {
        numFrequency.replace(num, numFrequency.get(num) + 1);
      } else {
        numFrequency.put(num, 1);
      }
    }

    int max = findMaxValue(numFrequency);

    System.out.println("The most frequent numbers were: ");
    for (Map.Entry<Integer, Integer> e: numFrequency.entrySet()) {
      if (e.getValue() == max) {
        System.out.println(e.getKey());
      }
    }
  }

  public static int findMaxValue(TreeMap<Integer, Integer> map) {
    int max = map.firstEntry().getValue();

    for (Map.Entry<Integer, Integer> e: map.entrySet()) {
      if (e.getValue() > max) { max = e.getValue(); }
    }

    return max;
  }
}

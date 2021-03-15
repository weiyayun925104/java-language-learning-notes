/*
  Create two linked hash sets {"George", "Jim", "John", "Blake", "Kevin",
  "Michael"} and {"George", "Katie", "Kevin", "Michelle", "Ryan"} and find
  their union, difference, and intersection.
*/

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Arrays;

public class E21_01 {
  public static void main(String[] args) {
    String[] names1 = {"George", "Jim", "John", "Blake", "Kevin", "Michael"};
    String[] names2 = {"George", "Katie", "Kevin", "Michelle", "Ryan"};
    Set<String> set1 = new LinkedHashSet<>(Arrays.asList(names1));
    Set<String> set2 = new LinkedHashSet<>(Arrays.asList(names2));

    // Find the union
    set1.addAll(set2);
    System.out.println("Union: " + set1);

    // Find the difference
    set1 = new LinkedHashSet<>(Arrays.asList(names1));
    set1.removeAll(new LinkedHashSet<>(Arrays.asList(names2)));
    set2.removeAll(new LinkedHashSet<>(Arrays.asList(names1)));
    set1.addAll(set2);
    System.out.println("Difference: " + set1);

    // Find the intersection
    set1 = new LinkedHashSet<>(Arrays.asList(names1));
    set2 = new LinkedHashSet<>(Arrays.asList(names2));
    set1.retainAll(set2);
    System.out.println("Intersection: " + set1);
  }
}

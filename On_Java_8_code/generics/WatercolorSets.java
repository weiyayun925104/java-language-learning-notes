

import watercolors.*;
import static watercolors.Watercolors.*;
import java.util.*;

class Sets {
  public static <T> Set<T> union(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<>(a);
    result.addAll(b);
    return result;
  }
  public static <T>
  Set<T> intersection(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<>(a);
    result.retainAll(b);
    return result;
  }
  // Subtract subset from superset:
  public static <T> Set<T>
  difference(Set<T> superset, Set<T> subset) {
    Set<T> result = new HashSet<>(superset);
    result.removeAll(subset);
    return result;
  }
  // Reflexive--everything not in the intersection:
  public static
  <T> Set<T> complement(Set<T> a, Set<T> b) {
    return difference(union(a, b), intersection(a, b));
  }
}

public class WatercolorSets {
  public static void main(String[] args) {
    Set<Watercolors> set1 =
      EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
    Set<Watercolors> set2 =
      EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
    System.out.println("set1: " + set1);
    System.out.println("set2: " + set2);
    System.out.println(
      "union(set1, set2): " + Sets.union(set1, set2));
    Set<Watercolors> subset = Sets.intersection(set1, set2);
    System.out.println(
      "intersection(set1, set2): " + subset);
    System.out.println("difference(set1, subset): " +
      Sets.difference(set1, subset));
    System.out.println("difference(set2, subset): " +
      Sets.difference(set2, subset));
    System.out.println("complement(set1, set2): " +
      Sets.complement(set1, set2));
  }
}

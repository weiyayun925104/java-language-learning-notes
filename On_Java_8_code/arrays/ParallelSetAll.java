// arrays/ParallelSetAll.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;

public class ParallelSetAll {
  static final int SIZE = 30;
  static void intArray() {
    int[] ia = new int[SIZE];
    Arrays.setAll(ia, new Rand.Pint()::get);
    ArrayShow.show(ia);
    Arrays.parallelSetAll(ia, new Rand.Pint()::get);
    ArrayShow.show(ia);
  }
  static void longArray() {
    long[] la = new long[SIZE];
    Arrays.setAll(la, new Rand.Plong()::get);
    ArrayShow.show(la);
    Arrays.parallelSetAll(la, new Rand.Plong()::get);
    ArrayShow.show(la);
  }
  public static void main(String[] args) {
    intArray();
    longArray();
  }
}

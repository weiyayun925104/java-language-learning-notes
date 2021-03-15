/*
  Implement the following method for binary search.

  public static <E extends Comparable<E>> int binarySearch(E[] list, E key)
*/

public class E19_07 {
  public static void main(String[] args) {
    Integer[] list = {-15, 2, 20, 28, 43, 107, 162};
    System.out.println(binarySearch(list, 162));
  }

  public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
    int low = 0;
    int high = list.length - 1;
    int mid = (high + low) / 2;

    while (low <= high) {
      if (list[mid].compareTo(key) > 0) {
        high = mid - 1;
        mid = (high + low) / 2;
      } else if (list[mid].compareTo(key) == 0) {
        return mid;
      } else if (list[mid].compareTo(key) < 0) {
        low = mid + 1;
        mid = (high + low) / 2;
      }
    }

    return -1;
  }
}

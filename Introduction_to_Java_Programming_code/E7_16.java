
import java.util.Arrays;

public class E7_16 {
  public static void main(String[] args) {
    int[] randoms = new int[100_000];
    for (int i = 0; i < randoms.length; i++) {
      randoms[i] = (int)(Math.random() * 100_000_000);
    }

    int key = (int)(Math.random() * 100_000_000);
    
    Arrays.sort(randoms);

    long startTime = System.currentTimeMillis();
    int result = linearSearch(randoms, key);
    long endTime = System.currentTimeMillis();
    System.out.println("linear: " + (endTime - startTime) + "ms");

    startTime = System.currentTimeMillis();
    result = binarySearch(randoms, key);
    endTime = System.currentTimeMillis();
    System.out.println("binary: " + (endTime - startTime) + "ms");
  }

  public static int linearSearch(int[] list, int key) {
    for (int i = 0; i < list.length; i++) {
      if (key == list[i]) {
        return i;
      }
    }
    return -1;
  }

  public static int binarySearch(int[] list, int key) {
    int low = 0;
    int high = list.length -1;

    while (high >= low) {
      int mid = (low + high) / 2;
      if (key < list[mid]) {
        high = mid - 1;
      } else if (key == list[mid]) {
        return mid;
      } else {
        low = mid + 1;
      }
    }

    return -low - 1;
  }
}

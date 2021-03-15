
import java.util.Arrays;

public class E7_13 {
  public static void main(String[] args) {
    System.out.println(getRandom(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
  }

  public static int getRandom(int... numbers) {
    int random;
    int search;
    do {
      random = (int)(Math.random() * 54) + 1;
      search = linearSearch(numbers, random);
    } while (search >= 0);
    return random;
  }

  public static int linearSearch(int[] list, int key) {
    for (int i = 0; i < list.length; i++) {
      if (key == list[i])
        return i;
    }
    return -1;
  }
}

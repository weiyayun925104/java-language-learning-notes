
public class BreakAndContinue {
  public static void main(String[] args) {
    for(int i = 0; i < 100; i++) {        // [1]
      if(i == 74) break; // Out of for loop
      if(i % 9 != 0) continue; // Next iteration
      System.out.print(i + " ");
    }
    System.out.println();
    for(int i : range(100)) {             // [2]
      if(i == 74) break; // Out of for loop
      if(i % 9 != 0) continue; // Next iteration
      System.out.print(i + " ");
    }
    System.out.println();
    int i = 0;
    while(true) {                         // [3]
      i++;
      int j = i * 27;
      if(j == 1269) break; // Out of loop
      if(i % 10 != 0) continue; // Top of loop
      System.out.print(i + " ");
    }
  }
  public static int[] range(int start, int end, int step) {
    if (step <= 0)
      throw new IllegalArgumentException("Step should be greater than 0");
    if (start >= end)
      throw new IllegalArgumentException("Start should be less than End");
    int sz = 1;
    int pos = start + step;
    while (pos < end)
    {
        ++sz;
        pos += step;
    }
    int[] result = new int[sz];
    for(int i = 0; i < sz; i++)
      result[i] = start + (i * step);
    return result;
  }
  public static int[] range(int start, int end) {
    return range(start, end, 1);
  }
  public static int[] range(int n) {
    return range(0, n);
  }

}
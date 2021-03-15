
public class E18_02 {
  public static void main(String[] args) {
    System.out.println(fib(15));
  }

  public static long fib(long index) {
    if (index == 0) // Base case
      return 0;
    else if (index == 1) // Base case
      return 1;
    
    long f0 = 0;
    long f1 = 1;
    long currentFib = 0;
    for (long i = 2; i <= index; i++) {
      currentFib = f0 + f1;
      f0 = f1;
      f1 = currentFib;
    }
    return currentFib;
  }
}

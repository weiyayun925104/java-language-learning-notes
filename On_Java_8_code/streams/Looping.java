


import static java.util.stream.IntStream.*;

class Repeat {
  public static void repeat(int n, Runnable action) {
    range(0, n).forEach(i -> action.run());
  }
}

public class Looping {
  static void hi() { System.out.println("Hi!"); }
  public static void main(String[] args) {
    Repeat.repeat(3, () -> System.out.println("Looping!"));
    Repeat.repeat(2, Looping::hi);
  }
}

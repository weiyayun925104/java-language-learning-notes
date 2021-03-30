
import java.util.*;

interface Operations {
  void execute();
  static void runOps(Operations... ops) {
    for(Operations op : ops)
      op.execute();
  }
  static void show(String msg) {
    System.out.println(msg);
  }
}


public class Machine2 {
  public static void main(String[] args) {
    Arrays.stream(new Operations[] {
      () -> Operations.show("Bing"),
      () -> Operations.show("Crack"),
      () -> Operations.show("Twist"),
      () -> Operations.show("Pop")
    }).forEach(Operations::execute);
  }
}
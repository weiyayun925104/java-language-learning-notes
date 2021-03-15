
import java.util.Scanner;

public class E11_10 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    MyStack s = getStack(input);
    System.out.println(s);
    int size = s.getSize();

    for (int i = 0; i < size; i++) {
      System.out.println(s.pop());
    }
  }

  public static MyStack getStack(Scanner input) {
    System.out.print("Enter five strings: ");
    MyStack s = new MyStack();
    for (int i = 0; i < 5; i++) {
      s.push(input.next());
    }
    return s;
  }
}

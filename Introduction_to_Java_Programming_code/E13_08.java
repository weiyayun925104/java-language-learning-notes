/*
  Rewrite the MyStack class in Listing 11.10 to perform a deep copy of the
  list field.
*/

public class E13_08 {
  public static void main(String[] args) throws CloneNotSupportedException {
    // create a MyStack object with 10 numbers in it
    MyStack a = new MyStack();
    for (int i = 0; i < 10; i++) {
      a.push(i);
    }

    // make a clone of a
    MyStack b = (MyStack)a.clone();

    // pop a few values from b
    for (int i = 0; i < 3; i++) {
      b.pop();
    }

    System.out.println("a " + a);
    System.out.println("b " + b);
  }
}

/*
  Revise the GenericStack class in Listing 19.1 to implement it using an array
  rather than an ArrayList. You should check the array size before adding a new
  element to the stack. If the array is full, create a new array that doubles
  the current array size and copy the elements from the current array to the
  new array.
*/

public class E19_01 {
  public static void main(String[] args) {
    GenericStack<Integer> intStack = new GenericStack<>();
    intStack.push(1);
    intStack.push(2);
    intStack.push(3);
    System.out.println(intStack);

    for (int i = 4; i < 20; i++) {
      intStack.push(i);
    }

    System.out.println(intStack);

    for (int i = 0; i < 10; i++) {
      System.out.println(intStack.pop());
    }

    System.out.println(intStack);
    System.out.println(intStack.isEmpty());
    System.out.println(intStack.getSize());
    System.out.println(intStack.peek());
  }
}

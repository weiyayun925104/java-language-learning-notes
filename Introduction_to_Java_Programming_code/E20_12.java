/*
  Define MyPriorityQueue class that extends PriorityQueue to implement the
  Cloneable interface and implement the clone() method to clone a priority
  queue.
*/

public class E20_12 {
  public static void main(String[] args) {
    MyPriorityQueue<String> m = new MyPriorityQueue<>();
    m.offer("George");
    m.offer("Sam");
    m.offer("Phil");

    MyPriorityQueue<String> clone = (MyPriorityQueue<String>)m.clone();

    System.out.println(m);
    System.out.println(clone);
  }
}

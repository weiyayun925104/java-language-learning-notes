import java.util.PriorityQueue;
import java.util.List;

public class MyPriorityQueue<E> extends PriorityQueue<E> implements Cloneable {
  @Override
  protected Object clone() {
    MyPriorityQueue<E> cloneQueue = new MyPriorityQueue<>();
    for (E o: this) {
      cloneQueue.offer(o);
    }
    return cloneQueue;
  }
}

public class Queue {
  private int[] elements;
  private int size;
  private static final int DEFAULT_SIZE = 8;

  public Queue() {
    elements = new int[DEFAULT_SIZE];
    size = 0;
  }

  public void enqueue(int v) {
    if (size == elements.length) {
      int[] temp = new int[elements.length * 2];
      System.arraycopy(elements, 0, temp, 0, elements.length);
      elements = temp;
    }
    elements[size++] = v;
  }

  public int dequeue() {
    int element = elements[0];
    for (int i = 1; i < getSize(); i++) {
      elements[i - 1] = elements[i];
    }
    size--;
    return element;
  }

  public boolean empty() {
    return size == 0;
  }

  public int getSize() {
    return size;
  }
}

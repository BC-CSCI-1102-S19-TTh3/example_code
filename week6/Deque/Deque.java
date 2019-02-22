public interface Deque<T> {
  void addFront(T item);
  void addTail(T item);
  T removeFront();
  T removeTail();
  T peekFront();
  T peekTail();
  boolean isEmpty();
  int getSize();
  void printDeque();
}

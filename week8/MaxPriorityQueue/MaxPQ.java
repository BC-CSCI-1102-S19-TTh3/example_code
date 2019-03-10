public interface MaxPQ<T extends Comparable<T>> {
  T delMax();
  void insert(T key);
  boolean isEmpty();
  int size();
  String toString();
}

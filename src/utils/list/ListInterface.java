package utils.list;


public interface ListInterface<T> {
    void addItem(T item);
    T getItemFromPos(int index);
    String toString();
    void removeItem(T item);

}

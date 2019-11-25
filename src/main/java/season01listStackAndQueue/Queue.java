package season01listStackAndQueue;



public interface Queue<T> {

    boolean add(T e);

    boolean offer(T e);

    T remove();

    T poll();

    T element();

    T peek();
}

package season01listStackAndQueue;

public interface Queue<T> {

    //添加第一个元素
    boolean add(T e);

    //添加第一个元素
    boolean offer(T e);

    //返回第一个元素,并删除
    T remove();

    //返回第一个元素，并删除
    T poll();

    //返回第一个元素
    T element();

    //返回第一个元素
    T peek();
}

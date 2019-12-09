package season01listStackAndQueue.impl;

import season01listStackAndQueue.Queue;

/**
 * 这是基于LinkedList实现的队列,还有一种基于数组实现的队列叫循环数组
 */
public class MyQueue<T> implements Queue<T> {

    private MyLinkedList<T> list;

    public MyQueue(){
        this.list = new MyLinkedList<>();
    }

    @Override
    public boolean add(T e) {
        return offer(e);
    }

    @Override
    public boolean offer(T e) {
        list.add(0, e);
        return true;
    }

    @Override
    public T remove() {
        return poll();
    }

    @Override
    public T poll() {
        return list.remove(0);
    }

    @Override
    public T element() {
        return peek();
    }

    @Override
    public T peek() {
        return list.get(0);
    }
}

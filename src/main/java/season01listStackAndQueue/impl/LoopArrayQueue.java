package season01listStackAndQueue.impl;

import season01listStackAndQueue.Queue;

/**
 * 使用数组实现的循环队列
 * 循环队列比数组队列的优势是不需要频繁对队首进行删除 f(n)时间复杂度
 * tail 为指针指向最后一个数的下标
 * front 为指向第一个数的下标
 * front == tail 数组为空
 * front == tail + 1 数组满了
 */
public class LoopArrayQueue<T> implements Queue<T> {

    private T[] data;

    private int front;

    private int tail;

    private int size;

    public LoopArrayQueue(int capacity){
        this.data = (T[])new Object[capacity+1];
    }

    public LoopArrayQueue(){
        this(10);
    }

    public boolean isEmpty(){
        return front == tail;
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean add(T e) {
        return offer(e);
    }

    @Override
    public boolean offer(T e) {
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
        return true;
    }

    private void resize(int newCapacity){
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length]; //小心越界，所以要%data.length
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        if(isEmpty()){
            throw new RuntimeException("is empty");
        }
        T ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        //数组缩容
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public T element() {
        return poll();
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("is empty");
        }
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail ; i = (i+1) % data.length) {
            res.append(data[i]);
            if((i + 1) % data.length != tail){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}

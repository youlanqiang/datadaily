package season01listStackAndQueue.impl;

import season01listStackAndQueue.List;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 一种基于数组实现的list
 *
 * @param <T>
 */
public class MyArrayList<T> implements List<T> {


    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(30);
        list.add(20);
        list.add(10);
        list.add(0);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);

    }

    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private T[] array;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    @Override
    public T get(int index) {
        if(index >= size){
            throw new RuntimeException("超出数组部分");
        }
        return array[index];
    }

    @Override
    public T set(int index, T newVal) {
        if(index > array.length){
            throw new RuntimeException("超出数组容量");
        }
        T temp =  this.array[index];
        this.array[index] = newVal;
        return temp;
    }

    @Override
    public void add(int index, T x) {
        if(index == array.length){
            ensureCapacity(array.length * 2 + 1);
        }
        for(int i = size; i > index; i--){
            this.array[i] = this.array[i-1];
        }
        this.array[index] = x;
        size++;
    }

    @Override
    public T remove(int index) {
        if(index < 0 || index >= size){
            throw new RuntimeException("超出数组下标");
        }
        T temp = this.array[index];
        for(int i = index; i < size; i++){
            this.array[i] = this.array[i+1];
        }
        size--;
        return temp;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if(this.array[i].equals(x)){
                return true;
            }
        }
        return false;
    }



    @Override
    public boolean add(T x) {
        add(size, x);
        return true;
    }

    @Override
    public boolean remove(T x) {
        int i = find(x);
        if(i == -1){
            return false;
        }
        remove(i);
        return true;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator{

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public Object next() {
            if(!hasNext()){
                throw new RuntimeException("没有下一个了.");
            }
            return array[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }

    private void ensureCapacity(int capacity){
        if(capacity < size){
            return;
        }
        T[] old = array;
        array = (T[]) new Object[capacity];
        for(int i = 0; i < size; i++){
            array[i] = old[i];
        }
    }


    private int find(T t){
        for (int i = 0; i < size; i++) {
            if(this.array[i].equals(t)){
                return i;
            }
        }
        return -1;
    }
}

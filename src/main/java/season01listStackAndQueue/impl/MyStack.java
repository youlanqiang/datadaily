package season01listStackAndQueue.impl;

import season01listStackAndQueue.Stack;

/**
 * LIFO 后进先出表
 *
 * @param <T>
 */
public class MyStack<T> implements Stack<T> {

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("hello");
        stack.push("word");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private MyLinkedList<T> list;

    public MyStack() {
        this.list = new MyLinkedList<>();
    }

    @Override
    public T push(T item) {
        list.add(item);
        return item;
    }

    @Override
    public T pop() {
        return list.remove(list.size() - 1);
    }

    @Override
    public T peek() {
        return list.get(list.size() - 1);
    }
}

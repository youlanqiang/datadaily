package season01listStackAndQueue.impl;

import season01listStackAndQueue.List;

import java.util.Iterator;

/**
 *  双向链表
 */
public class MyLinkedList<T> implements List<T> {

    private int size;

    /**
     * modCount用于处理在LinkedList中调用Iterator判断是否修改了List
     */
    private int modCount = 0;

    /**
     * 开始节点
     */
    private Node<T> begin;

    /**
     * 结束节点
     */
    private Node<T> end;

    public MyLinkedList(){
        clear();
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public T set(int index, T newVal) {
        Node<T> node = getNode(index);
        T oldValue = node.value;
        node.value = newVal;
        return oldValue;
    }

    @Override
    public boolean add(T x) {
        add(size, x);
        return true;
    }

    @Override
    public void add(int index, T x) {
        addBefore(getNode(index), x);
    }

    @Override
    public T remove(int index) {
        return remove(getNode(index));
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        begin = new Node<>(null, null,null);
        end = new Node<>(begin, null, null);
        begin.next = end;
        size = 0;
        modCount++;
    }

    @Override
    public boolean contains(T x) {
        Node<T> node = begin;
        while(node != null){
            if(node.value.equals(x)){
                return true;
            }
            node = node.next;
        }
        return false;
    }


    @Override
    public boolean remove(T x) {
        Node<T> node = begin;
        while(node != null){
            if(node.value.equals(x)){
                remove(node);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }


    private Node<T> getNode(int index){
        return getNode(index, 0, size);
    }

    private Node<T> getNode(int index, int lower, int upper){
        Node<T> node;
        if(index < lower || index > upper){
            throw new RuntimeException("超界");
        }

        if(index < size/2){
            node = begin;
            for(int i = 0; i < index; i++){
                node = node.next;
            }
        }else{
            node = end;
            for(int i = size; i > index; i--){
                node = node.prev;
            }
        }

        return node;
    }

    /**
     *  在节点p前面追加一个x
     */
    private void addBefore(Node<T> p, T x){
        Node<T> node = new Node<>(p.prev, x, p);
        node.prev.next = node;
        p.prev = node;
        modCount++;
        size++;
    }

    private T remove(Node<T> p){
        p.prev.next = p.next;
        p.next.prev = p.prev;
        modCount++;
        size--;
        return p.value;
    }

    private static class Node<T>{

        public T value;
        public Node<T> prev;
        public Node<T> next;

        public Node(Node<T> prev, T value, Node<T> next){
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

    }

    private class LinkedListIterator implements Iterator<T>{

        /**
         * 当前node节点
         */
        private Node<T> current = begin.next;

        private int expectedModCount = modCount;

        /**
         * 判断是否可以删除该节点
         */
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != end;
        }

        @Override
        public T next() {
            if(modCount != expectedModCount){
                throw new RuntimeException("mod发生变化");
            }
            if(!hasNext()){
                throw new RuntimeException("没有下一个");
            }
            T value = current.value;
            current = current.next;
            okToRemove = true;
            return value;
        }

        @Override
        public void remove() {
            if(modCount != expectedModCount){
                throw new RuntimeException("mod发生变化");
            }
            if(!okToRemove){
                throw new RuntimeException("不能进行删除操作");
            }
            //删除它的上一个，因为使用next时，指针已经指向了下一个
            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }
}

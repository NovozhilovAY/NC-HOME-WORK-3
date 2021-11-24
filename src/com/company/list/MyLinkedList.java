package com.company.list;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {
    private Node<E> first = null;
    private Node<E> last = null;
    private int size = 0;

    public MyLinkedList() {
    }

    @Override
    public void add(E element) {
        if(size == 0) {
            first = last = new Node<>(element);
            size++;
            return;
        }
        if(size == 1) {
            last.next = new Node<>(first, element, null);
            last = last.next;
            last.prev = first;
            first.next = last;
            size++;
            return;
        }
        last.next = new Node<>(last, element, null);
        last = last.next;
        size++;
    }

    @Override
    public void add(int index, E element) {
        validateIndex(index, size + 1);
        if(index == size) {
            add(element);
            return;
        }
        if(index == 0){
            addFirst(element);
            return;
        }
        Node<E> nextNode = getNode(index);
        Node<E> newNode = new Node<>(nextNode.prev, element, nextNode);
        nextNode.prev.next = newNode;
        nextNode.prev = newNode;
        size++;
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.data = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        validateIndex(index, size);
        return getNode(index).data;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        for(Node<E> curr = first; curr != null; index++) {
            if(curr.data.equals(element)){
                return index;
            }
            curr = curr.next;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        validateIndex(index, size);
        Node<E> removedNode = getNode(index);
        if(index == size - 1) {
            removeLast();
            return removedNode.data;
        }
        if(index == 0) {
            removeFirst();
            return removedNode.data;
        }
        removedNode.next.prev = removedNode.prev;
        removedNode.prev.next = removedNode.next;
        E removedData = removedNode.data;
        removedNode = null;
        size--;
        return removedData;
    }

    @Override
    public E set(int index, E element) {
        validateIndex(index, size);
        Node<E> changedNode = getNode(index);
        changedNode.data = element;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if(size == 0) return "[]";
        StringBuilder stringBuilder = new StringBuilder("[");
        for (E element : this) {
            stringBuilder.append(element.toString());
            stringBuilder.append(", ");
        }
        String result = stringBuilder.substring(0, stringBuilder.length() - 2);
        return result + "]";
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for(E value: this) {
            array[i] = value;
            i++;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if(a.length != size) {
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        for(E value : this) {
            a[i] = (T) value;
            i++;
        }
        return a;
    }

    private void addFirst(E element) {
        if(size == 1) {
            first.prev = new Node<>(null, element, first);
            first = first.prev;
            last.prev = first;
            size++;
            return;
        }
        first.prev = new Node<>(null, element, first);
        first = first.prev;
        size++;
    }

    private void removeFirst() {
        if(size == 1){
            clear();
            size--;
            return;
        }
        first = first.next;
        first.prev = null;
        size--;
    }

    private void removeLast() {
        if(size == 1){
            clear();
            size--;
            return;
        }
        last = last.prev;
        last.next = null;
        size--;
    }

    private void validateIndex(int index, int max) {
        if(index < 0 || index >= max)
            throw new IndexOutOfBoundsException("Index out of range");
    }

    private Node<E> getNode(int index) {
        Node<E> current;
        if(index < size - index) {
            current = first;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = last;
            for (int i = size - 1; i > index; i--){
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = new Node<>(null, null, first);
            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                current = current.next;
                return current.data;
            }
        };
    }

    private static class Node<E> {
        Node<E> next;
        Node<E> prev;
        E data;

        public Node(E data) {
            this.data = data;
        }

        public Node(Node<E> prev, E data, Node<E> next) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }
    }
}

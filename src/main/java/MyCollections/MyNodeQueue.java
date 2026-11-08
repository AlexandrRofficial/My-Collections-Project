package MyCollections;

import java.util.NoSuchElementException;

public class MyNodeQueue<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        private E value;
        private Node<E> next;
        private Node<E> previous;

        Node(E value) {
            this.value = value;
        }
    }

    public void add(E value) {
        Node<E> node = new Node(value);

        if (size == 0) {
            first = node;
            last = node;
        } else {
            last.next = node;
            node.previous = last;
            last = node;
        }

        size++;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (size == 0) {
            throw new IllegalArgumentException("MyNodeQueue is empty: " + size);
        }

        return first.value;
    }

    public E poll() {
        if (size == 0) {
            throw new NoSuchElementException("MyNodeQueue is empty: " + size);
        }

        E firstElement = first.value;
        first = first.next;

        if (first == null) {
            last = null;
        } else {
            first.previous = null;
        }

        size--;
        return firstElement;
    }
}

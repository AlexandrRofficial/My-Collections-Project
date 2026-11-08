package MyCollections;

import java.util.Arrays;

public class MyArrayQueue<E> {
    private final static int DEFAULT_CAPACITY = 100;

    private int size;
    private E[] array;

    @SuppressWarnings("unchecked")
    MyArrayQueue() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    MyArrayQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative: " + capacity);
        }

        array = (E[]) new Object[capacity];
        size = 0;
    }

    public void add(E value) {
        array[size++] = value;
    }

    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (size == 0) {
            throw new IllegalArgumentException("MyArrayQueue is empty: " + size);
        }

        return array[0];
    }

    public E poll() {
        if (size == 0) {
            throw new IllegalArgumentException("MyArrayQueue is empty: " + size);
        }

        E firstElement = array[0];

        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;

        return firstElement;
    }
}

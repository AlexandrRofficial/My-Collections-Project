package MyCollections;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayStack<E> {
    private final static int DEFAULT_CAPACITY = 100;

    private int size;
    private E[] array;

    @SuppressWarnings("unchecked")
    public MyArrayStack() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyArrayStack(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative: " + capacity);
        }

        array = (E[]) new Object[capacity];
        size = 0;
    }

    public void push(E value) {
        if (size == array.length) {
            throw new IllegalStateException("Stack is full. Maximum capacity: " + array.length);
        }

        array[size++] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("There is no such index: " + index);
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;
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
            throw new NoSuchElementException("MyArrayStack is empty: " + size);
        }

        return array[size - 1];
    }

    public E pop() {
        if (size == 0) {
            throw new NoSuchElementException("MyArrayStack is empty: " + size);
        }

        E lastElement = array[size - 1];

        array[size - 1] = null;
        size--;

        return lastElement;
    }
}

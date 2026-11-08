package MyCollections;

public class MyArrayList<E> {
    private final static int DEFAULT_CAPACITY = 100;

    private int size;
    private E[] array;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative: " + capacity);
        }

        array = (E[]) new Object[capacity];
        size = 0;
    }

    public void add(E value) {
        if (size >= array.length) {
            resize();
        }

        array[size++] = value;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = array.length * 2;
        E[] newArray = (E[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
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
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }

        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("There is no such index: " + index);
        }

        return array[index];
    }
}

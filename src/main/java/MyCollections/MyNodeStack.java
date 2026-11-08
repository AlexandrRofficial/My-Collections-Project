package MyCollections;

public class MyNodeStack<E> {
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

    public void push(E value) {
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

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("There is no such index: " + index);
        }

        Node<E> current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if (current.previous == null) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current.next == null) {
            current.previous = last;
        } else {
            current.next.previous = current.previous;
        }

        size--;
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
            throw new IllegalArgumentException("MyNodeStack is empty: " + size);
        }

        return last.value;
    }

    public E pop() {
        if (size == 0) {
            throw new IllegalArgumentException("MyNodeStack is empty: " + size);
        }

        E lastElement = last.value;
        last = last.previous;

        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }

        size--;
        return lastElement;
    }
}

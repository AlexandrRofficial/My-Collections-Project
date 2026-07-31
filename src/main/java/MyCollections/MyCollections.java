package MyCollections;

import java.util.*;

public class MyCollections {
    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
        testQueue();
        testStack();
        testHashMap();
    }

    private static void testArrayList() {

        System.out.println("\n==============================");
        System.out.println("      MyArrayList Test");
        System.out.println("==============================");

        MyArrayList list = new MyArrayList();

        list.add("Java");
        list.add("Python");
        list.add("C++");

        System.out.println("First element: " + list.get(0));
        System.out.println("Second element: " + list.get(1));
        System.out.println("Size: " + list.size());

        list.remove(1);

        System.out.println("After remove: " + list.size());

        list.clear();

        System.out.println("After clear: " + list.size());
    }

    private static void testLinkedList() {

        System.out.println("\n==============================");
        System.out.println("      MyLinkedList Test");
        System.out.println("==============================");

        MyLinkedList list = new MyLinkedList();

        list.add("JavaScript");
        list.add("SQL");
        list.add("C");

        System.out.println("First element: " + list.get(0));
        System.out.println("Second element: " + list.get(1));
        System.out.println("Size: " + list.size());

        list.remove(1);

        System.out.println("After remove: " + list.size());

        list.clear();

        System.out.println("After clear: " + list.size());
    }

    private static void testQueue() {

        System.out.println("\n==============================");
        System.out.println("        MyQueue Test");
        System.out.println("==============================");

        MyQueue queue = new MyQueue();

        queue.add("CSS");
        queue.add("HTML");
        queue.add("Scratch");
        queue.add("Go");

        System.out.println("Queue size: " + queue.size());
        System.out.println("First element: " + queue.peek());

        System.out.println("\nRemoving elements:");

        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println("\nQueue size: " + queue.size());
        System.out.println("First element: " + queue.peek());

        queue.clear();

        System.out.println("Queue size: " + queue.size());
    }

    private static void testStack() {

        System.out.println("\n==============================");
        System.out.println("        MyStack Test");
        System.out.println("==============================");

        MyStack stack = new MyStack();

        stack.push("Java");
        stack.push("Python");
        stack.push("C++");
        stack.push("Go");

        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());

        System.out.println("\nRemoving elements:");

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("\nStack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());

        stack.clear();

        System.out.println("Stack size: " + stack.size());
    }

    private static void testHashMap() {

        System.out.println("\n==============================");
        System.out.println("       MyHashMap Test");
        System.out.println("==============================");

        MyHashMap map = new MyHashMap();

        map.put("Java", "Oracle");
        map.put("Python", "Guido van Rossum");
        map.put("C++", "Bjarne Stroustrup");
        map.put("Go", "Google");

        System.out.println("Map size: " + map.size());

        System.out.println("\nSearching:");

        System.out.println("Java -> " + map.get("Java"));
        System.out.println("Python -> " + map.get("Python"));
        System.out.println("Go -> " + map.get("Go"));

        System.out.println("\nUpdating:");

        map.put("Java", "James Gosling");

        System.out.println("Java -> " + map.get("Java"));

        System.out.println("\nRemoving:");

        map.remove("Python");

        System.out.println("Map size: " + map.size());
        System.out.println("Python -> " + map.get("Python"));

        map.clear();

        System.out.println("Map size: " + map.size());
    }
}

class MyArrayList {
    private final static int DEFAULT_CAPACITY = 100;

    private int size;
    private Object[] array;

    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(Object value) {
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;
    }

    public void clear() {
        for(int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        System.out.println("ArrayList is cleared");
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            return "There is no such index " + index;
        }
        return array[index];
    }
}

class MyLinkedList {
    private Node first;
    private Node last;
    private int size;

    private static class Node {
        Object value;
        Node next;
        Node previous;

        Node(Object value) {
            this.value = value;
        }
    }

    public void add(Object value) {
        Node node = new Node(value);
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
            return;
        }

        Node current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if (current.previous == null) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current.next == null) {
            last = current.previous;
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

    public Object get(int index) {
        if (index < 0 || index >= size) {
            return "There is no such index " + index;
        }
        Node current = first;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }
}

class MyQueue {
    private final static int DEFAULT_CAPACITY = 10;

    private Object[] array;
    private int size;

    public MyQueue() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public void add(Object value) {
        array[size] = value;
        size++;
    }

    public void clear() {
        Arrays.fill(array, null);
        System.out.println("Queue is cleared");
        size = 0;
    }

    public int size() {
      return size;
    }

    public Object peek() {
        if (size == 0) {
            return "LinkedList is empty";
        }
        return array[0];
    }

    public Object poll() {
        if (size == 0) {
            return "LinkedList is empty";
        }
        Object firstElement = array[0];
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array[size] = null;
        return firstElement;
    }
}

class MyStack {
    private final static int DEFAULT_CAPACITY = 10;

    private Object[] array;
    private int size;

    public MyStack() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public void push(Object value) {
        if (size == array.length) {
            throw new StackOverflowError("Stack Overflow");
        }
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + ", Size " + size);
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

    public Object peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return array[size - 1];
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        Object result = array[size - 1];
        array[size - 1] = null;
        size--;
        return result;
    }
}

class MyHashMap {
    private Node first;
    private Node last;
    private int size;

    private static class Node {
        Object key;
        Object value;
        Node next;
        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(Object key, Object value) {
        if (size == 0) {
            Node node = new Node(key, value);
            first = node;
            last = node;
            size++;
            return;
        }

        Node current = first;

        while (current != null) {
            if(current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node node = new Node(key, value);
        last.next = node;
        last = node;
        size++;
    }

    public void remove(Object key) {
        Node current = first;
        Node previous = null;

        while(current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    first = first.next;

                    if (first == null) {
                        last = null;
                    }
                } else {
                    previous.next = current.next;

                    if (current == last) {
                        last = previous;
                    }


                }

                size--;
                return;
            }

            previous = current;
            current = current.next;
        }
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        Node current = first;

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }
}

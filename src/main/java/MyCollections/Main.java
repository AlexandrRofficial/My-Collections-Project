package MyCollections;

public class Main {
    private static void testMyArrayList() {
        System.out.println("=== testMyArrayList ===");

        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(0);
        myArrayList.add(1);
        myArrayList.add(2);

        myArrayList.remove(2);

        System.out.println(myArrayList.get(0));

        myArrayList.clear();

        System.out.println(myArrayList.size());

        System.out.println("=======================");
    }

    private static void testMyLinkedList() {
        System.out.println("=== testMyLinkedList ===");

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);

        myLinkedList.remove(2);

        System.out.println(myLinkedList.get(0));

        myLinkedList.clear();

        System.out.println(myLinkedList.size());

        System.out.println("========================");
    }

    private static void testMyArrayQueue() {
        System.out.println("=== testMyArrayQueue ===");

        MyArrayQueue<Integer> myArrayQueue = new MyArrayQueue<>();

        myArrayQueue.add(0);
        myArrayQueue.add(1);
        myArrayQueue.add(2);

        System.out.println(myArrayQueue.peek());

        System.out.println(myArrayQueue.poll());

        myArrayQueue.clear();

        System.out.println(myArrayQueue.size());

        System.out.println("========================");
    }

    private static void testMyNodeQueue() {
        System.out.println("=== testMyNodeQueue ===");

        MyNodeQueue<Integer> myNodeQueue = new MyNodeQueue<>();

        myNodeQueue.add(0);
        myNodeQueue.add(1);
        myNodeQueue.add(2);

        System.out.println(myNodeQueue.peek());

        System.out.println(myNodeQueue.poll());

        myNodeQueue.clear();

        System.out.println(myNodeQueue.size());

        System.out.println("=======================");
    }

    private static void testMyArrayStack() {
        System.out.println("=== testMyArrayStack ===");

        MyArrayStack<Integer> myArrayStack = new MyArrayStack<>();

        myArrayStack.push(0);
        myArrayStack.push(1);
        myArrayStack.push(2);

        myArrayStack.remove(2);

        System.out.println(myArrayStack.peek());

        System.out.println(myArrayStack.pop());

        myArrayStack.clear();

        System.out.println(myArrayStack.size());

        System.out.println("========================");
    }

    private static void testMyNodeStack() {
        System.out.println("=== testMyNodeStack ===");

        MyNodeStack<Integer> myNodeStack = new MyNodeStack<>();

        myNodeStack.push(0);
        myNodeStack.push(1);
        myNodeStack.push(2);

        myNodeStack.remove(2);

        System.out.println(myNodeStack.peek());

        System.out.println(myNodeStack.pop());

        myNodeStack.clear();

        System.out.println(myNodeStack.size());

        System.out.println("=======================");
    }

    private static void testMyHashMap() {
        System.out.println("=== testMyHashMap ===");

        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();

        myHashMap.put("Zero", 0);
        myHashMap.put("First", 1);
        myHashMap.put("Two", 2);

        myHashMap.remove("Two");

        System.out.println(myHashMap.get("Zero"));
        System.out.println(myHashMap.get("First"));

        myHashMap.clear();

        System.out.println(myHashMap.size());

        System.out.println("=====================");
    }

    static void main(String[] args) {
        testMyArrayList();
        testMyLinkedList();
        testMyArrayQueue();
        testMyNodeQueue();
        testMyArrayStack();
        testMyNodeStack();
        testMyHashMap();
    }
}

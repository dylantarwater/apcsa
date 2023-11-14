package LinearStructures;

public class LinkedList<E> {
    private int size = 0;
    private Node<E> head, tail;

    // Default constructor
    public LinkedList() {}

    // Constructor that takes an array of objects
    public LinkedList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            // add(objects[i])
            // It seems like you are missing the actual implementation for adding elements from the array.
        }
    }

    // Add an element to the end of the list
    public void add(E e) {
        add(size, e);
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the size of the list
    public int size() {
        return size;
    }

    // Check if the index is within bounds
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " out of Bounds");
        }
    }

    // Find the index of the first occurrence of the specified element
    public int indexOf(E e) {
        if (size == 0) return -1;

        int index = 0;
        Node<E> current = head;
        do {
            if (current.element == e) {
                return index;
            }
            current = current.next;
            index++;
        } while (current != null);

        return -1;
    }

    // Add an element to the beginning of the list
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail == null) {
            tail = head;
        }
    }

    // Add an element to the end of the list
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    // Add an element at a specific index
    public void add(int index, E e) {
        if (index == 0) addFirst(e);
        else if (index >= size) addLast(e);
        else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }
    }

    // Get the first element in the list
    public E getFirst() {
        if (size == 0) return null;
        return head.element;
    }

    // Get the last element in the list
    public E getLast() {
        if (size == 0) return null;
        return tail.element;
    }

    // Remove the first element in the list
    public E removeFirst() {
        if (size == 0) return null;
        else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) tail = null;
            return temp.element;
        }
    }

    // Remove the last element in the list
    public E removeLast() {
        if (size == 0) return null;
        else if (size == 1) {
            Node<E> temp = head;
            clear();
            return temp.element;
        } else {
            Node<E> current = head;

            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    // Clear the list
    public void clear() {
        size = 0;
        head = tail = null;
    }

    // Node class for creating elements in the linked list
    private static class Node<E> {
        E element;
        Node next;

        // Node constructor
        public Node(E element) {
            this.element = element;
        }
    }

    // Remove an element at a specific index
    public E remove(int index) {
        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }

            Node<E> removedNode = current.next;
            current.next = current.next.next;
            size--;

            return removedNode.element;
        }
    }

    // Get an element at a specific index
    public E get(int index) {
        checkIndex(index);

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.element;
    }

    // Find the index of the last occurrence of the specified element
    public int lastIndexOf(E e) {
        if (size == 0) {
            return -1; // List is empty, so the element is not found.
        }

        int lastIndex = -1; // Initialize to -1 in case the element is not found.
        int index = 0;
        Node<E> current = head;

        do {
            if (current.element.equals(e)) {
                lastIndex = index;
            }
            current = current.next;
            index++;
        } while (current != null);

        return lastIndex;
    }
}

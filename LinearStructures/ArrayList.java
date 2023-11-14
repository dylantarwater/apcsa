package LinearStructures;

import java.lang.Iterable;
import java.util.Iterator;

public class ArrayList<E> implements Iterable<E> {
    // Initial capacity for the array
    private static final int INITIAL_CAPACITY = 10;

    // Current size of the array
    private int size = 0;

    // Array to store elements
    @SuppressWarnings("unchecked")
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];

    // Default constructor
    public ArrayList() { }

    // Constructor to initialize the ArrayList with an array of objects
    public ArrayList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    // Ensures that the array has enough capacity
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[]) new Object[size * 2 + 1];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    // Adds an element to the end of the ArrayList
    public void add(E e) {
        add(size, e);
    }

    // Adds an element at a specific index
    private void add(int index, E e) {
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // Returns a string representation of the ArrayList
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder builder = new StringBuilder("[");
        builder.append(data[0]); // Append the first element without a leading comma
        for (int i = 1; i < size; i++) {
            builder.append(", ").append(data[i]); // Append the rest of the elements with a leading comma
        }
        builder.append("]");
        return builder.toString();
    }

    // Checks if the ArrayList is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the size of the ArrayList
    public int size() {
        return size;
    }

    // Checks if the index is within bounds
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        }
    }

    // Clears the ArrayList
    @SuppressWarnings("unchecked")
    public void clear() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // Checks if the ArrayList contains a specific element
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) return true;
        }
        return false;
    }

    // Gets the element at a specific index
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    // Gets the index of the first occurrence of a specific element
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) return i;
        }
        return -1;
    }

    // Removes the element at a specific index and returns it
    public E remove(int index) {
        checkIndex(index);
        E e = data[index];
        for (int j = index; j < size; j++) {
            data[j] = data[j + 1];
        }
        data[size - 1] = null;
        size--;
        return e;
    }

    // Removes the first occurrence of a specific element
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        }
        return false;
    }

    // Sets the element at a specific index to a new value and returns the old value
    public E set(int index, E e) {
        checkIndex(index);
        E old = data[index];
        data[index] = e;
        return old;
    }

    // Trims the capacity of the ArrayList to its current size
    @SuppressWarnings("unchecked")
    public void trimToSize() {
        if (size < data.length) {
            E[] newData = (E[]) (new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    // Returns an iterator for the ArrayList
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    // Iterator class for the ArrayList
    private class ArrayListIterator implements Iterator<E> {
        private int current = 0;

        // Checks if there is a next element in the ArrayList
        public boolean hasNext() {
            return (current < size);
        }

        // Returns the next element in the ArrayList
        public E next() {
            return data[current++];
        }

        // Removes the current element (optional operation)
        public void remove() {
            ArrayList.this.remove(current);
        }
    }
}

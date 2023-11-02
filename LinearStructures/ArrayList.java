package LinearStructures;


public class ArrayList<E> {
    private static final int INITIAL_CAPACITY = 10;

    private int size = 0;

    @SuppressWarnings("unchecked")
    private E[] data = (E[])new Object[INITIAL_CAPACITY];

    public ArrayList() { }

    public ArrayList(E[] objects) {
        for(int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if(size >= data.length) {
            E[] newData = (E[])new Object[size * 2 +1];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    public void add(E e) {
        add(size, e);
    }

    private void add(int index, E e) {
        ensureCapacity();
        for(int i = size - 1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

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
    

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        }
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        data = (E[])new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public boolean contains(E e) {
        for(int i = 0; i <size; i++) {
            if(e.equals(data[i])) return true;
        }
        return false;
    }

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    public int indexOf(E e) {
        for(int i = 0; i < size; i++) {
            if(e.equals(data[i])) return i;
        }
        return -1;
    }

    public E remove(int index) {
        checkIndex(index);
        E e = data[index];
        for(int j = index; j <size; j++) {
            data[j] = data[j+1];
        }
        data[size - 1] = null;
        size--;
        return e;
    }

    public boolean remove(E e) {
        if(indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        }
        return false;
    }

    public E set(int index, E e) {
        checkIndex(index);
        E old = data[index];
        data[index] = e;
        return old;
    }

    @SuppressWarnings("unchecked")
    public void trimToSize() {
        if (size < data.length) {
            E[] newData = (E[])(new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }
}
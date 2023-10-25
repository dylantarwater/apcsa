public class intVector {
    private final static int INITIAL_CAPACITY = 10;
    private int[] arr = new int [INITIAL_CAPACITY];
    private int size = 0;

    public intVector() { }

    public intVector(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException();
        }
        arr = new int[capacity];
    }
    public int size() { return size; }

    private void testBounds(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void resize() {
        if(size > arr.length -1 ) {
            int[] temp = new int[1 + arr.length *2];
        
            for(int i = 0; i < size; i++) {
            temp[i] = arr[i];
            }
            arr = temp;
        }
    }

    public void add(int n) {
        resize();
        arr[size++] = n;
    }

    public int get(int index) {
        testBounds(index);
        return arr[index];
    }

    public void clear() {
        arr = new int[INITIAL_CAPACITY];
        size = 0;
    }
    public void set(int index, int value) {
        testBounds(index);
        arr[index] = value;
    }
    public boolean add(int index, int value) {
        if (index < 0 || index > size) {
            return false;
        }
        
        resize(); 
       
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
    
        arr[index] = value;
        size++;
        return true;
    }
    
    public boolean remove(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                
                for (int j = i; j < size - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[size - 1] = 0; 
                size--; 
                return true; // Value found and removed
            }
        }
        return false; // Value not found
    }
    
    public String toString() {
        if(size == 0) return "[]";
        String t = "[]" + arr[0];
        for(int i = 1; i<size; i++){
            t += ", " + arr[i];
        }
        return t + "]";
    }
}
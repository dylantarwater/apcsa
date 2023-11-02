import LinearStructures.ArrayList;


public class Main {
    public static void main(String[] args) {
        
        ArrayList<String> test = new ArrayList<>();

        // Add elements to the ArrayList
        test.add("Apple");
        test.add("Banana");
        test.add("Cherry");

        // Print the ArrayList
        System.out.println("ArrayList: " + test);

        // Add more elements
        test.add("Date");
        test.add("Fig");

        // Print the ArrayList again
        System.out.println("Updated ArrayList: " + test);
    }
}
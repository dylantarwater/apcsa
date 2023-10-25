

public class Main {
    public static void main(String[] args) {
        try{
            intVector test = new intVector();
            System.out.println("size: " + test.size());
            for(int i=0;i<20;i++) {
                test.add(i*2);
            }
        } catch(IllegalArgumentException ex) {
            System.out.println("you can't do that!!");
        } 
    }
}
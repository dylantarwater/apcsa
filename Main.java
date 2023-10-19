

public class Main {
    public static void main(String[] args) {
        try{
            intVector test = new intVector(-1000);
            System.out.println("size: " + test.size());
            for(int i=0;i<test.size();i++) {

            }
        } catch(IllegalArgumentException ex) {
            System.out.println("you can't do that!!");
        } 
    }
}
//Back-end complete function Template for Java
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        // Your Code Here
        // Take the input from the user using Scanner and store in n
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int i=10;
        while(i>0){
            System.out.print(n*i + " ");
            i--;
        }
    }
}

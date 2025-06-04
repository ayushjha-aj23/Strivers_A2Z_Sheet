
/*
Pattern-15: Reverse Letter Triangle Pattern

ABCDE
ABCD
ABC
AB
A
*/


public class Main
{
	public static void main(String[] args) {
        int n=5;
        for(int i=1; i<=n; i++){
            // A to A+(5-1) -> A to E then 
            // A to A+(5-2) -> A to D
            for(char c='A'; c<='A'+(n-i); c++){
               System.out.print(c);
            }
            System.out.println();
        }
	}
}


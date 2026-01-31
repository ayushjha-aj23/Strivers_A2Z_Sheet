
/*
Pattern-14: Increasing Letter Triangle Pattern

A
AB
ABC
ABCD
ABCDE
*/

public class Main
{
	public static void main(String[] args) {
        int n=5;
        for(int i=1; i<=n; i++){

			// From A to A+i 
            for(char c='A'; c<'A'+i; c++){
               System.out.print(c);
            }
            System.out.println();
        }
	}
}

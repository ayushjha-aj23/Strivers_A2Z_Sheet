
/*
Pattern-5: Inverted Right Pyramid

*****
****
***
**
*
// Decremenr each time i and increment j from 1 to i
*/


public class Main
{
	public static void main(String[] args) {
	int n=5;
        for(int i=n; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
	}
}

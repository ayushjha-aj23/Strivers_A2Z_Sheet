
/*
Pattern - 11: Binary Number Triangle Pattern

1      (1st row -> 1%2=1, So start with 1)
01     (2nd row -> 2%2=0, So start with 0)
101    (3rd row -> 3%2=1, So start with 1)
0101   (4th row -> 4%2=0, So start with 0)
10101  (5th row -> 5%2=1, So start with 1)
*/

// Case 1: 
// If starting row is taken as 1st row then ->
// Every row which is divisible by 2 -> start it with 0 otherwise with 1

// Case 2:
// If starting row is taken as 0th row then -> 
// Every row which is divisible by 2 -> start it with 1 otherwise with 0
public class Main
{
	public static void main(String[] args) {
	    int n=5;
	    int value = 1;
	    for (int i=1; i<=n; i++) {
	        if(i%2==0)
	            value = 0;
	        else
	            value = 1;
	        
	        for(int j=0; j<=i; j++){
	            System.out.print(value);
	            value = 1-value; // Flip between 0 and 1
	        }
	        System.out.println();
	    }

	}
}

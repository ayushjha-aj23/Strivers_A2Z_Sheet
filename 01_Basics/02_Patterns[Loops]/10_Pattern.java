
/*
Pattern - 10: Half Diamond Star Pattern

*
**
***
****
*****
****
***
**
*
*/

// Outer Loop -> 2*n-1 times
// Inner Loop -> star times
// How to find out star for every row -
	// If i is less then or equal to n -> i times (Increase Stars)
	// If i is more than n -> 2*n-i times (Decrease Stars)

public class Main
{
	public static void main(String[] args) {
	int n=5;
	  for (int i = 1; i <=2*n-1; i++) {
	      
	      // If i is less then or equal to 5 then i times 1->5
	      // If i is more than 5 then 10-i times 4->1  
	      int stars = i <= n ? i : 2*n - i;// 1 to 5, then 4 to 1
	      
	      for (int j = 1; j <= stars; j++) {
	          System.out.print("*");
	      }
	      System.out.println();
	    }
	}
}


/*
Pattern 20 - Buttterfly Pattern
*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *

n=5
*/

// Stars | Spaces | Stars
// For Stars -> stars = i <= n ? i : 2*n - i
// For Spaces-> spaces = i<n ? spaces-2:spaces+2;


public class Main
{
	public static void main(String[] args) {
	    
	    int n = 5;
	    int spaces = 2*n-2;
	    
	    for(int i=1; i<=2*n-1; i++){
	         
	       // Find Stars 
	       int stars = i <= n ? i : 2*n - i;// first increase from 1 to 5, then decrease from 4 to 1
	       
			for(int j=1; j<=stars; j++){
	           System.out.print("*");
	       }
	       
	       // Spaces 
	       for(int j=1; j<=spaces;j++){
	           System.out.print(" ");
	       }
	       spaces = i<n ? spaces-2:spaces+2;
	       
	       
	       // Stars 
	       // stars = i <= n ? i : 2*n - i;// 1 to 5, then 4 to 1
	       
	       for(int j=1; j<=stars; j++){
	           System.out.print("*");
	       }
	       
	       System.out.println();
	    }
	}
}

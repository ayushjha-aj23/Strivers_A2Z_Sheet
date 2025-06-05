
/*
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



public class Main
{
	public static void main(String[] args) {
	    
	    int n = 5;
	    int stars_a;
	    int stars_b;
	    int spaces = 2*n-2;
	    
	    for(int i=1; i<=2*n-1; i++){
	       
	         
	       // Stars 
	       //int stars = i <= n ? i : 2*n - i;// 1 to 5, then 4 to 1
	       // OR 
	        if(i<=n)
	        stars_a= i;
	       else 
	        stars_a = 2*n-i;
	       
	       for(int j=1; j<=stars_a; j++){
	           System.out.print("*");
	       }
	       
	       
	       // Spaces 
	       for(int j=1; j<=spaces;j++){
	           System.out.print(" ");
	       }
	       
	       spaces = i<n ? spaces-2:spaces+2;
	       //OR
	       //if(i<n){
	       // spaces-=2;}
	       //else{
	       // spaces+=2;}
	       
	       
	       // Stars 
	       //int stars = i <= n ? i : 2*n - i;// 1 to 5, then 4 to 1
	       // OR 
	       if(i<=n)
	        stars_b= i;
	       else 
	        stars_b = 2*n-i;
	       
	       for(int j=1; j<=stars_b; j++){
	           System.out.print("*");
	       }
	       
	       System.out.println();
	    }
	}
}

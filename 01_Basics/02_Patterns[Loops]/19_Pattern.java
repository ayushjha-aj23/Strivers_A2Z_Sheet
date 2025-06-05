
/*
Pattern-19: Symmetric-Void Pattern

**********
****  ****
***    ***
**      **
*        *
*        *
**      **
***    ***
****  ****
**********

n=5
top and bottom to methods
*/


public class Main
{
	public static void main(String[] args) {
	    int n = 5;
	    top(n);
	    bottom(n);
	}
	
	public static void top(int topN){
        int n=topN;
        int stars_a= n-1;
        int stars_b= n-1;
        int spaces = 0;
        for(int i=0; i<n; i++){
            
            // Stars 
            for(int j=0; j<=stars_a;j++){
                System.out.print("*");
            }
            stars_a--;
            
            // Spaces 
            for(int j=0; j<spaces; j++){
                System.out.print(" ");
            }
            spaces+=2;
            
            // Stars 
            for(int j=0; j<=stars_b;j++){
                System.out.print("*");
            }
            stars_b--;
            
            System.out.println();
        }
	}
	
	
	public static void bottom(int bottomN){
	    int n=bottomN;
        int stars_a= 1;
        int stars_b= 1;
        int spaces = 2*n-2;
        for(int i=0; i<n; i++){
            
            // Stars 
            for(int j=0; j<stars_a;j++){
                System.out.print("*");
            }
            stars_a++;
            
            // Spaces 
            for(int j=0; j<spaces; j++){
                System.out.print(" ");
            }
            spaces-=2;
            
            // Stars 
            for(int j=0; j<stars_b;j++){
                System.out.print("*");
            }
            stars_b++;
            
            System.out.println();
        }
	}
}



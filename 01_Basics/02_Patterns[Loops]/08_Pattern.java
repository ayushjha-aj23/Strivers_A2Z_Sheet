
/*
Pattern - 8: Inverted Star Pyramid

*********
 *******
  *****
   ***
    *
*/

// Space, Star, Space
// 0->4, 9->1, 0->4 (Increase, Decrease, Increase) 

public class Main
{
	public static void main(String[] args) {
	    int n=5;
	    int spaces_a= 0;
	    int spaces_b= 0;
	    int stars = 2*n-1;
	    
        for(int i=0; i<n; i++){
            // Space
            for(int j=0; j<spaces_a; j++){
                System.out.print("a");
            }
            spaces_a++;
                
            // Star
            for(int j=0; j<stars;j++){
                System.out.print("*");
            }
            stars-=2;
                
            // Spaces 
            for(int j=0; j<spaces_b; j++){
                System.out.print("b");
            }
            spaces_b++;
            
            System.out.println();
        }
	}
}

/*
Pattern - 7: Star Pyramid

    *
   ***
  *****
 *******
*********
*/

// Space, Star, Space
// 4->0, 1->9, 4->0 (Decrease, Increase, Decrease)

public class Main
{
	public static void main(String[] args) {
	int n=5;  
	    int spaces_a= n-1;
	    int spaces_b= n-1;
	    int stars = 1;
	    
        for(int i=0; i<n; i++){
            // Spaces
            for(int j=1; j<=spaces_a; j++){
                System.out.print("a");
            }
            spaces_a--;
            
            // Star
            for(int j=1; j<=stars;j++){
                System.out.print("*");
            }
            stars+=2;
                
            // Spaces 
            for(int j=1; j<=spaces_b; j++){
                System.out.print("b");
            }
            spaces_b--;
            System.out.println();
        }
}
}

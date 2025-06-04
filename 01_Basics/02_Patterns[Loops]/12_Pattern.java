
/*
Pattern - 12: Number Crown Pattern

1      1
12    21
123  321
12344321
*/

public class Main
{
  // Number, Space, Number
  public static void main(String[] args) {
		
		int n = 5;
		// Outer Loop 
		for(int i=1; i<=n; i++){
		    
		    // Number 
		    for(int j=1; j<=i; j++){
		        System.out.print(j);
		    }
		    
		    // Spaces
		    for(int j=1; j<=(2*n)-(2*i); j++){
		        System.out.print(" ");
		    }
		    
		    // Number 
		    for(int j=i; j>=1; j--){
		        System.out.print(j);
		    }
		    
		    System.out.println();
		}
	}
}

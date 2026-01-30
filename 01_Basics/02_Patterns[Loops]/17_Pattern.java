
/*
Pattern - 17: Alpha-Hill Pattern
n=5

    A    
   ABA   
  ABCBA  
 ABCDCBA 
ABCDEDCBA

Space, Character, Space
*/

public class Main
{
	public static void main(String[] args) {
        
        int n=5;
        for(int i=0; i<n; i++){
            
            // Spaces 
            for(int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }
            
            // Characters 
            int breakpoint = (2*i+1)/2; // breakpoint is the half length i.e. (2*i+1)/2 of the total length of j (2*i+1)
			// So if j is in 1st half c++ (Increase the characters) else if j is in next half c-- (Decrease the characters)
            char c = 'A';
            for(int j=1; j<=2*i+1;j++){
                System.out.print(c);
                
                if(j<=breakpoint) 
                    c++;
                else 
                    c--;
            }
            
            // Spaces 
            for(int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }
            
            System.out.println();
        }
	}
}

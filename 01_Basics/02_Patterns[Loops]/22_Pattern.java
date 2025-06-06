
/*
Pattern - 22: The Number Pattern

3 3 3 3 3 
3 2 2 2 3
3 2 1 2 3 
3 2 2 2 3
3 3 3 3 3
*/


public class Main
{
	public static void main(String[] args) {
	    
	    int n = 3;
	    for(int i=0; i<2*n; i++){
	        for(int j=0; j<2*n; j++){
	            
	            int top = i;
	            int left = j;	   
	            int bottom = (2*n-1)-i;
	            int right = (2*n-1)-j;
	            
	            System.out.print(n-Math.min(Math.min(top, bottom), Math.min(right, left)));
	        } 
	        System.out.println();
	    }
	}
}

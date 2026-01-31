
/*
Pattern - 22: The Number Pattern

3 3 3 3 3 
3 2 2 2 3
3 2 1 2 3 
3 2 2 2 3
3 3 3 3 3

// Converting the matrix to new matrix by n-value on each element
// n-value = newElement

0 0 0 0 0 
0 1 1 1 0
0 1 2 1 0
0 1 1 1 0 
0 0 0 0 0

Now if we are able to generate this matrix then making the initial matrix is easy by doing -> n-newElement

And for making this new matrix we can find the top, left, right, and bottom distance of each element and taking the minimum of them 
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

				// Math.min( min(top, bottom), min(left, right) )
	            System.out.print(n-Math.min(Math.min(top, bottom), Math.min(right, left)));
	        } 
	        System.out.println();
	    }
	}
}

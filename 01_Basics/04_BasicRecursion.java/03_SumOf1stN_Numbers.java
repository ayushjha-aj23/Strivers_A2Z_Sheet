// Find the sum of 1st n terms
public class Main
{
	public static void main(String[] args) {
        recursionSum(3, 0); // sum till given num and initial sum as 0
	}
	
	public static void recursionSum(int i, int sum){
	   // Base Case:
	   if(i<1){
	    System.out.println(sum);
	    return;
	   }
	   
	   // Call Itself
	   recursionSum(i-1, sum+i);
	}
}




// Find the sum of cubes of 1st n terms

// User function Template for Java
/*
class Solution {
    int sumOfSeries(int n) {
        // code here
        return sumOfCubesTillN(n);
    }
    
    
    int sumOfCubesTillN(int N){
        int cubesSum = 0;
        // Base Case
        if(N==0)
            return cubesSum;
         
        cubesSum = N*N*N + sumOfCubesTillN(N-1);
        return cubesSum;
    }
}
*/

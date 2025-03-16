
// User function Template for Java
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

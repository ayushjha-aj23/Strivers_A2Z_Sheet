class Solution {
    public int fib(int n) {
        return findFibonacci(n);
    }

    public int findFibonacci(int n){

        if(n==0)
            return 0;
        
        if(n==1)
            return 1;
        
        // int last = findFibonacci(n-1);
        // int secondLast = findFibonacci(n-2);
        // return last + secondLast;
        // OR
        return findFibonacci(n-1) + findFibonacci(n-2);
    }

    
// For Loop - Better way in terms of Runtime
/*    
    public int fib(int n) {
        
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        
        int[] fibonacci = new int[n+1];
        int result = 0;
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        if(n>1){
            for(int i=2; i<=n; i++){
                fibonacci[i] = fibonacci[i-1]+fibonacci[i-2]; 
                result = fibonacci[i];
            }
            return result;
        }
        return result;
    }
    */
}

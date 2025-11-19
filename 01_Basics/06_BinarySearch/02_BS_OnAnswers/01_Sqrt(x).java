
class Solution { 
  // Using Math Function 
  // public int mySqrt(int x) { 
  //     return (int) Math.sqrt(x); 
  // } 
  
  // Binary Search 
  public int mySqrt(int x) { 
    // If x==0 
    if(x==0) return 0; 
    
    int low = 1; 
    int high = x; 
    int result = 1; 
    
    while(low<=high){ 
      int mid = low + (high-low)/2; 
      // If square of mid>x then any number from mid till x can't be our result, so decrease high to mid-1 
      long sq = (long) mid*mid; 
      if(sq>x){ 
        high=mid-1; 
      }else{ // If less or equals to mid then, 1st update result with mid and then increase low with mid+1 
        result = mid; 
        low = mid+1; 
      } 
    } 
    return result; 
  } 
}


class Solution { 
  // int n = 3; 
  // int m = 8; 
  
  // Binary Search public int mySqrt(int n, int m) 
  { 
    //            x^n = m 
    // Output - 2(2^3 = 8) 
    
    if(m==0) return 0; 
    if(n==1) return m; 
    
    int low = 1; 
    int high = m; 
    int result = -1; 
    
    while(low<=high){ 
      int mid = low + (high-low)/2; 
      long nthSq = 1; 
      for(int i=0; i<n; i++){ 
        nthSq = nthSq*mid; 
        if (nthSq > m) break;   // optimization + prevent overflow 
      } 
      if(nthSq==m){ 
        return mid; // Found exact integer root 
      }else if(nthSq>m){ 
        high = mid-1; // Too large → search left 
      }else{ 
        low = mid+1; // Too small → search right 
      } 
    } 
    return -1;   // No integer nth root exists 
  } 
}

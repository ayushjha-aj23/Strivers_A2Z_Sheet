
// GFG

class Solution {
    
    // min (max number of pages)
    
    
    // low- is -> max num of pages (lowest answer is max number of pages)
    // high-is -> sum of all pages (highest answer is sum of all pages if stud = 1)
    
    // Naive Approach - Linear Scan
    // TC-O(sum-max+1)+O(n) and SC- O()
    /*
    public int findPages(int[] arr, int k) {
        // code here
        
        int n = arr.length;
        int max = 0;
        int sumOfAll = 0;
        
        // if books are less then students then return -1
        if(n<k)
            return -1;
            
        // For finding max and sum of all the pages
        for (int x : arr) {
            max = Math.max(max, x);
            sumOfAll += x;
        }
        
        for(int pages=max; pages<=sumOfAll; pages++){
            
            int countStudent = cntStudent(arr, pages);
            
            if(countStudent<=k)
                return pages;
        }
        
        return -1;
    }
    
    
    private int cntStudent(int[] arr, int pages){
        
        int n = arr.length;
        int students = 1;
        int pagesPerStudent = 0;
        
        for(int i=0; i<n; i++){
            if(pagesPerStudent+arr[i]<=pages){ // add on pages to the same student
                pagesPerStudent += arr[i];
            }else{ // if not able to hold i.e. exceeds then increase student and update pagesPerStudent by current pages
                students++; 
                pagesPerStudent = arr[i]; 
            }
        }
        
        return students;
    }
    */
    
    
    // optimised approach - 
    public int findPages(int[] arr, int k) {
        // code here
        
        int max = Integer.MIN_VALUE;
        int sumOfAll = 0;
        int n = arr.length;
        
        // For finding max and sum of all the pages
        for (int x : arr) {
            max = Math.max(max, x);
            sumOfAll += x;
        }
        
        if(n<k)
            return -1;
        
        int low = max;
        int high = sumOfAll;
        int result = -1;

        while(low<=high){
            int mid = low+(high-low)/2;
            
            int countStudent = cntStudent(arr, mid);
            
            
            if(countStudent<=k){
                result = mid;
                high = mid-1;
            }
            else if(countStudent>k)
                low = mid+1;
        }
        
        return result;
        
    }
    
    private int cntStudent(int[] arr, int pages){
        
        int n = arr.length;
        int students = 1;
        int pagesPerStudent = 0;
        
        for(int i=0; i<n; i++){
            if(pagesPerStudent+arr[i]<=pages){ // add on pages to the same student
                pagesPerStudent += arr[i];
            }else{ // if not able to hold i.e. exceeds then increase student and update pagesPerStudent by current pages
                students++; 
                pagesPerStudent = arr[i]; 
            }
        }
        
        return students;
    }
    
}

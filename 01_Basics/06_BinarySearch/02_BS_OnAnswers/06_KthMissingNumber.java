
// LC-1539
class Solution {

    // Linear Search - O(n+k)

    // Imp to undestand the missingCount concept
    // missingCount = arr[i] - (i+1) -> It is the missingCount of that index i
    
    /*
    public int findKthPositive(int[] arr, int k) {

        int n = arr.length;
        int missingCount = 0;
        int num = 1; // For all natural numbers
        int i=0;
        while(missingCount<k){
            if( i<n && arr[i]==num){
                i++;
            }else{ // It means an element is missing as at index(i) value should have been i+1 but it is greater 
                missingCount++;
                if(missingCount==k) return num;
            }

            // Increase num by 1
            num++;
        }
        return -1;
    }
    */


    // Optimised Search - O(log n)

    // Here we cannot apply usual binary search -> becuase numbers are missing
    // Here we cannot apply usual BS on Answers -> becuase we don't have seperation of (possible's and !possible's)

    // 1-Find out the 2 nearby indexes between which our missing number will be
    /*
    a. low = 0 and high = n-1
    b. find missing -> missing = arr[i]-(index+1)
    c. if(missing<k) low=mid+1
       else high = mid-1
    */


    // 2-Find the number
    /*
    a. At this time high will be pointing to number which is lesser then our missing number, it must also be having its missing 
    count.
    b. more = k-missing count of high
    e.g. more = 5-3-> 2 more 
    c. arr[high]+more ---> after evaluation
    // return high+1+k or  return low+k
    */
    public int findKthPositive(int[] arr, int k) {
        
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            int missing = arr[mid]-(mid+1);
            if(missing<k)
                low = mid+1;
            else
                high = mid-1;
        }

        // high-> currently pointing to number lesser then missing number -> currently missing count < k
        // low-> currently pointing to number greater then missing number -> currently missing count > k
        

        // return ---> arr[high]+more
        // more = k-missing
        // missing = arr[high]-(high+1)
        // after putting values


        // in terms of value after evaluation -> high+1+k/low+k
        return high+1+k; // or low+k for the number 
    }
}





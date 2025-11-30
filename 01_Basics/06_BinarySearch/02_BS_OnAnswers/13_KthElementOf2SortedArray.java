

// GFG

class Solution {
    
    // 1, 2, 3, 4, 6, 7, 8, 9, 10
    
    // naive - Apply merge sort and then give the desired k as output
    
    // optimised - using same approach as Median of 2 Sorted Array 
    // Instead of dividing array into 2 equal parts we will divide it into -> k and n-k parts
    public int kthElement(int nums1[], int nums2[], int k) {
        // code here
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n=n1+n2;

        if(n1>n2)
            return kthElement(nums2, nums1, k); // always do binary search on smaller array to swap if n1>n2

        int low = Math.max(0, k-n2);
        int high = Math.min(k, n1);

        int left = k; // number of elements on the left half

        while(low<=high){
            int mid1 = low+(high-low)/2; // partition for nums1
            int mid2 = left-mid1; // partition for nums2 or the number of elements needed from the nums2

            // If partition cuts exceed array bounds, use infinities
            int left1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int right1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];
            
            int left2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int right2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];


            // check
            if(left1<=right2 && left2<=right1){
                return Math.max(left1, left2);
            }


            // Eleminate left portion if -> l2>r1 or eliminate right portion if -> l1>r2
            if(left2>right1) low = mid1+1;
            else high = mid1-1;
        }

        return -1; 
    }
}

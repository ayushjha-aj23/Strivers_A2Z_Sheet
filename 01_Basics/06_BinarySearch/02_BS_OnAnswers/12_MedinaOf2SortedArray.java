
// LC-0004

class Solution {

    // Naive Apporach - Use Merge Sort
    // then if size is even then (average of 2 midddle) and if size is odd then (middle) is the median

    // TC-O(m+n) and SC-O(m+n)
    /*
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] mergedArray = mergeSort(nums1, nums2);

        int n = mergedArray.length;
        double median = 0.0;

        if(n%2==0){
            int a = (n/2)-1; // index of 1st middle
            int b = (n/2); // index of 2nd middle

            median = ((mergedArray[a]+mergedArray[b]))/2.0;
            // below is better as above can give overflow
            // median = mergedArray[a] / 2.0 + mergedArray[b] / 2.0; 

            return median;
        }else{
            int idx = n/2;
            
            median = mergedArray[idx]; 
            return median;
        }
    }

    private int[] mergeSort(int[] nums1, int[] nums2){

        int m = nums1.length;
        int n = nums2.length;

        int i= 0;
        int j= 0; // Starting index of 2nd array after 1st is placed so size of 1st i.e. m

        int k = 0;
        int[] temp = new int[m+n];

        while(i<m && j<n){

            if(nums1[i]<nums2[j])
                temp[k++] = nums1[i++];
            else
                temp[k++] = nums2[j++];
        }

        // Left outs of nums1
        while(i<m)
            temp[k++] = nums1[i++];

        // Left outs of nums2
        while(j<n){
            temp[k++] = nums2[j++];
        }

        return temp; // return merged array
    }
    */

    // Better Approach - Same use MergeSort but instead of actually merging both arrays just find out the middle indexes 
    // and elements at middle indexes and if odd-> 1 middle and if even -> average of 2 middles (n/2, (n/2-1)

    // TC-O(m + n) and SC-O(1)
    /*
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] elements = findMiddles(nums1, nums2);

        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;

        // Odd
        if(n%2==1){
            return (double) elements[1]; // as elements[0] = (n/2)-1 and elements[1] = (n/2)
        }else{
            return ((double) elements[0]+elements[1])/2.0;
        }

    }


    private int[] findMiddles(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2; // Total length of the hypothetical merged Array

        int i=0;
        int j=0;

        int count =0;
        int mid1=(n/2)-1;
        int mid2=n/2;

        // Initially
        int midElement1 = -1; 
        int midElement2 = -1;

        while(i<n1 && j<n2){

            if(nums1[i]<nums2[j]){
                if(count==mid1) midElement1=nums1[i];
                if(count==mid2) midElement2=nums1[i];
                
                count++;
                i++;
            }else{
                if(count==mid1) midElement1=nums2[j];
                if(count==mid2) midElement2=nums2[j];
                
                count++;
                j++;
            }
        }


        while(i<n1){
            if(count==mid1) midElement1=nums1[i];
            if(count==mid2) midElement2=nums1[i];
                
            count++;
            i++;
        }

        while(j<n2){
            if(count==mid1) midElement1=nums2[j];
            if(count==mid2) midElement2=nums2[j];
                
            count++;
            j++;
        }


        return new int[] {midElement1, midElement2};
    }
    */


    // Optimised Approach - Using BS Partitions

    // There is only 1 valid sysmmetry of taking x amount of elements from nums1 and y amount of elements from nums2 for
    // making the 1st half of sorted array

    // e.g. nums1 = [1, 3, 4, 7, 10, 12] 
    //      nums2 = [2, 3, 6, 15]
    // total length = 10 so 5 in left half and 5 in right half

    // 1st left sorted half will be having
    // 1-nums1 and 4-nums2 (invalid) -> [1, 2, 3, 6, 15]/[3, 4, 7, 10, 12]
    // 2-nums1 and 3-nums2 (invalid) -> [1, 2, 3, 3, 6]/[4, 7, 10, 12, 15]
    // 3-nums1 and 2-nums2 (valid)   -> [1, 2, 3, 3, 4]/[6, 7, 10, 12, 15] -> Desired Sorted 
    // 4-nums1 and 1-nums2 (invalid) -> [1, 2, 3, 4, 7]/[3, 6, 10, 12, 15]
    // 5-nums1 and 0-nums2 (invalid) -> [1, 3, 4, 7, 10]/[2, 3, 6, 12, 15]


    // To determine which is the valid symmetry we need to criss cross check from between that left ones are smaller then right ones or not


    // For finding the median for even total length
    // find max from left side -> max(left1, left2)
    // find min from right side-> min(right1, right2)
    // median = [max(left1, left2)+min(right1, right2)]/2

    
    // For finding the median for odd total length
    // e.g taking total length of 5 then 
    // if we are dividing 3 in left half and 2 in right half -> max(left1, left2)
    // if we are dividing 2 in left half and 3 in right half -> max(right1, right2)


    // Figure out how many we need from the nums1 in the left half
    // Binary Search Conditions 
    // if l1>r1 -> high = mid-1 and if l2>r1 -> low = mid+1

    // Taking a general formula for determining the number of elements on left half for both case of even and odd is -
    // Formula = (n1+n2+1)/2
    // e.g. if n1=3 and n2=2 then total length is 5(odd) -> (3+2+1)/2=> 3 so 3 elements in left half
    // e.g. if n1=5 and n2=5 then total length is 10(even)->(5+5+1)/2=> 5 so 5 elements in left half

    // TC-O(min(log m, log n)) and SC-O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n=n1+n2;

        if(n1>n2)
            return findMedianSortedArrays(nums2, nums1); // always do binary search on smaller array to swap if n1>n2

        int low = 0;
        int high = n1;

        int left = (n1+n2+1)/2; // number of elements on the left half

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
                // if total length is even
                if(n%2==0){ // 
                    return (Math.max(left1, left2)+Math.min(right1, right2))/2.0;
                }else{
                    return Math.max(left1, left2);
                }
            }


            // Eleminate left portion if -> l2>r1 or eliminate right portion if -> l1>r2
            if(left2>right1) low = mid1+1;
            else high = mid1-1;
        }

        return -1; 
    }
}

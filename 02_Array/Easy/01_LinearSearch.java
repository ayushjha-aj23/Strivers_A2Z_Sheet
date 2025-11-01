// Linear Search in an Array

class Solution {

    // Linear Search 
    // TC - O(N) and SC - O(1)
    static int search(int arr[], int x) {

        // Your code here
        for(int i=0; i<arr.length; i++){
            if(arr[i]==x)
                return i;
        }
        return -1;
    }
}


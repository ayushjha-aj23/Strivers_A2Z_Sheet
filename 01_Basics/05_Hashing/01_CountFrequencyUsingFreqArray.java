class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public List<Integer> frequencyCount(int[] arr) {
        // do modify in the given array
        int n = arr.length;
        int[] resultArray = new int[n];
        
        for(int i=0; i<n; i++){
            // resultArray[arr[i]-1] += 1;
            resultArray[arr[i]-1]++;
        }
        
        List<Integer> resultList = new ArrayList<>();
        
        for(int i : resultArray){
            resultList.add(i);
        }
        
        return resultList;
    }
}

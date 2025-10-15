class Solution {
    
    // Function to count the frequency of all elements from 1 to N in the array.
    // Method: Using HashMap 
    public List<Integer> frequencyCount(int[] arr) {
        
        int n = arr.length;
        
        // Step 1: Use a HashMap to count the frequencies
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        // Populate frequency map with occurrences of each element in arr
        for(int i=0; i<n; i++){
            hashmap.put(arr[i], hashmap.getOrDefault(arr[i], 0)+1);
        }
        
        // Step 2: Create the result array
        int[] resultArray = new int[n];
        
        // Step3: Store the values in the array
        for(int i=1; i<=n; i++){
            resultArray[i-1] = hashmap.getOrDefault(i, 0); //Fill the index i-1 with frequency of i
        }
        
        // Step4: Convert Array to ArrayList and store in it 
        List<Integer> resultList = new ArrayList<>();
        
        for(int i : resultArray){
            resultList.add(i);
        }
        
        // Step 5: Return ArrayList 
        return resultList;
        
    }
}

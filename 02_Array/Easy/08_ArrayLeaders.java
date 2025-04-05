class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        
        
        // Method 1: Naive Nested Loops - TC - O(N2)
        // 1st loop takes all the element 1by1
        // 2nd loop matches every 1st loop element with rest of the elements on the right
        
        /*
        ArrayList<Integer> LeaderList = new ArrayList<>();
        int n = arr.length;
        
        for(int i=0;i<n-1;i++){
            boolean isLeader = true;
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    isLeader = false;
                    break;
                }
            }
            
            if(isLeader){
                LeaderList.add(arr[i]);
            }
        }
        
        // Always add the rightmost element in the list
        LeaderList.add(arr[arr.length-1]);
        
        return LeaderList;
        */
        
        
        // Method 2: We traverse the array from right to left 
        // and keep track of the maximum element found so far. 
        // If the current element is greater than or equal to this maximum, it is a leader.
        
        
        ArrayList<Integer> LeaderList = new ArrayList<>();
        int n = arr.length;
        
        int maxFromRight = arr[n-1];
        LeaderList.add(maxFromRight); //As the last element is always the leader
        
        
        for(int i=n-2;i>=0;i--){
            if(arr[i]>=maxFromRight){ // If the current element is > maxFromRight then
                LeaderList.add(arr[i]); //Add the element to the LeaderList
                maxFromRight = arr[i]; //Update maxFromRight
            }
        }
        
        Collections.reverse(LeaderList);
        return LeaderList;
    }
}


// LC-875

class Solution {

    // Naive - Let speed (K) be 1  as min and maxElement be max and then calculate the total hours and if it is greater then h then check for k=2 and similarly
    // check till k is less then or equal to h
    // TC-O(maxElement)*O(N) SC-O()
    // This will give TLE
    /*
    public int minEatingSpeed(int[] piles, int h) {
        
        int n = piles.length;
        int maxElement = maxElement(piles);

        // Range of Answers is from 1 to max element
        // So Search Space is - [1-max(element)]
        for(int k=1; k<=maxElement; k++){
            
            int totalHours = computeTotalHours(piles, k);
            if(totalHours<=h)
                return k;
        }

        return -1;
    }

    private int maxElement(int[] piles){
        int max = Integer.MIN_VALUE;

        for(int i: piles)
            if(i>max) max = i;

        // System.out.println("Max"+max);

        return max;
    }

    private int computeTotalHours(int[] piles, int k){
        int n = piles.length;
        int totalHours = 0;

        for(int i=0; i<n; i++){
            totalHours += (int) Math.ceil((double) piles[i]/k); // Take double after division and then ceil it and take int
        }

        // System.out.println("TotalHours"+totalHours);

        return totalHours;
    }
    */


    // Optimised - As we have the range of answers so we can use BS and decrease the range 
    // Range having possibles and not possibles
    // low = 1 and high = maxElement

    // Remember in these question 
    //    if low is at not possible it end up at possible -> Return low
    // OR if high is at not possible it end up at possible -> Return high
    public int minEatingSpeed(int[] piles, int h) {
        
        int n = piles.length;
        int maxElement = maxElement(piles);

        int low = 1;
        int high = maxElement;
        long totalHours = 0;

        while(low<=high){

            int mid = low + (high-low)/2;
            totalHours = computeTotalHours(piles, mid);
            if(totalHours<=h){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return low;

    }

    private int maxElement(int[] piles){
        int max = Integer.MIN_VALUE;

        for(int i: piles)
            if(i>max) max = i;
        // System.out.println("Max"+max);
        return max;
    }

    private long computeTotalHours(int[] piles, int k){
        int n = piles.length;
        long totalHours = 0;

        for(int i=0; i<n; i++){
            totalHours += (int) Math.ceil((double) piles[i]/k); // Take double after division and then ceil it and take int
        }
        // System.out.println("TotalHours"+totalHours);
        return totalHours;
    }
}


// LC-1482

class Solution {

    // Naive - Linear Search
    // TC - O(max-min)+O(N)
    // min flower bloomed - min days - min of bloomDays[i]
    // all flower bloomed - max days - miax of bloomDays[i]
    // Range - min value of i and max vale of i
    // TLE
    /*
    public int minDays(int[] bloomDay, int m, int k) {
        
        // 2 Conditions - If flowers are less or if they are not adjacent
        // if flowers are less 
        int n = bloomDay.length;
        int totalFlowersNeeded = m*k;
        if(n<totalFlowersNeeded)
            return -1;

        int min = minElement(bloomDay);
        int max = maxElement(bloomDay);
        for(int x=min; x<=max; x++){
            int possibleDay = findPossibile(bloomDay, n, x, m, k);
            if (possibleDay != -1)
            return possibleDay; // possibleDay -> which is x
        }
        return -1;
    }

    private int findPossibile (int[] bloomDay, int n, int x, int m, int k){
        // Iterate over bloomDay and check - count>totalFlowers and it should be adjacent
        int flowers = 0; // Flower Counter
        int buoquet = 0;
        for(int i=0; i<n;i++){
            if(bloomDay[i]<=x){
                flowers++;
                if(flowers==k){ // no. of flowers is equal to required flowers (k) then 1 bouquet is possible
                    buoquet++;
                    flowers=0;
                }
            }
            else
                flowers = 0;
        }
        if(buoquet>=m) // If buoquets is greater or equal to required buoquets (m) then return min Day(x)
            return x;
        
        return -1;
    }

    private int minElement(int[] bloomDay){
        int min = Integer.MAX_VALUE;
        for(int i: bloomDay)
            if(i<min) min = i;
        //System.out.println("min"+min);
        return min;
    }

    private int maxElement(int[] bloomDay){
        int max = Integer.MIN_VALUE;
        for(int i: bloomDay)
            if(i>max) max = i;
        //System.out.println("max"+max);
        return max;
    }
    */
    

    
    // Optimised Approach - Using Binary Search
    // TC - O(log (max-min))+O(N)
    public int minDays(int[] bloomDay, int m, int k) {
        // Remember two conditions - If flowers are less or if they are not adjacent

        // if flowers are less 
        int n = bloomDay.length;
        long totalFlowersNeeded = (long) m*k;
        if(n<totalFlowersNeeded)
            return -1;

        int low = minElement(bloomDay);
        int high = maxElement(bloomDay);

        while(low<=high){
            int mid = low + (high-low)/2;

            if(findPossibile(bloomDay, n, mid, m, k)!=-1){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }

        return low; 
        // Always remember opposite polarity in Binary Search on Answers
        // if initially low was at not possible -> end up at possible, same for high
        // if initially low was at possible -> end up at not possible, same for high
        
    }

    private int findPossibile (int[] bloomDay, int n, int x, int m, int k){
        // Iterate over bloomDay and check - count>totalFlowers and it should be adjacent
        int flowers = 0; // Flower Counter
        int buoquet = 0;
        for(int i=0; i<n;i++){
            if(bloomDay[i]<=x){
                flowers++;
                if(flowers==k){ // no. of flowers is equal to required flowers (k) then 1 bouquet is possible
                    buoquet++;
                    flowers=0;
                }
            }
            else
                flowers = 0;
        }
        if(buoquet>=m) // If buoquets is greater or equal to required buoquets (m) then return min Day(x)
            return x;
        
        return -1;
        
        // return buoquet>=m; // true if possible and if not then false
    }

    private int minElement(int[] bloomDay){
        int min = Integer.MAX_VALUE;
        for(int i: bloomDay)
            if(i<min) min = i;
        //System.out.println("min"+min);
        return min;
    }

    private int maxElement(int[] bloomDay){
        int max = Integer.MIN_VALUE;
        for(int i: bloomDay)
            if(i>max) max = i;
        //System.out.println("max"+max);
        return max;
    }


}

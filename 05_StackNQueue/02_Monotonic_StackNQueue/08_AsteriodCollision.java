// Asteroid Collision - LC-735, GFG, Striver

class Solution {

  // TC - O(N) and SC - O(N) 
    public int[] asteroidCollision(int[] asteroids) {

        int n = asteroids.length;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        // Stack<Integer> st = new Stack<>(); // Not used as it will give opposite order in array so list is preferred

        // if((asteroids.length==2) && asteroids[0] == (int) Math.abs(asteroids[1]))
        //     return 

        for(int i=0; i<n; i++){
            // If positive directly add it into the list
            if(asteroids[i]>=0)
                list.add(asteroids[i]);
            else{ // If negative
                // If absolute value of top is less than current element - Pop...E.g. - [2, -5] -> remove 2
                // list is not empty, list's top is +ve, list's top element<current element--- remove top
                while( list.size()>0 && list.get(list.size()-1)>=0 && list.get(list.size()-1)<Math.abs(asteroids[i])){
                    list.remove(list.size()-1);
                }

                // If absolute value of top is equal to current element - Pop...E.g. [8, -8] -> remove 8
                // list is not empty, list's top is +ve, list's top element==current element--- remove top and go ahead
                if(list.size()>0 && list.get(list.size()-1)>=0 && list.get(list.size()-1)==Math.abs(asteroids[i])){
                    list.remove(list.size()-1);
                }else if(list.size()==0 || list.get(list.size()-1)<0){ // if list is empty or the current is negative
                    list.add(asteroids[i]); // Add the negative element in the list
                }
            }  
        }

        
        // Convert list to int[] of correct size
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}



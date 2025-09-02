// LC-901, GFG, Striver

// GFG
import java.util.AbstractMap.SimpleEntry;

class Solution {
    
    
    // Naive Approach - Using Nested Loop
    /*
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        
        
        ArrayList<Integer> resultList = new ArrayList<>();
        //Stack<Integer> st = new Stack<>();
        int n = arr.length;
        
        // i moving forward 
        // While j is checking it for previous elements
        for(int i=0; i<n; i++){
            int element = arr[i];
            
            int span = 1;
            for(int j=i-1; j>=0; j--){
                if(arr[j]<=element){
                    span++;
                }
                else{ // If greater than previous element then break out
                    break;
                }
            }
            resultList.add(span);
        }
        return resultList;
    }
    */
    
    // Optimised Approach - Using Stack 
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        
        // AbstractMap.SimpleEntr
        Stack<SimpleEntry<Integer, Integer>> st = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>(); 
        int n = arr.length;
        
        for(int i=0; i<n; i++){
            
            // Logic of Previous Greater Element 
            //Pop all elements less than or equal to current price
            while(!st.isEmpty() && st.peek().getKey()<=arr[i]){
                st.pop();
            }
            
            // Calculate the span 
            // If empty -> Current Index+1
            // Current Index - Previous Greater Element Index through Peek
            int span = st.isEmpty()? i+1:i-st.peek().getValue();
            result.add(span);
            
            // Push the new Element
            st.push(new SimpleEntry<>(arr[i], i));
        }
        
        return result;
    }
}



// LC
// Maximum number of consecutive days(starting from today and going backward) for which the stock price was less than or equal to the price of current day. (Include Current Day)
// [7,2,1,2] -> Today is 2 -> 4 [1,2,2(today)]
// [7,9,1,2] -> Today is 8 -> 3 [1,2,8(today)] 


// Naive Approach 
// TC - (No. of Days) and SC - (Total Number of Next Calls)
/*
class StockSpanner {

    ArrayList<Integer> list = new ArrayList<>();

    public StockSpanner() {
        list.clear();  // Always fresh start with empty list
    }
    
    public int next(int price) {
        list.add(price);

        int span = 1;

        for(int i=list.size()-2; i>=0; i--){
            if(list.get(i)<=price)
                span++;
            else
                break;
        }
        return span;
    }
}
*/


// Optimised Approach 
// TC - O(2N) and SC - O(N)
import java.util.AbstractMap.SimpleEntry;
class StockSpanner {

    ArrayList<Integer> list = new ArrayList<>();
    Stack<SimpleEntry<Integer, Integer>> st = new Stack<>();
    // We can also use Stack<Pair<Integer, Integer>> st = new Stack<>();
    // st.peek().first and st.peek().second
    int index = 0;

    public StockSpanner() {
        st.clear();  // Always fresh start with empty list
        index = 0;
    }
    
    public int next(int price) {
        
        // Logic of Previous Greater Element 
        //Pop all elements less than or equal to current price
        while(!st.isEmpty() && st.peek().getKey()<=price){
            st.pop();
        }
            
        // Calculate the span 
        // If empty -> Current Index+1
        // Current Index - Previous Greater Element Index through Peek
        int span = st.isEmpty()? index+1:index-st.peek().getValue();
            
        // Push the new Element
        st.push(new SimpleEntry<>(price, index));
        index++; // Move to the next index
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

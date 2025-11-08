// GFG - Number of greater elements to the right

//User function Template for Java

class Solution {
  
//  Naive Approach - 
// TC-O(NQ) where Q is No. of Queries 
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
    
    int[] result = new int[queries];
    
    // Iterate over every indices element
    for(int i=0; i<indices.length; i++){
        
        // Extract each index of indices
        int index = indices[i];
        int count = 0;

        // Iterate from next position of the indexth as we have to find the one which are greater then that on the right
        for(int j=index+1; j<arr.length; j++){
            int value = arr[index];
            if(value<arr[j])
                count++;
        }
        
        result[i] = count;
    }
    
    return result;
  }
  
  
  
//   Optimised Approach - TC-O(NlogN) for Merge Sort
//   Create a List<Pair<Integer, Integer>>---[Index Value,Index]
// Find the middle and divide the array using merge sort on the basis of index value 
// Now compare the values -> If any element say A of 1st part is smaller then any element say B of 2nd Part
// Then that element A from 1st Part will be smaller to every element from B till the last in the 2nd Part
// In Other words - all those elements from “b” till last will be the next greater element for “a“
/*
public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
     // code here

    List<Pair<Integer, Integer>> ListOfPair = new ArrayList<>();
    int[] result = new int[N];    // To Stor the result
    
    // Populating the list with array elements and their original indices
    for(int i=0; i<N; i++){
        ListOfPair.add(new Pair<>(arr[i], i));
    }
    
    // Calling the mergeSort function to process the list of pairs
    mergeSort(ListOfPair, result, 0, N-1);
    
    
    // Return results for the indices specified in the query
    int[] queryResults = new int[queries];
    for(int i=0; i<queries; i++){
        queryResults[i] = result[indices[i]]; // Getting the count for each queried index
    }
    
    return queryResults;
  }
// Merge Sort function to sort the array and count Next Greater Elements
public static void mergeSort(List<Pair<Integer, Integer>> ListOfPair, int[] result, int low, int high){
    
    if(low<high){
    
        int mid = low + (high-low)/2;   // Find mid
        
        // Recursively Call itself to break it into small groups or we can say to divide the array
        mergeSort(ListOfPair, result, low, mid);
        mergeSort(ListOfPair, result, mid+1, high);
        
        
        // Now Call the merge function to merge 
        merge(ListOfPair, result, low, mid, high);
    }
  }
  
// Merge function to merge two halves of the array while counting NGE
public static void merge(List<Pair<Integer, Integer>> ListOfPair, int[] result, int low, int mid, int high){
      int n1 = mid-low+1;
      int n2 = high-mid;
      
      // Temporary arrays to store the split arrays
      List<Pair<Integer, Integer>> arr = new ArrayList<>();
      List<Pair<Integer, Integer>> brr = new ArrayList<>();
      
      // Copy elements to temporary arrays
      for(int i=0; i<n1; i++)
        arr.add(ListOfPair.get(low+i));
    
      for(int j=0; j<n2; j++)
        brr.add(ListOfPair.get(mid+1+j));  
      
      
    int i=0;
    int j=0;
    int k=low;
    
    // Merging the two sorted subarrays
    while(i<n1 && j<n2){
        // If any element of A's 1st part is < any element of B's 1st part
        if(arr.get(i).first<brr.get(j).first){
            result[arr.get(i).second] += n2-j; // As all from j till last will also be greater than that element of A's 1st Part
            
            ListOfPair.set(k, arr.get(i)); // Copy element to the merged array
            i++;
        }else{
            ListOfPair.set(k, brr.get(j)); // Copy element to the merged array
            j++;
        }  
        k++; // Always increment k
    }
    
    // Copy remaining elements of arr[]
    while(i<n1){
        ListOfPair.set(k, arr.get(i));
        i++;
        k++;
    }
    
    // Copy remaining elements of brr[]
    while(j<n2){
        ListOfPair.set(k, brr.get(j));
        j++;
        k++;
    }
  }
 
}
*/
       

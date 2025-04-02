class Solution {

    // Method 1: Naive Approach - Use temporary array 
    // Method 2: Using Stack 
    // public void reverseArray(int arr[]) {
    //     // code here
        
    //     Stack<Integer> stack = new Stack<>();
        
    //     for(int i=0; i<arr.length; i++){
    //         stack.push(arr[i]);
    //     }
        
    //     for(int i=0; i<arr.length; i++){
    //         arr[i] = stack.pop();
    //     }
    // }
        
    // Method 3: Use Two Pointer Approach -> In-place
    // It can also be done using recursion as well - by recursively calling a function which replaces first and last element
    public void reverseArray(int arr[]) {    
        int left = 0;
        int right = arr.length-1;
        int temp = 0;
        
        while(left<right){
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Using recursion and 2 pointer left and right - (a, 0, a.length-1)
    // We can also do it with 1 pointer - (a, i, a.length-1-i)
    /*
    public static void main(String[] args) {
	
		int a[] = {1, 2, 4, 6, 9};
		
		reverseArray(a,0,a.length-1);
		
		for(int i=0; i<a.length; i++){
		    System.out.print(a[i] + " ");
		}
	}
	
	public static void reverseArray(int[] a, int l, int r){
	    
	    if(l>=r)
	        return;
	   
	    int temp = a[l];
	    a[l] = a[r];
	    a[r] = temp;
	    
	    reverseArray(a, l+1, r-1);
	}
    */
    
}

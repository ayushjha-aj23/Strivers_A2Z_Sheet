// 4 variations for Monotonic Stack

import java.util.Stack;

public class Main {
	// 4 Methods
	// Next Greater Element (NGE)
	// Next Smaller Element (NSE)
	// Previous Greater Element (PGE)
	// Previous Smaller Element (PSE)
	
	public static int[] NGE(int[] nums, int n) {
		
		int[] result = new int[n];
		Stack<Integer> st = new Stack<>();
		
		// Traverse from right to left
		// Example explanation:
		// [1, 3] -> Stack has 3, since 3 > 1, next greater of 1 is 3.
		// [5, 3] -> Stack has 3, since 5 > 3, pop 3 and push 5.
		for(int i=n-1; i>=0; i--) {
			while(!st.isEmpty() && st.peek()<=nums[i]) { // Remove elements smaller peek
				st.pop();
			}
			
			result[i] = st.isEmpty()? -1:st.peek();
			
			st.push(nums[i]);
		}

		return result;
		
	}
	
	public static int[] NSE(int[] nums, int n) {
		
		int[] result = new int[n];
		Stack<Integer> st = new Stack<>();
		
		// Traverse from right to left
		// [1,3] -> Stack has 3, since 3 > 1, pop 3 and push 1.
		// [5,3] -> Stack has 3, since 3 < 5, next smaller for 5 is 3.
		for(int i=n-1; i>=0; i--) {
			while(!st.isEmpty() && st.peek()>=nums[i]) { // Remove elements greater peek
				st.pop();
			}
			
			result[i] = st.isEmpty()? -1:st.peek();
			
			st.push(nums[i]);
		}
		
		return result;	
	}
	
	public static int[] PGE(int[] nums, int n) {
		
		int[] result = new int[n];
		Stack<Integer> st = new Stack<>();
		
		// Traverse from left to right
		// [1,3] -> Stack has 1, since 3 > 1, pop 1 and push 3.
		// [5,3] -> Stack has 5, since 3 < 5, previous greater of 3 is 5.
		for(int i=0; i<n; i++) {
			while(!st.isEmpty() && st.peek()<=nums[i]) {
				st.pop();
			}
			
			result[i] = st.isEmpty()? -1:st.peek();
			
			st.push(nums[i]);
		}
		
		return result;
	}
	
	public static int[] PSE(int[] nums, int n){
		
		int[] result = new int[n];
		Stack<Integer> st = new Stack<>();

		// Traverse from left to right
		// [1,3] -> Stack has 1, since 3 > 1, previous smaller of 3 is 1.
		// [5,3] -> Stack has 5, since 5 > 3, pop 5 and push 3.
		for(int i=0; i<n; i++) {
			while(!st.isEmpty() && st.peek()>=nums[i]) {
				st.pop();
			}
			
			result[i] = st.isEmpty()? -1:st.peek();
			
			st.push(nums[i]);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {6, 8, 0, 1, 3};
		int n = nums.length;
		
		int[] result_NGE = NGE(nums, n);
		int[] result_NSE = NSE(nums, n);
		int[] result_PGE = PGE(nums, n);
		int[] result_PSE = PSE(nums, n);
		
		System.out.print("Nums:");
		for(int i: nums)
			System.out.print(i+" ");
		
		System.out.println();
		
		System.out.print("NGE:");
		for(int i : result_NGE)
			System.out.print(i+" ");
		
		System.out.println();
		
		System.out.print("NSE:");
		for(int i : result_NSE)
			System.out.print(i+" ");
		
		System.out.println();
		
		System.out.print("PGE:");
		for(int i : result_PGE)
			System.out.print(i+" ");
		
		System.out.println();
		
		System.out.print("PSE:");
		for(int i : result_PSE)
			System.out.print(i+" ");
		
	}

}

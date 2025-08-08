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
		
		// [1,3] -> Stack mae 3 hai then 1 nahi jayega 
		// [5,3] -> Stack mae 3 hai then 5 jayega kyu ki 3 se bada hai
		for(int i=n-1; i>=0; i--) {
			while(!st.isEmpty() && st.peek()<=nums[i]) {
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
		
		// [1,3] -> Stack mae 3 hai then 1 jayega kyu ki 3 se chota hai
		// [5,3] -> Stack mae 3 hai then 5 nahi jayega
		for(int i=n-1; i>=0; i--) {
			while(!st.isEmpty() && st.peek()>=nums[i]) {
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
		
		// [1,3] -> Stack mae 1 hai then 
		// 
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

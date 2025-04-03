// Using recursion and 2 pointer left and right - (a, 0, a.length-1)
// We can also do it with 1 pointer - (a, i, a.length-1-i) and base condition ---> if(i>=a.length-1)
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
}

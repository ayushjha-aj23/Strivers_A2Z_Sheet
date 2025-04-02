public class Main
{
	public static void main(String[] args) {
// 		System.out.println("Hello World");
        
        String str = "11211";
        boolean result = checkPallindrome(0, str.toCharArray());
        System.out.println(result);
	}
	
	public static boolean checkPallindrome(int i, char[] str){
	    int strLength = str.length;
	    
	    if(i>=strLength/2)
	        return true;
	    
	    if(str[i]!=str[strLength-i-1])
	        return false;
	    
	    return checkPallindrome(i+1, str);
	}
}

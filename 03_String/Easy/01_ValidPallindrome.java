class Solution {


    // Method 1: StringBuilder Approach 
    /*
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();

        // Filter the input string
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                str.append(Character.toLowerCase(c));
            }
        }

        // Check if the filtered string is a palindrome
        String filteredStr = str.toString();
        String reversedStr = str.reverse().toString();
        return filteredStr.equals(reversedStr);
    }
    */
    

    // Method 2: Two Pointer Approach
    /*
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer to the previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    */

    // Method 3: Using Recursion check Pallindrome
    public boolean isPalindrome(String s) {
        
        // First convert all to lowercase and remove the non-alphanumeric characters
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        char[] str = s.toCharArray();
        return checkPallindrome(0, str);
    }

    public boolean checkPallindrome(int i, char[] str){

        // Base Case
        if(i>=str.length/2)
            return true;

        if(str[i]!=str[str.length-i-1]) // if 1st and last not equal return false
            return false;
        
        return checkPallindrome(i+1, str);
    }
}

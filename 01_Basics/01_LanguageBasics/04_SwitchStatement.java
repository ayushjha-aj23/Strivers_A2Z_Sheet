// User function Template for Java

class Solution{
    static double switchCase(int choice, List<Double> arr){
        // code here
        
        double result = 0.0;
        switch(choice){
            case 1:
                result = Math.PI*arr.get(0)*arr.get(0);
                break;
            case 2:
                result = arr.get(0)*arr.get(1);
                break;
        }
        return result;
    }
}

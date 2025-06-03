

/*
*
**
***
****
*****
****
***
**
*
*/



public class Main
{
	public static void main(String[] args) {
	    
  for (int i = 1; i <= 9; i++) {
      
      // If i is less then or equal to 5 then i times 1->5
      // If i is more than 5 then 10-i times 4->1  
      int stars = i <= 5 ? i : 10 - i;// 1 to 5, then 4 to 1
      
      for (int j = 1; j <= stars; j++) {
          System.out.print("*");
      }
      System.out.println();
    }
	}
}

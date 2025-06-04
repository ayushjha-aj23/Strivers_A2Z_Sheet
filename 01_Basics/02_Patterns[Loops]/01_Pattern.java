/*
Pattern-1: Rectangular Star Pattern

*****
*****
*****
*****
*****
*/

// Remeber -> Outer Loop for Lines and Inner Loop for Columns
/*
Rules 
1. For the Outer Loop -> Count the number of lines
2. For the Inner Loop -> Focus on the columns and somehow connect to the rows
3. Print them (say *) inside the inner for loop
4. Observe Symmetry (Optional)
*/

public class Main
{
	public static void main(String[] args) {

	int n = 5;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
	}
}

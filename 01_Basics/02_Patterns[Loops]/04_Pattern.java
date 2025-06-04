
/*
Pattern - 4: Right-Angled Number Pyramid - II

1
22
333
4444
55555
// Same as 3 just replace j with i as in this we have to print the outer loop number (Line number) i number of times
*/


public class Main
{
	public static void main(String[] args) {
	int n=5;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
	}
}

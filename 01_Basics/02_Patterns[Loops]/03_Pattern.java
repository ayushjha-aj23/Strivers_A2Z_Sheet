

/*
Pattern - 3: Right-Angled Number Pyramid

1
12
123
1234
12345
// Same as 2 just replace '*' with j in the Sopln
*/

public class Main
{
	public static void main(String[] args) {

	int n=5;
        for(int i=1; i<=5; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
	}
}

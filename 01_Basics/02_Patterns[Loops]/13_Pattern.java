

/*
Pattern - 13: Increasing Number Triangle Pattern

1
2 3
4 5 6
7 8 9 10
11121314 15
*/

// i for line and j for columns which will be i times everytime (Line Number times)
// Take counter and increasing everytime

public class Main
{
	public static void main(String[] args) {
// 		System.out.println("Hello World");

        int n=5;
        int counter = 1;
        for(int i=1; i<=n; i++){
            
            for(int j=1; j<=i; j++){
                System.out.print(counter+++" ");
            }
            
            System.out.println();
        }
	}
}

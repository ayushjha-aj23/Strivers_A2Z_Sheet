

/*
Pattern - 13: Increasing Number Triangle Pattern

1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
*/

// Take value for n i.e. number of rows
// And take a counter initially as 1
// For i -> Iterate the outer loop n times (1->n)
// For j -> Inside it run inner loop i times and print the counter and increase it by 1 every time

public class Main
{
	public static void main(String[] args) {
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


/*
E
DE
CDE
BCDE
ABCDE
*/

// 'A'+n-1 (For E)
// E-i to E


public class Main
{
	public static void main(String[] args) {
        
        int n=5;
        // char c = (char) ('A'+ n-1); // E
        for(int i=0; i<n; i++){
          // E-i to E where [E='A'+n-1]
          for(char c = (char) ('A'+n-1-i); c<=(char) ('A'+n-1); c++){
            System.out.print(c);
          }
            System.out.println();
        }
	}
}

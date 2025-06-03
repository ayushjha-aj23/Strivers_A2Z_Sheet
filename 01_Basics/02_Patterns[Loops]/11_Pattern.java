

/*
1
01
101
0101
10101
*/

// Every row which is divisible by 2 -> start it with 1 otherwise with 0
public class Main
{
	public static void main(String[] args) {
	    int value = 1;
    for (int i=0; i<5; i++) {
        if(i%2==0)
            value = 1;
        else
            value = 0;
        
        for(int j=0; j<=i; j++){
            System.out.print(value);
            value = 1-value; // Flip between 0 and 1
        }
        System.out.println();
    }

	}
}

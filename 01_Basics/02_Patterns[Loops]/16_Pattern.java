
/*
Pattern - 16: Alpha-Ramp Pattern

A
BB
CCC
DDDD
EEEEE
*/

// char c = 'A' and everytime just increase it by 1 i.e. c++

public class Main
{
	public static void main(String[] args) {
        
        int n=5;
        char c = 'A';
        for(int i=0; i<n; i++){
            for(int j=0; j<i+1; j++){
                System.out.print(c);  
            }
            c++;
            System.out.println();
        }
	}
}




/*
aaaa*bbbb
aaa***bbb
aa*****bb
a*******b
*********
*********
a********b
aa*****bb
aaa***bbb
aaaa*bbbb
*/

public class Main
{
	public static void main(String[] args) {
	    printPattern_A();
	    printPattern_B();
	}
	
	public static void printPattern_A(){
	     int spaces_a= 4;
	    int spaces_b= 4;
	    int stars = 1;
	    
        for(int i=0; i<5; i++){
            // Space
            for(int j=1; j<=spaces_a; j++){
                System.out.print("a");
            }
            spaces_a--;
            
            // Star
            for(int j=1; j<=stars;j++){
                System.out.print("*");
            }
            stars+=2;
                
            // Spaces 
            for(int j=1; j<=spaces_b; j++){
                System.out.print("b");
            }
            spaces_b--;
            System.out.println();
        }
	}
	
	public static void printPattern_B(){
	    int spaces_a= 0;
	    int spaces_b= 0;
	    int stars = 9;
	    
        for(int i=0; i<5; i++){
            // Space
            for(int j=0; j<spaces_a; j++){
                System.out.print("a");
            }
            spaces_a++;
            
                
            // Star
            for(int j=1; j<=stars;j++){
                System.out.print("*");
            }
            stars-=2;
                
            // Spaces 
            for(int j=0; j<spaces_b; j++){
                System.out.print("b");
            }
            spaces_b++;
            
            System.out.println();
        }
	}
}

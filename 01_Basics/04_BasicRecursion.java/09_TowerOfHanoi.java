// User function Template for Java
class Solution {

    // Goal is to move all disks from A to C using aux B
    public int towerOfHanoi(int n, int from, int to, int aux) { //A,C,B
        // Your code here
        
        if (n == 1) {
            // System.out.println("Move disk 1 from rod " + from + " to rod " + to);
            return 1; // Only 1 Step
        }
        
        // Step1: Move N-1 disks from A to B using C
        // Step2: Move Nth(Last) disks to C
        // Step3: Move N-1 disks from B to C using A
        
        int step1 =towerOfHanoi(n-1,from,aux,to); //N-1 disks from A to B using C
        // System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
        int step2 =towerOfHanoi(n-1,aux,to,from); //N-1 disks from B to C using A
        return step1+step2+1; // Add 1 for the move of the nth disk from A to C
    }
}

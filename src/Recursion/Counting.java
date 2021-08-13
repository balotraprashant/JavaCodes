package Recursion;


/*
If the Input is 5
Output should be 1,2,3,4,5  or 5,4,3,2,1 (Perform by head recursion or tail recursion)

Head recursion - if the recursive call is not the last thing to do in the function then its called Head recursion.

Tail recursion - if the recursive call is the last thing to do in the function then its called Tail recursion.

Find Time Complexity and Space complexity of the solution.
 */

import java.util.Scanner;

public class Counting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input : ");
        int num = sc.nextInt();

        printCountingByRecursion(num);
    }

    public static void printCountingByRecursion(int n){
        if(n==0) return;

        printCountingByRecursion(n-1);
        System.out.printf("%d ",n);
    }
}

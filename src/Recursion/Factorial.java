package Recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input : ");
        int num = sc.nextInt();

        System.out.println(printFactorialByRecursion(num));
    }

    public static int printFactorialByRecursion(int n){
        if(n==1) return 1;
        return n * printFactorialByRecursion(n-1);
    }
}

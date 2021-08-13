package Recursion;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input : ");
        int num = sc.nextInt();

        System.out.println(nthFibonacciNumberByRecursion(num));
        printFibonacciSeriesUptoN(0,1,num-1);
    }

    public static int nthFibonacciNumberByRecursion(int n) {
        if(n==1 || n==0) {
            return n;
        }

        return nthFibonacciNumberByRecursion(n-1) + nthFibonacciNumberByRecursion(n-2);
    }

    public static void printFibonacciSeriesUptoN(int i, int j, int n) {
        if(i==0 && j==1) System.out.printf("%d %d ",i,j);
        if(n==0) return ;

        int current = i+j;

        System.out.printf("%d ",current);

        i=j;
        j=current;
        n--;

        printFibonacciSeriesUptoN(i, j, n);
    }
}

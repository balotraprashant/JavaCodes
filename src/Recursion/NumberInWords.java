package Recursion;

import java.util.Scanner;

enum numbers{ZERO,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE};

public class NumberInWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input : ");
        int num = sc.nextInt();

        printNumberInWords(num);
    }

    static void printNumberInWords(int n){
        if(n==0) return;
        printNumberInWords(n/10);

        int remainder = n%10;
        System.out.printf("%s ",numbers.values()[remainder]);
    }
}

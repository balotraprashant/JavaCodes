package ArraysSolutions;

import java.util.Scanner;

public class PrintPrimes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);  //it will take input
        int n = s.nextInt();
        int number = 3;
        System.out.print("2" + " ");
        while (n > 1) {
            if (checkPrime(number)) {
                System.out.print(number + " ");
                n--;
            }
            number++;
        }
    }

    public static boolean checkPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

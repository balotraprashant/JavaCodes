package patterns;

public class AsteriskEquilateralTriangle {
    public static void main(String[] args) {
        printAsteriskEquilateralTriangle(10);
    }

    public static void printAsteriskEquilateralTriangle(int n){
        for(int i=0; i<n-1; i++){
            for(int j=0; j<(n*2)-1; j++){
                if(j<n){
                    if(i+j==n-1){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }else{
                    if(j-i==n-1){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
        for(int k=0; k<(n*2)-1; k++){
            if(k%2==0){
                System.out.print("*");
            }else {
                System.out.print(" ");
            }
        }
    }
}

package ArraysSolutions;

public class MaxAndMinOfArray {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,33,2,4,2,1,50,0,100};
        System.out.println(findBySorting(arr));
    }

    static String findBySorting(int[] array){
        int max = array[0];
        int min = array[0];
        for(int i=0; i<array.length; i++){
            max = max>array[i] ? max : array[i];
            min = min<array[i] ? min : array[i];
        }
        return min + " " + max;
    }
}

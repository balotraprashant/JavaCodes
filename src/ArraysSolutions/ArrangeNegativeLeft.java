package ArraysSolutions;

public class ArrangeNegativeLeft {
    public static void main(String args[])
    {
        int arr[] = { -1, 0, -4, -6, -9, 2, -3, 4, 5, 6, -7, 8, 9 };
        int n = arr.length;

        rearrange(arr, n);
        printArray(arr, n);
    }

    public static void rearrange(int[] arr, int n){
        int pivot=0;
        for(int i=0;i<n; i++){
            if(arr[i]<0){
                int temp = arr[pivot];
                arr[pivot] = arr[i];
                arr[i] = temp;
                pivot++;
            }
        }
    }

    public static void printArray(int[] arr, int n){
        for(int i=0;i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}

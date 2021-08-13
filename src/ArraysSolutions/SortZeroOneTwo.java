package ArraysSolutions;

public class SortZeroOneTwo {

    public static void main(String[] args) {
        sort012(new int[]{2,1,0,1,0,2,0},7);
    }

    public static void sort012(int a[], int n)
    {
        int start=0, mid=0, last=n-1;
        int temp;
        while(mid<=last){
            switch(a[mid]){
                case 0:
                    temp=a[start];
                    a[start]=a[mid];
                    a[mid]=temp;
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp=a[last];
                    a[last]=a[mid];
                    a[mid]=temp;
                    last--;
                    break;
            }
        }
        for (int element: a) {
        System.out.print(element);
        }
    }
}

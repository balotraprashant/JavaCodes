package ArraysSolutions;

class KthSmallestElement{
    public static void main(String[] args) {
        int[] myArr = new int[]{1, 23, 12, 9, 30, 2, 50};
        System.out.println(kthSmallest(myArr, 0, myArr.length-1, 3));
    }

    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Your code here
        int smallest = arr[l];
        int[] sortedArr = new int[r+1];

        sortedArr[l] = arr[l];
        sortedArr[l+1] = arr[l+1];

        for(int i=l+1;i<=r;i++){
            if(smallest>arr[i]){
                smallest = arr[i];
                sortedArr = shiftToRight(smallest, sortedArr, 0);
            }else{
                for(int j=0;j<i;j++){
                    if(sortedArr[j]>arr[i]){
                        sortedArr = shiftToRight(smallest, sortedArr, j);
                    }else {
                        sortedArr[i] = arr[i];
                    }
                }
            }
        }
        return sortedArr[k-1];
    }

    static int[] shiftToRight(int element, int[] arr, int index){
        for(int i=arr.length-1; i>index; i--){
            arr[i]=arr[i-1];
        }
        arr[index]=element;
        return arr;
    }
}

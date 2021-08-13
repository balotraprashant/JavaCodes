package ArraysSolutions;

import java.io.*;

public class KadanesAlgorithm {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            SolutionABC obj = new SolutionABC();

            //calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr, n));
        }
    }
}

// } Driver Code Ends


class SolutionABC{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int arr[], int n){

        // Your code here
        int current_sum = arr[0];
        int best_sum = arr[0];
        for(int i=1; i<arr.length; i++){
            current_sum = Math.max(arr[i], current_sum+arr[i]);
            best_sum = Math.max(current_sum, best_sum);
        }
        return best_sum;
    }

}



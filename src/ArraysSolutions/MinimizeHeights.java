package ArraysSolutions;
import java.io.*;
import java.util.*;

public class MinimizeHeights {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int possibleDifference = arr[n-1]-arr[0];

        for(int i=0; i<n-1; i++){
            if(arr[i+1]<k){
                continue;
            }
            int min = Math.min(arr[i+1]-k, arr[0]+k);
            int max = Math.max(arr[i]+k, arr[n-1]-k);
            possibleDifference = Math.min(possibleDifference, max-min);
        }
        return possibleDifference;
    }
}

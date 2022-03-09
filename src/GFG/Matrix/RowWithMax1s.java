package GFG.Matrix;

import java.util.*;
import java.io.*;

public class RowWithMax1s {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int[] rowMaxArr = new int[n];
        int maxOnes = 0;
        int rowIndex = -1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==1){
                    rowMaxArr[i] = m-j;
                    break;
                }
            }
            rowIndex = rowMaxArr[i] > maxOnes ? i: rowIndex;
            maxOnes = Math.max(rowMaxArr[i],maxOnes);
        }
        return rowIndex;

//        Approach 2
//        int maxRowIndex = -1;
//        int r = 0, c = m-1;
//
//        while(r<n && c>=0){
//            if(arr[r][c]==1){
//                maxRowIndex = r;
//                c--;
//            }else{
//                r++;
//            }
//        }
    }
}

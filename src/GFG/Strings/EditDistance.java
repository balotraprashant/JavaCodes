package GFG.Strings;

import java.util.*;
import java.lang.*;
import java.io.*;

//Given two strings s and t. Return the minimum number of operations required to convert s to t.
//        The possible operations are permitted:
//
//        Insert a character at any position of the string.
//        Remove any character from the string.
//        Replace any character from the string with any other character.

class EditDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.recursiveSolution(s, t);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        // Code here
        int m = s.length();
        int n = t.length();

        int dp[][] = new int[m+1][n+1];

        return solution(s , t , m , n , dp);
    }

    static int solution(String s1 , String s2 , int m , int n , int dp[][]){

        for(int i=0 ; i<=m ; i++){
            for(int j=0 ; j<=n ; j++){

                if(i==0)
                    dp[i][j] = j;

                if(j==0)
                    dp[i][j] = i;
            }
        }
        dp[0][0] = 0;

        for(int i=1 ; i<=m ; i++){
            for(int j=1 ; j<=n ; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1] , Math.min(dp[i][j-1] , dp[i-1][j]));
                }
            }
        }
        return dp[m][n];
    }

    int recursiveSolution(String s1, String s2){
        //basecase
        if(s1.length()==0){
            return s2.length(); //we will have to perform insert operation s2.length() times
        }
        //basecase
        if(s2.length()==0){
            return s1.length(); ////we will have to perform delete operation s1.length() times
        }

        if(s1.charAt(0)==s2.charAt(0)){
            return recursiveSolution(s1.substring(1), s2.substring(1));
        }else{
            int opt1 = recursiveSolution(s1.substring(1), s2.substring(1));
            int opt2 = recursiveSolution(s1, s2.substring(1));
            int opt3 = recursiveSolution(s1.substring(1), s2);

            return 1 + Math.max(opt1, Math.max(opt2, opt3));
        }
    }

    static int minDistance(String word1, String word2){
        int memo[][] = new int[word1.length()+1][word2.length()+1];
        int ans = memoization(word1, word2, memo);
        return ans;
    }

    static int memoization(String s1, String s2, int[][] memo){
        //basecase
        if(s1.length()==0){
            return s2.length(); //we will have to perform insert operation s2.length() times
        }
        //basecase
        if(s2.length()==0){
            return s1.length(); ////we will have to perform delete operation s1.length() times
        }

        if(memo[s1.length()][s2.length()]>0){
            return memo[s1.length()][s2.length()];
        }

        if(s1.charAt(0)==s2.charAt(0)){
            memo[s1.length()][s2.length()] = memoization(s1.substring(1), s2.substring(1), memo);
            return memoization(s1.substring(1), s2.substring(1), memo);
        }else{
            int opt1 = memoization(s1.substring(1), s2.substring(1), memo);
            int opt2 = memoization(s1, s2.substring(1), memo);
            int opt3 = memoization(s1.substring(1), s2, memo);

            memo[s1.length()][s2.length()] = 1 + Math.max(opt1, Math.max(opt2, opt3));
            return 1 + Math.max(opt1, Math.max(opt2, opt3));
        }
    }
}

//
//    StringBuilder cur = new StringBuilder(s);
//    StringBuilder tar = new StringBuilder(t);
//    int length = tar.length();
//    int i = 0;
//    int operations = 0;
//        while(length>0 && i<tar.length()){
//
//        if(i< cur.length()-1 && cur.charAt(i)==tar.charAt(i)){
//        length--;
//        i++;
//        continue;
//        }else if(i> cur.length()-1){
//        cur.append(tar.charAt(i));
//        operations+=1;
//        length--;
//        i++;
//        continue;
//        }
//        if(cur.charAt(i)!=tar.charAt(i) && cur.length()==tar.length()){
//        cur.replace(i,i+1,""+tar.charAt(i));
//        operations+=1;
//        length--;
//        i++;
//        continue;
//        }
//        if(cur.charAt(i)!=tar.charAt(i) && cur.length()>tar.length()){
//        cur.deleteCharAt(i);
//        operations+=1;
//        length--;
//        i++;
//        continue;
//        }
//        if(cur.charAt(i)==tar.charAt(i) && cur.length()<tar.length()){
//        cur.insert(i, tar.charAt(i));
//        operations+=1;
//        length--;
//        i++;
//        continue;
//        }
//        length--;
//        i++;
//        }
//
//        return operations;
package FlipkartGFG;

// { Driver Code Starts
//Initial Template for Java
import java.io.*;
        import java.util.*;

class A
{
    private int R,C;
    private int[] B;
    public void init(int _R,int _C,int[] _B)
    {
        R=_R;
        B=_B.clone();
        C=_C;
    }
    public int get(int i,int j)
    {
        assert(0<=i&&i<R&&0<=j&&j<C);
        if(B[i]>=j+1)
            return 0;
        return 1;
    }
}


// } Driver Code Ends
//User function Template for Java

class Solution1{
    private A a;
    Solution1(A a){
        this.a=a;
    }
    // do not edit this function
    // use it to get the value of A[i][j]
    int get(int i,int j){
        return a.get(i,j);
    }
    public int solve(int R,int C){
        // code here
        int max = 0;
        int row = 0;

        for(int i=0; i<R; i++){
            int count = 0;
            int col = C;
            while(col>=0 && get(i,--col)==1){
                count++ ;
            }
            if(count==C){
                return i;
            }
            if(count>max){
                max=count;
                row=i;
            }
        }
        return row;
    }
};

// { Driver Code Starts.
class StrangeMatrixGFG{
    public static void main(String args[]) throws IOException{
        A a=new A();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int R=sc.nextInt();
            int C=sc.nextInt();
            int[] B=new int[R];
            for(int i=0;i<R;i++)
                B[i]=sc.nextInt();
            a.init(R,C,B);
            Solution1 obj=new Solution1(a);
            int answer=obj.solve(R,C);
            System.out.println(answer);
        }
    }
}  // } Driver Code Ends
package FlipkartGFG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

public class TargetSumBST
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if(!currVal.equals("N"))
            {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if(!currVal.equals("N"))
            {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);

            int target = Integer.parseInt(br.readLine().trim());

            Solution T = new Solution();
            System.out.println(T.isPairPresent(root,target));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java


/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution
{
    // root : the root Node of the given BST
    // target : the target sum

    List<Integer> arrList = new ArrayList<Integer>();

    public int isPairPresent(Node root, int target)
    {
        // Write your code here
        nodeTraverse(root);

        Integer[] arr = new Integer[arrList.size()];

        arr = arrList.toArray(arr);

        Arrays.sort(arr);

        int first = 0;
        int last = arr.length-1;
        while(first<last){
            if(arr[first]+arr[last]==target) return 1;
            if((arr[first]+ arr[last]) < target){
                first++;
            }else{
                last--;
            }
        }
        return 0;
    }

    void nodeTraverse(Node root){
        if(root != null){
            arrList.add(root.data);
            nodeTraverse(root.left);
            nodeTraverse(root.right);
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class gfg {

    /**
     * Possible Paths in a Tree
     * HardAccuracy: 81.17%Submissions: 6K+Points: 8
     * Share your experience with the world! Submit your admission, interview, campus or any other experience and reach an audience of millions today!
     *
     * banner
     * Given a weighted tree with n nodes and (n-1) edges. You are given q queries. Each query contains a number x. For each query, find the number of paths in which the maximum edge weight is less than or equal to x.
     *
     * Note: Path from A to B and B to A are considered to be the same.
     *
     * Example 1:
     *
     * Input:
     * n = 3
     * edges {start, end, weight} = {{1, 2, 1}, {2, 3, 4}}
     * q = 1
     * queries[] = {3}
     * Output:
     * 1
     * Explanation:
     * Query 1: Path from 1 to 2
     * Example 2:
     *
     * Input:
     * n = 7
     * edges {start, end, weight} = {{1, 2, 3}, {2, 3, 1}, {2, 4, 9}, {3, 6, 7}, {3, 5, 8}, {5, 7, 4}}
     * q = 3
     * queries[] = {1, 3, 5}
     * Output:
     * 1 3 4
     * Explanation:
     * Query 1: Path from 2 to 3
     * Query 2: Path from 1 to 2, 1 to 3, and 2 to 3
     * Query 3: Path from 1 to 2, 1 to 3, 2 to 3, and 5 to 7
     * Your Task:
     * You don't need to read input or print anything. Complete the function maximumWeight()which takes integers n, list of edges where each edge is given by {start,end,weight}, an integer q and a list of q queries as input parameters and returns a list of integers denoting the number of possible paths for each query.
     *
     * Expected Time Complexity: O(nlogn + qlogn)
     * Expected Auxiliary Space: O(n)
     *
     * Constraints:
     * 2 ≤ n ≤ 104
     * 1 ≤ q ≤ 104
     * 1 ≤ edges[i][0], edges[i][1] ≤ n
     * edges[i][0] != edges[i][1]
     * 0 ≤ edges[i][2] ≤ 105
     * 0 ≤ queries[i] ≤ 105
    * */
    /*

    Sum of nodes on the longest path from root to leaf node
    MediumAccuracy: 52.39%Submissions: 77K+Points: 4
    Maximize your earnings for your published articles in Dev Scripter 2024! Gain recognition & extra compensation while elevating your tech profile.

    banner
    Given a binary tree having n nodes. Find the sum of all nodes on the longest path from root to any leaf node. If two or more paths compete for the longest path, then the path having maximum sum of nodes will be considered.

            Example 1:

    Input:
            4
            /  \
            2   5
            / \   /  \
            7  1 2  3
            /
            6
    Output:
            13
    Explanation:
            4
            /  \
            2   5
            / \   /  \
            7  1 2  3
            /
            6
    The highlighted nodes (4, 2, 1, 6) above are part of the longest root to leaf path having sum = (4 + 2 + 1 + 6) = 13
    Example 2:

    Input:
            1
            /   \
            2    3
            / \    /  \
            4   5 6   7
    Output:
            11
    Explanation:
    Use path 1->3->7, with sum 11.


     */

    public static boolean isAdditiveSequence(String n) {
        StringBuilder sb=new StringBuilder();
        int f=Integer.parseInt(n.substring(0,1)),  s=Integer.parseInt(n.substring(1,2));

        sb.append(f);
        sb.append(s);
        while(!(sb.length() > n.length())){
            int c=f+s;
            f=s;
            s=c;
            sb.append(c);
            if(sb.toString().equals(n)) return true;
        }
        return false;
    }

    /*
    * Kth common ancestor in BST
MediumAccuracy: 61.97%Submissions: 11K+Points: 4
Given a BST with n (n>=2) nodes, find the kth common ancestor of nodes x and y in the given tree. Return -1 if kth ancestor does not exist.

Nodes x and y will always be present in the input of a BST, and x != y.

Example 1:

Input:
Input tree

k = 2, x = 40, y = 60
Output:
30
Explanation:
Their 2nd common ancestor is 30.
Example 2:

Input:
Input tree

k = 2, x = 40, y = 60
Output:
-1
Explanation:
LCA of 40 and 60 is 50, which is root itself. There does not exists 2nd common ancestor in this case.
Your task :
You don't have to read input or print anything. Your task is to complete the function kthCommonAncestor() that takes the root of the tree, k, x and y as input and returns the kth common ancestor of x and y.

Expected Time Complexity: O(Height of the Tree)
Expected Space Complexity: O(Height of the Tree)

Your Task :
1 <= n, k <= 105
1 <= node->data, x, y <= 109
*
* ALGORITHM :
*
Start traversing the tree from the root.
While traversing, compare the values of the current node with the values of nodes x and y.
If the current node's value is greater than both x and y, move to the left subtree.
If the current node's value is less than both x and y, move to the right subtree.
If the current node's value lies between x and y (inclusive), the current node is a common ancestor. Store this node and continue traversal to find other common ancestors.
Keep track of the common ancestors encountered during traversal.
Once both x and y are found in the tree, return the kth common ancestor from the list of common ancestors. If the list doesn't have k elements, return -1.

    *
    * */


    public int kthCommonAncestor(Node root, int k, int x, int y) {
        List<Integer> comAncestors=new ArrayList<>();
        traverseBST(root,x,y,comAncestors);
        return comAncestors.isEmpty()? -1:comAncestors.get(k);
    }

    public void traverseBST(Node root, int x, int y, List<Integer> comAncestors){
        if(root==null) return;
        if(root.data>x && root.data>y) traverseBST(root.left,x,y, comAncestors); //curr data is greater than both x,y then move to left subtree
        if(root.data<x && root.data<y) traverseBST(root.right,x,y, comAncestors); //curr data is lesser than both x,y then move to right subtree
        else {
            comAncestors.add(root.data);
            traverseBST(root.left, x, y, comAncestors);
            traverseBST(root.right, x, y, comAncestors);
        }
    }



}

class Node{
    int data;
    Node left, right;

    public Node(int d){
        data=d;
        left=null;
        right=null;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //DFS pre-order traversal
        //base case for recursion
        if(root == null || root==p || root==q)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right= lowestCommonAncestor(root.right, p, q);

        //if-else condition to check if we found p & q or not 
        if(left==null)
            return right;
        
        else if(right==null)
            return left;
        
        // both left and right are not null(hence we found our result)
        else 
            return root;

    }
}
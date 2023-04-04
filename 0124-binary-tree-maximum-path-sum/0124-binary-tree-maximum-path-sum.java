/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxPathValue=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxPathValue;
    }

    public int maxPathDown(TreeNode root){
        if(root==null)
            return 0;

        //added 0 to eliminate sum paths which are sending negative values
        int leftMax= Math.max(0,maxPathDown(root.left));
        int rightMax=Math.max(0,maxPathDown(root.right));
        maxPathValue=Math.max(maxPathValue,leftMax+rightMax+root.val);

        return Math.max(leftMax,rightMax)+root.val;

    }
}
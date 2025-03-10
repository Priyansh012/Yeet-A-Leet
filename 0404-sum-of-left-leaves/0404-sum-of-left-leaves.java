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
    int sum=0;

    public int sumOfLeftLeaves(TreeNode root) {
        return inOrderDFS(root, false);
    }

    private int inOrderDFS(TreeNode root, boolean isLeftflag){
        if(root==null)
            return sum;

        inOrderDFS(root.left, true);
        if(root.left==null && root.right==null && isLeftflag==true)
            sum+=root.val;
        inOrderDFS(root.right, false);

        return sum;
    }
}
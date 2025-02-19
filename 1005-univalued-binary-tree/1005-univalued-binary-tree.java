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
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        
        int uniValue=root.val;
        return dfs(root, uniValue);
    }
    private boolean dfs(TreeNode node, int uniValue){
        if(node==null)
            return true;
        
        if(node.val!=uniValue)
            return false;
        
        boolean leftSide = dfs(node.left, uniValue);
        boolean rightSide = dfs(node.right, uniValue);

        
        return leftSide && rightSide;
    }
}
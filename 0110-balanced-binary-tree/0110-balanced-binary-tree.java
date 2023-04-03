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
    public boolean isBalanced(TreeNode root) {
        return dfsMaxDepth(root)!=-1;
    }

    public int dfsMaxDepth(TreeNode root){
        if(root==null)
			return 0;
		
		int lh=dfsMaxDepth(root.left);
		int rh=dfsMaxDepth(root.right);
		
        if((Math.abs(lh-rh)>1) || (lh==-1 || rh==-1))
            return -1;
		return 1+Math.max(lh, rh);
    }
}
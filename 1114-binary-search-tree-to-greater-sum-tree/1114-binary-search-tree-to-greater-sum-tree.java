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
    private int sum=0;
    //reverse Inorder traversal (right->root->left)
    public TreeNode bstToGst(TreeNode root) {
        if(root==null)
            return root;
        
        bstToGst(root.right);
        sum+=root.val;
        root.val=sum;
        bstToGst(root.left);

        return root;
    }
}
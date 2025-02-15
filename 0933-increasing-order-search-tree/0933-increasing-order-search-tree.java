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
   private TreeNode newTreePointer; // Track the last inserted node

    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return root;

        TreeNode newTree = new TreeNode();
        newTreePointer = newTree; 
        dfs(root);
        
        return newTree.right; // Return the actual root of the new tree
    }

    // In-order DFS traversal
    private void dfs(TreeNode oldTree) {
        if (oldTree == null)
            return;

        dfs(oldTree.left); // Visit left subtree

        // Process current node
        newTreePointer.right = new TreeNode(oldTree.val); // Insert into new tree
        newTreePointer = newTreePointer.right; // Move pointer forward

        dfs(oldTree.right); // Visit right subtree
    }
}
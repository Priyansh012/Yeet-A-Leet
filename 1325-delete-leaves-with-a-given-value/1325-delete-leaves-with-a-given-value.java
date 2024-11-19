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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return deleteNodes(root, target);
        
    }

    private TreeNode deleteNodes(TreeNode node, int target){
        if(node==null)
            return null;
        
        node.left = deleteNodes(node.left, target);
        node.right = deleteNodes(node.right, target);

        if(node.left==null && node.right==null && node.val==target){
            return null;
        }

        return node;
    }

}
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)
            return 0;
        
        //if the current node's val is greater than the right boundary
        //then move recursively move to its left side
        if(root.val>high)
            return rangeSumBST(root.left, low, high);
        
        //if the current node's val is lesser than the left boundary
        //then move recursively move to its right side
        if(root.val<low)
            return rangeSumBST(root.right, low, high);
        
        //else since both the condition is false
        //then add the current value to the rangeSum
        return root.val+rangeSumBST(root.left, low, high)+rangeSumBST(root.right, low, high);
    }

   
}
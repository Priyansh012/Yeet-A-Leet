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

 //to calculate number of nodes in complete binary tree but with less than O(n) TC
 //Our algo TC is O(log N * log N)
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int lh=getLeftHeight(root);
        int rh=getRightHeight(root);

        //if lh==rh then use 2^height -1 formula to calculate the no. of nodes in a complete binary tree
        if(lh==rh)
            return ((2<<lh) -1);
        
        // else recursively calculate the number of nodes in left and right child till you find complete subtrees
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int getLeftHeight(TreeNode node){
        int count=0;
        while(node.left!=null){
            count++;
            node=node.left;
        }
        return count;
    }

    public int getRightHeight(TreeNode node){
        int count=0;
        while(node.right!=null){
            count++;
            node=node.right;
        }
        return count;
    }
}
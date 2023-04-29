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
        if(root==null)
            return null;

        //move to the right recursively if both the nodes lie on the right of root(i.e. p & q are greater than root in BST)
        if(root.val<p.val && root.val<q.val)
            return lowestCommonAncestor(root.right, p, q);
        
        //move to the LEFT recursively if both the nodes lie on the LEFT of root(i.e. p & q are lesser than root in BST)
        else if(root.val>p.val && root.val>q.val)
            return lowestCommonAncestor(root.left, p, q);
        
        //if p lies on left & q lies on right or vice versa or one of the is root then this current root itself is the least common ancestor(LCA)
        else
            return root;
    }
}
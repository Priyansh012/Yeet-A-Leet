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
 // Post order DFS
class Solution {
    public boolean evaluateTree(TreeNode root) {
        return dfs(root, root.val);
    }

    //left->root->right
    private boolean dfs(TreeNode node, int nodeVal){
        //Leaf Node
        if(node.left==null && node.right==null){
            if(node.val==0)
                return false;
            else
                return true;
        }

        boolean a = dfs(node.left, node.val);
        boolean b = dfs(node.right, node.val);

        if(node.val==2)
            return a | b;
         
        return a & b;
    }
}
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
    Map<Integer, Integer> levelSum = new HashMap();

    public TreeNode replaceValueInTree(TreeNode root) {
        if (root==null)
            return root;
        
        root.val=0;
        dfs(root, 0);
        dfsReplaceValues(root, 0, 0);
        return root;
    }

    private void dfs(TreeNode node, int level){
       if (node == null) return;

        levelSum.put(level, levelSum.getOrDefault(level, 0) + node.val);

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    private void dfsReplaceValues(TreeNode node, int level, int siblingSum){
        if (node == null) return;

        node.val = levelSum.get(level) - siblingSum;

        // Compute sum of current node's children
        int childSum = 0;
        if (node.left != null)
            childSum += node.left.val;
        if (node.right != null)
            childSum += node.right.val;

        dfsReplaceValues(node.left, level + 1, childSum);
        dfsReplaceValues(node.right, level + 1, childSum);
    }
}
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
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sum;
    }

    private void dfs(TreeNode root, StringBuilder sb){
        if (root == null)
            return;
        
        sb.append(root.val);
        if(root.left==null && root.right==null){
            int num=Integer.parseInt(sb.toString(), 2);
            sum+=num;
        }
        else{
            dfs(root.left, sb);
            dfs(root.right, sb);
        }
        
        sb.setLength(sb.length()-1);
    }
}
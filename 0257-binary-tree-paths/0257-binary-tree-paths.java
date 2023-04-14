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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root==null)
            return result;
        StringBuilder sb = new StringBuilder();
        pathFinder(root, result, sb);
        return result;
    }

    public void pathFinder(TreeNode node, List<String> result, StringBuilder sb){
        if(node==null)
            return;

        int len=sb.length();
        sb.append(node.val);
        if(node.left==null && node.right==null)
            result.add(sb.toString());
        else{
            sb.append("->");
            pathFinder(node.left, result, sb);
            pathFinder(node.right, result, sb);
        }

        //It is an essential step to backtrack (undo the paths added while "climbing" back up)
        sb.setLength(len);
    }
}
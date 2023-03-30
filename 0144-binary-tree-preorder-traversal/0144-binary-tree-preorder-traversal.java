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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> preOrderList = new ArrayList<Integer>();
        preOrder(root, preOrderList);
        return preOrderList; 
    }

    public void preOrder(TreeNode root, ArrayList<Integer> preOrderList){
        if(root == null)
            return;
        preOrderList.add(root.val);
        preOrder(root.left,preOrderList);
        preOrder(root.right,preOrderList);

    }

}
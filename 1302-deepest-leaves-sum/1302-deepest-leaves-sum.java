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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int sum=0;

        q.add(root);

        while(!q.isEmpty()){
            int n=q.size();

            for(int i=0;i<n;i++){
                TreeNode current=q.remove();
                sum+=current.val;

                if(current.left!=null){
                    q.add(current.left);
                }

                if(current.right!=null){
                    q.add(current.right);
                }
            }

            if(!q.isEmpty())
                sum=0;
        }

        return sum;
    }
}
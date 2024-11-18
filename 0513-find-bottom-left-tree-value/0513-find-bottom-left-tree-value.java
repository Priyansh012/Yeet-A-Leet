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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int left=Integer.MAX_VALUE;

        q.add(root);

        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode current = q.remove();
                if(i==0)
                    left=current.val;

                if(current.left!= null)
                    q.add(current.left);
                if(current.right!=null)
                    q.add(current.right);
            }
        }

        return left;
    }
}
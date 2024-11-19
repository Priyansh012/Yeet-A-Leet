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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int max=Integer.MIN_VALUE;
        int level=0;
        int currentLevel=0;

        q.add(root);

        while(!q.isEmpty()){
            int sum=0;
            int n=q.size();
            currentLevel+=1;
            for(int i=0;i<n;i++){
                TreeNode current=q.remove();
                sum=sum+current.val;

                if(current.left!=null){
                    q.add(current.left);
                }

                if(current.right!=null){
                    q.add(current.right);
                }
            }
            if(max<sum){
                max=sum;
                level=currentLevel;
            }
        }

        return level;
    }
}
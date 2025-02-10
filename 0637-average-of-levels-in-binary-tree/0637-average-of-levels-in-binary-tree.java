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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q= new LinkedList();
        List<Double> result= new ArrayList();
        q.add(root);

        while(!q.isEmpty()){
            int n=q.size();
            double sum=0;
            double avg=0;
            for(int i=0;i<n;i++){
                TreeNode current=q.poll();
                sum+=(double) current.val;

                if(current.left!=null)
                    q.add(current.left);
                
                if(current.right!=null)
                    q.add(current.right);
            }

            avg=sum/(double)n;
            result.add(avg);
        }

        return result;
    }
}
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList();

        if(root==null)
            return result;

        Queue<TreeNode> q = new LinkedList();

        q.add(root);

        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> currentLevel= new ArrayList();

            for(int i=0;i<n;i++){
                TreeNode current = q.poll();
                currentLevel.add(current.val);

                if(current.left!=null)
                    q.add(current.left);
                
                if(current.right!=null)
                    q.add(current.right);
                
            }

            result.add(currentLevel);
        }
        Collections.reverse(result);

        return result; 
    }
}
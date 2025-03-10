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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currentDepth=1;
        
        if(depth==1){
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;

        }

        while(!q.isEmpty()){
            int n=q.size();
            currentDepth+=1;

            for(int i=0;i<n;i++){
                TreeNode node = q.poll();
                if(currentDepth==depth){
                    TreeNode tempLeft=node.left;
                    TreeNode tempRight=node.right;
                    TreeNode newNodeLeft = new TreeNode(val);
                    TreeNode newNodeRight = new TreeNode(val);

                    node.left=newNodeLeft;
                    node.right=newNodeRight;

                    newNodeLeft.left=tempLeft;
                    newNodeRight.right=tempRight;
                }

                if(node.left!=null)
                    q.add(node.left);

                if(node.right!=null)
                    q.add(node.right);
                
            }

            if(currentDepth==depth){
                break;
            }
        }

        return root;
    }
}
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
    public int sumEvenGrandparent(TreeNode root) {
        if(root==null)
            return 0;
        
        int sum=0;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode current=q.poll();
                if(current.val%2==0){
                    int leftGcSum=0;
                    int rightGcSum=0;
                    if(current.left!=null){
                        q.add(current.left);
                        if(current.left.left!=null){
                            leftGcSum+=current.left.left.val;
                        }
                        if(current.left.right!=null){
                            leftGcSum+=current.left.right.val;
                        }
                    }
                    
                    if(current.right!=null){
                        q.add(current.right);
                        if(current.right.left!=null){
                            rightGcSum+=current.right.left.val;
                        }
                        if(current.right.right!=null){
                            rightGcSum+=current.right.right.val;
                        }
                    }
                    sum+=leftGcSum+rightGcSum;
                }
                else{
                    if(current.left!=null){
                        q.add(current.left);
                    }
                    if(current.right!=null){
                        q.add(current.right);
                    }
                }
            }
        }

        return sum;
    }
}
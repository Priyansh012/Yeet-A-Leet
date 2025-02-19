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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        boolean evenLevel=true;

        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            int oddLevelPrevious=Integer.MIN_VALUE;
            int evenLevelPrevious=Integer.MAX_VALUE;

            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                if(evenLevel){
                    if(node.val%2==0 || node.val<=oddLevelPrevious){
                         System.out.println(node.val+":"+oddLevelPrevious);
                        return false;
                    }
                    oddLevelPrevious=node.val;    
                }

                else{
                    if(node.val%2==1 || node.val>=evenLevelPrevious){
                        System.out.println(node.val+":"+evenLevelPrevious);
                        return false;
                    }
                    evenLevelPrevious=node.val;       
                }

                if(node.left!=null)
                    q.add(node.left);
                
                if(node.right!=null)
                    q.add(node.right);
                
                
            }

            evenLevel=!evenLevel;
        }

        return true;
    }
}
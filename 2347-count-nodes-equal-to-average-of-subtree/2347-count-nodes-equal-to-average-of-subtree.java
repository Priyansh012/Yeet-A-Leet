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
    private int res=0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    private Pair<Integer, Integer> dfs(TreeNode node){
        if(node==null)
            return new Pair<>(0, 0);
        

        Pair<Integer, Integer> leftData=dfs(node.left);
        Pair<Integer, Integer> rightData=dfs(node.right);
        int count=leftData.getValue()+rightData.getValue()+1;
        int sum=leftData.getKey()+rightData.getKey()+node.val;
        int avg=sum/count;

        if(node.val==avg){
            System.out.println(node.val);
            res+=1;
        }
            
        
        return new Pair<>(sum, count);
    }
}
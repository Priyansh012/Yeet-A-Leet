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

    private int[] dfs(TreeNode node){
        if(node==null)
            return new int[]{0, 0};
        

        int [] leftData=dfs(node.left);
        int [] rightData=dfs(node.right);

        int sum=leftData[0]+rightData[0]+node.val;
        int count=leftData[1]+rightData[1]+1;
        int avg=sum/count;

        if(node.val==avg){
            System.out.println(node.val);
            res+=1;
        }
            
        
        return new int[]{sum,count};
    }
}
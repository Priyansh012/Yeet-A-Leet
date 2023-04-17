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

 class Pair{
     TreeNode node;
     long num;

     Pair(TreeNode _node, long _num){
         node=_node;
         num=_num;
     }
 }


class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        long maxWidth=0;
        Queue<Pair> q= new LinkedList<Pair>();
        q.offer( new Pair (root,0));

        while(!q.isEmpty()){
            int n=q.size();
            long mmin= q.peek().num;
            long first=0, last=0;
            for(int i=0;i<n;i++){
                long curId= q.peek().num-mmin;
                TreeNode node = q.peek().node;
                q.poll();
                if(i==0)
                    first=curId;
                if(i==n-1)
                    last=curId;
                
                if(node.left!=null)
                    q.offer(new Pair(node.left, 2*curId+1));
                if(node.right!=null)
                    q.offer(new Pair(node.right, 2*curId+2));
            }

            maxWidth= Math.max(maxWidth, last-first+1);
        }

        return (int)maxWidth;
    }
}
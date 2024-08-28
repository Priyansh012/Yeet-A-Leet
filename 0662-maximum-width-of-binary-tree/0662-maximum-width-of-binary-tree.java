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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        
        //using long because the range of numbers can be more than the max. int value
        //but the final answer will be 32 bit singed integer
        //so after substraction the value will be 32 bit sing int but before it can be long
        long maxWidth = 0;
        Queue<Pair<TreeNode, Long>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0L));

        while (!q.isEmpty()) {
            int n = q.size();
            long first = 0, last = 0;
            for (int i = 0; i < n; i++) {
                long curIdx = q.peek().getValue();
                TreeNode node = q.peek().getKey();
                q.poll();

                if (i == 0)
                    first = curIdx;
                
                if (i == n - 1)
                    last = curIdx;

                if (node.left != null)
                    q.offer(new Pair<>(node.left, 2L * curIdx + 1L));
                
                if (node.right != null)
                    q.offer(new Pair<>(node.right, 2L * curIdx + 2L));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        } 

        return (int) maxWidth;
    }
}
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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 0; // Level indicator
        while (!queue.isEmpty()) {
            int size = queue.size();
            if ((i % 2) != 0) { // Check if the level is odd
                int l = 0, r = size - 1;
                List<TreeNode> levelNodes = new ArrayList<>();
                for (TreeNode node : queue) {
                    levelNodes.add(node);
                }
                while (l < r) {
                    int temp = levelNodes.get(l).val;
                    levelNodes.get(l).val = levelNodes.get(r).val;
                    levelNodes.get(r).val = temp;
                    l++;
                    r--;
                }
            }

            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                if (node.left != null) 
                    queue.offer(node.left);
                if (node.right != null) 
                    queue.offer(node.right);
            }

            i++; // Increment level
        }

        return root;
    }
}
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

    //Recursive DFS, 1+max(leftChild, rightChild)
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight= maxDepth(root.right);

        return 1+Math.max(leftHeight,rightHeight);
    }

    // Level order solution
    // public int maxDepth(TreeNode root) {
    //     int height=0;
    //     if(root==null)
    //         return height;
    //     Queue<TreeNode> queue= new LinkedList<>();
    //     queue.add(root);
        
    //     while(!queue.isEmpty()){
    //         int n=queue.size();
    //         List<Integer> currentLevel = new ArrayList<>();
    //         for(int i=0;i<n;i++){
    //             TreeNode current = queue.remove();
    //             currentLevel.add(current.val);
    //             if(current.left!= null)
    //                 queue.add(current.left);
    //             if(current.right!=null)
    //                 queue.add(current.right);
    //         }
    //         height++;
    //     }
    //     return height;
    // }
}
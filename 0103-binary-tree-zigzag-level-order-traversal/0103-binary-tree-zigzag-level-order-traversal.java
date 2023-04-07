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

 //level order traversal with a flag true to traverse LTR and flag false to traverse RTL
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue= new LinkedList<>();
        boolean leftToRight=true;
        queue.add(root);
        
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> currentLevel = new ArrayList<>(n);
            for(int i=0;i<n;i++){
                TreeNode current = queue.remove();
                currentLevel.add(current.val);
                if(current.left!= null)
                    queue.add(current.left);
                if(current.right!=null)
                    queue.add(current.right);
            }
            //reverse the current level list if flag is off which to perform RTL
            if(!leftToRight)
                Collections.reverse(currentLevel);
            //Switch flag at every level to operate it as a zig-zag traversal
            leftToRight=!leftToRight;
            result.add(currentLevel);
        }
        return result;
    }
}
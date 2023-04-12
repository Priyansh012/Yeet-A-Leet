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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    //For Right View, do reverse of pre-order traversal(Root right left)
    public void rightView(TreeNode root, List<Integer> result, int level){
        if(root==null)
            return;
        
        if(level == result.size())
            result.add(root.val);
        
        if(root.right!=null)
            rightView(root.right, result, level+1);

        if(root.left!=null)
            rightView(root.left, result, level+1);
    }

        //For Left View, do pre-order traversal(Root left right)
    public void leftView(TreeNode root, List<Integer> result, int level){
        if(root==null)
            return;
        
        if(level == result.size())
            result.add(root.val);

        if(root.left!=null)
            leftView(root.left, result, level+1);

        if(root.right!=null)
            leftView(root.right, result, level+1);

    }
}
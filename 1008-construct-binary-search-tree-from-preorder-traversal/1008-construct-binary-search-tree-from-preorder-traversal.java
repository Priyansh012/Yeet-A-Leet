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
    public TreeNode bstFromPreorder(int[] preorder) {
        // 2nd param is the pointer to track which element to insert from pre order
        //since in java we dont have call by reference, we are using array with 1 element to track the pointer
        return buildBST(preorder, new int [] {0},Integer.MAX_VALUE);
    }

    public TreeNode buildBST(int [] preorder, int [] i, int bound){
        //if all the elements from preorder list are done then we cant insert so return null
        // or the ith element from preorder is greater than the upper bound then we cant insert so return null
        if(i[0]== preorder.length || preorder[i[0]]> bound)
            return null;
        //construct node
        TreeNode root = new TreeNode(preorder[i[0]]);
        //increment pointer to the next element in the preorder list
        i[0]=i[0]+1;
        //lefts bound will be root
        root.left = buildBST(preorder, i, root.val);
        //rights bound will be bound var which is passed
        root.right = buildBST(preorder, i, bound);

        return root;

    }
}
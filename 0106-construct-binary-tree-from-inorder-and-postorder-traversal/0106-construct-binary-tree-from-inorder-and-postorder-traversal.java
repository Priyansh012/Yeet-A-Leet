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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder==null || inorder.length!=postorder.length)
            return null;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i], i);
        }

        TreeNode root= buildTree(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, inorderMap);
        return root;
    }
         public TreeNode buildTree(int [] postorder, int postStart, int postEnd,int [] inorder, 
     int inStart,int inEnd, Map<Integer, Integer> inorderMap){

         //base case, if there is nothing left in traversal then return null
         if(postStart> postEnd || inStart > inEnd)
            return null;
        
        //start constructing the tree from the root(i.e. current end element of postOrder(left, right, root))
        TreeNode root = new TreeNode(postorder[postEnd]);

        //to know what is at left and right of the root, check the root value from the inOrder map which we created
        int inRoot = inorderMap.get(root.val);

        //element count in the left subtree of root
        int numsLeft = inRoot-inStart;

        //build left subtree by calling same function recrusively
        root.left = buildTree(postorder, postStart, postStart+numsLeft-1, inorder, inStart, inRoot-1, inorderMap);

        //build right subtree by calling same function recrusively
        root.right=buildTree(postorder, postStart+numsLeft, postEnd-1, inorder, inRoot+1, inEnd, inorderMap);

        return root;
     }
}
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i], i);
        }

        TreeNode root= buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inorderMap);
        return root;
    }

     public TreeNode buildTree(int [] preorder, int preStart, int preEnd,int [] inorder, 
     int inStart,int inEnd, Map<Integer, Integer> inorderMap){

         //base case, if there is nothing left in traversal then return null
         if(preStart> preEnd || inStart > inEnd)
            return null;
        
        //start constructing the tree from the root(i.e. current start element of preOrder(root, left, right))
        TreeNode root = new TreeNode(preorder[preStart]);

        //to know what is at left and right of the root, check the root value from the inOrder map which we created
        int inRoot = inorderMap.get(root.val);

        //element count in the left subtree of root
        int numsLeft = inRoot-inStart;

        //build left subtree by calling same function recrusively
        root.left = buildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inorderMap);

        //build right subtree by calling same function recrusively
        root.right=buildTree(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inorderMap);

        return root;
     }
}
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
    private TreeNode first;
    private TreeNode prev; 
    private TreeNode middle;
    private TreeNode last;

    public void recoverTree(TreeNode root) {
        first=middle=last=null;
        prev=new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        //case 1: non-adj. violation of BST nodes
        if(first!=null && last!=null)
        {
            int temp=first.val;
            first.val=last.val;
            last.val=temp;
        }

        //case 2: adj. violation of BST nodes
        if(first!=null && last==null)
        {
            int temp=first.val;
            first.val=middle.val;
            middle.val=temp;
        }
    }

    //Left Root Right(because inorder traversal stores the BST nodes in sorted order and hence easy for our comparison)
    private void inorder(TreeNode root) {
        if (root==null)
            return;
        inorder(root.left);
        
        if (root.val<prev.val) {
            //If this is first violation, mark first and middle
            if (first==null) {
                first=prev;
                middle=root; 
            }   
            //If this is second violation, mark the last
            else
                last=root;
        }
        //update the previous with the current node
        prev=root;
        inorder (root.right);

    }

}
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        //search node in left subtree
        else if(key<root.val){
           root.left= deleteNode(root.left, key);
        }
        
        //search node in the right subtree
        else if(key>root.val){
            root.right=deleteNode(root.right, key);
        }

        //found the node to be deleted? 
        else{
            
            //case 1:node has no child
            if(root.left == null && root.right==null){
                root=null;
            }

            //case 2a:node has 1 child(left child not present but right child is present)
            else if(root.left==null){
                root=root.right;
            }

            //case 2b:node has 1 child(right child not present but left child is present)
            else if(root.right==null){
                root=root.left;
            }

            //case 3: node has 2 children(can be done by using findMin from right subtree or findMAx from left subtree)
            else{
                TreeNode temp = findMin(root.right);
                root.val=temp.val;

                //reduced to case 2, now delete node with one child
                root.right=deleteNode(root.right, temp.val);
            }
        }

        return root;
    }

    TreeNode findMin(TreeNode root){
        TreeNode temp=root;
        while(temp.left!=null){
            temp=temp.left;
        }

        return temp;
    }
}
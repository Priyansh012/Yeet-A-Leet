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

//Recursive Solution
//  //Reverse post order can be used(Right, Left, Root)
// class Solution {
//     TreeNode prev= null;
//     public void flatten(TreeNode root) {
//         if(root==null)
//             return;
//         flatten(root.right);
//         flatten(root.left);

//         root.right=prev;
//         root.left=null;

//         prev=root;
//     }
// }


//Iterative Solution using threaded Binary tree or Morris pre-order traversal
class Solution {
    public  void flatten(TreeNode root){
        TreeNode cur= root;

        while(cur!=null){
            if(cur.left!=null){
                TreeNode prev=cur.left;
                while(prev.right!=null){
                    prev=prev.right;
                }
                prev.right=cur.right;
                cur.right=cur.left;
                cur.left=null;

            }
            cur=cur.right;
        }
    }
}

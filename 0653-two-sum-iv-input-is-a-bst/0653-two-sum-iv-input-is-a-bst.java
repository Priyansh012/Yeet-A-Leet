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
    public boolean findTarget(TreeNode root, int k) {
        if (root==null)
            return false;

        //next or  asc order inorder (left, Root, right) 
        BSTIterator l = new BSTIterator (root, false);
        //before or desc order inorder (right, root, left) 
        BSTIterator r = new BSTIterator(root, true);

        int i= l.next();
        int j=r.next();

        while(i<j){
            if (i+j==k)
                return true;
            else if (i+j>k)
                j=r.next();
            else
                i=l.next();

        }

        return false;
    }
}

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    boolean reverse=true;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse=isReverse;
        pushAll(root);
    }
    
    //returns the next largest/smallest on the basis of the reverse bool val
    public int next() {
        TreeNode temp = stack.pop();
        if(reverse==false)
            pushAll(temp.right);
        else
            pushAll(temp.left);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node){
        while(node!=null){
            stack.push(node);
            if(reverse==true)
                node=node.right;
            else
                node=node.left;
        }
    }
}
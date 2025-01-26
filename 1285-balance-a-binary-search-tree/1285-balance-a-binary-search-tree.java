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
    //there can be more than one answer because we dont know the root
    //so via Inorder we can only give one result which is the sorted one
    //where root is the mid element of the sorted list
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        //inOrder because inOrder of BST is always sorted
        //how? left->root->right will give sorted result
        inOrder(root, sortedList);
        //and from that sorted List we can construct a BST easily
        TreeNode newBST=constructBST(sortedList,0, sortedList.size()-1);
        return newBST;
    }

    private void inOrder(TreeNode root, List<Integer> sortedList){
        if(root==null)
            return;
        inOrder(root.left, sortedList);
        sortedList.add(root.val);
        inOrder(root.right, sortedList);
    }

    private TreeNode constructBST(List<Integer> sortedList, int start, int end){
        if(start>end)
            return null;
        
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(sortedList.get(mid));
        root.left=constructBST(sortedList, start, mid-1);
        root.right=constructBST(sortedList, mid+1, end);

        return root;
    }
}
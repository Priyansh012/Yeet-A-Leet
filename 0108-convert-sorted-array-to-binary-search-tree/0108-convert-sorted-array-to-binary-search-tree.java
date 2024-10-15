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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        int middle = nums[n/2];

        return constructBST(nums, 0, n - 1);
    }

    public TreeNode constructBST(int nums [], int start, int end){
        if(start>end){
            return null;
        }

        int mid=start+(end-start)/2;
        TreeNode root= new TreeNode(nums[mid]);

        root.left=constructBST(nums, start, mid-1);
        root.right=constructBST(nums, mid+1, end);

        return root;
    }
}
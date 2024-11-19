/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // Two pass solution
    // public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    // List<Integer> result = new ArrayList<>();

    // inOrder(root1, result);
    // inOrder(root2, result);
    // Collections.sort(result);
    // return result;
    // }
    // private void inOrder(TreeNode root, List<Integer> result){
    // Stack<TreeNode> st= new Stack<>();

    // while(true){
    // if(root!=null){
    // st.push(root);
    // root=root.left;
    // }
    // else{
    // if(st.isEmpty())
    // break;

    // root=st.pop();
    // result.add(root.val);
    // root=root.right;
    // }
    // }

    // }
    // One pass solution
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        List<Integer> res = new ArrayList<>();

        while (root1 != null || root2 != null || !st1.empty() || !st2.empty()) {
            while (root1 != null) {
                st1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                st2.push(root2);
                root2 = root2.left;
            }
            if (st2.empty() || (!st1.empty() && st1.peek().val <= st2.peek().val)) {
                root1 = st1.pop();
                res.add(root1.val);
                root1 = root1.right;
            } else {
                root2 = st2.pop();
                res.add(root2.val);
                root2 = root2.right;
            }
        }
        return res;
    }

}
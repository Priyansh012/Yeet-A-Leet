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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();

        inOrder(root1, result);
        inOrder(root2, result);
        Collections.sort(result);
        return result;
    }
    private void inOrder(TreeNode root, List<Integer> result){
        Stack<TreeNode> st= new Stack<>();

        while(true){
            if(root!=null){
                st.push(root);
                root=root.left;
            }
            else{
                if(st.isEmpty())
                    break;
                
                root=st.pop();
                result.add(root.val);
                root=root.right;
            }
        }
        
    }
}
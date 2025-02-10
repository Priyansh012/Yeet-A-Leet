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
    //BFS
    public int goodNodes(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q= new LinkedList<>();
        q.add(new Pair(root, root.val));
        int count=1;

        while(!q.isEmpty()){
            int n=q.size();

            for(int i=0;i<n;i++){
                Pair<TreeNode, Integer> currentData=q.poll();
                TreeNode currentNode=currentData.getKey();
                int currentMax=currentData.getValue();
                if(currentNode.left!=null){
                    if(currentNode.left.val>=currentMax){
                        count+=1;
                        q.add(new Pair(currentNode.left, currentNode.left.val));
                    }

                    else{
                        q.add(new Pair(currentNode.left, currentMax));
                    }
                }

                if(currentNode.right!=null){
                    if(currentNode.right.val>=currentMax){
                        count+=1;
                        q.add(new Pair(currentNode.right, currentNode.right.val));
                    }

                    else{
                        q.add(new Pair(currentNode.right, currentMax));
                    }

                }
            }
        }

        return count;
    }

    //DFS
    /*
    int count = 0; // global variable to count

    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return count; // returning the count value
    }

    private void helper(TreeNode root, int max) {
        if (root != null) {
            if (root.val >= max) { // if root.val > the max value of path from root of the tree to current node 
                count++; //increment count
            }
            helper(root.left, Math.max(root.val, max));  // updating max value of current path and traversing left to the current node
            helper(root.right, Math.max(root.val, max));  // updating max value of current path and traversing right to the current node
        }
    }
    */
}
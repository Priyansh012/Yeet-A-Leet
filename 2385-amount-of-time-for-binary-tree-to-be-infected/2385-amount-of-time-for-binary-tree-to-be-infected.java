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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parents_track = new HashMap<TreeNode, TreeNode>();
        //first BFS to mark the parents of all nodes so that we can traverse in upward direction also
        TreeNode target = markParentsAndFindTargetNode(root,parents_track, start);
        Map<TreeNode, Boolean> visited = new HashMap<TreeNode, Boolean>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(target);
        visited.put(target,true);

        //tracking minutes taken to burn the tree
        int minutes=0;

        //second BFS to traverse from target node
        while(!q.isEmpty()){
            int n =q.size();
            boolean neighbourFlag=false;
            

            for(int i=0;i<n;i++){
                TreeNode node = q.poll();

                //traverse down to the left
                if(node.left!=null && visited.get(node.left)==null){
                    neighbourFlag=true;
                    visited.put(node.left, true);
                    q.add(node.left);
                }

                //traverse down to the right
                if(node.right!=null && visited.get(node.right)==null){
                    neighbourFlag=true;
                    visited.put(node.right, true);
                    q.add(node.right);
                }

                //traverse up towards the parent node
                if(parents_track.get(node)!=null && visited.get(parents_track.get(node))==null){
                    neighbourFlag=true;
                    visited.put(parents_track.get(node), true);
                    q.add(parents_track.get(node));
                }
            }
            if(neighbourFlag)
                minutes++;
        }

        return minutes;
    }

    //turned a Binary Tree into an Undirected Graph for traversing upwards and downwards
    private TreeNode markParentsAndFindTargetNode(TreeNode root, Map<TreeNode, TreeNode>  parents_track, int start){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode target = new TreeNode(0);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.val==start)
                target=node;
            if(node.left!=null){
                parents_track.put(node.left, node);
                q.add(node.left);
            }
            if(node.right!=null){
                parents_track.put(node.right, node);
                q.add(node.right);
            }
        }

        return target;
    }

}
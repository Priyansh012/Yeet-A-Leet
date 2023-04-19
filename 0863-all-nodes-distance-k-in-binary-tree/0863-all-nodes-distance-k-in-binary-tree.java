/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents_track = new HashMap<TreeNode, TreeNode>();
        //first BFS to mark the parents of all nodes so that we can traverse in upward direction also
        markParents(root,parents_track);
        Map<TreeNode, Boolean> visited = new HashMap<TreeNode, Boolean>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(target);
        visited.put(target,true);

        //tracking if distance==k or not so that we can break out and return the elements as answers
        int current_distance=0;

        //second BFS to traverse from target nodes to find nodes till kth distance from target
        while(!q.isEmpty()){
            int n =q.size();

            if(current_distance==k)
                break;
            current_distance++;

            for(int i=0;i<n;i++){
                TreeNode node = q.poll();

                //traverse down to the left
                if(node.left!=null && visited.get(node.left)==null){
                    visited.put(node.left, true);
                    q.add(node.left);
                }

                //traverse down to the right
                if(node.right!=null && visited.get(node.right)==null){
                    visited.put(node.right, true);
                    q.add(node.right);
                }

                //traverse up towards the parent node
                if(parents_track.get(node)!=null && visited.get(parents_track.get(node))==null){
                    visited.put(parents_track.get(node), true);
                    q.add(parents_track.get(node));
                }
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode current= q.poll();
            result.add(current.val);
        }

        return result;
    }

    //turned a Binary Tree into an Undirected Graph for traversing upwards and downwards
    private void markParents(TreeNode root, Map<TreeNode, TreeNode>  parents_track){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left!=null){
                parents_track.put(node.left, node);
                q.add(node.left);
            }
            if(node.right!=null){
                parents_track.put(node.right, node);
                q.add(node.right);
            }
        }
    }
}
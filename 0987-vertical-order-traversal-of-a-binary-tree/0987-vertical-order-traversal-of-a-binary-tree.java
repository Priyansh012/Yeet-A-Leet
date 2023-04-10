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

class Tuple{
    TreeNode node;
    //row to indicate vertical
    int row;
    //cols to indicate levels
    int col;
    public Tuple(TreeNode _node, int _row, int _col){
        node= _node;
        row= _row;
        col= _col;
    }
} 
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        //Outer TreeMap to store nodes in the verticals in sorted order
        //Inner TreeMap to store nodes in the levels in sorted order
        //Priority Queue to store nodes in sorted order(in case if level and vertical is same for nodes)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodesMap = new TreeMap<>();

        //This queue is to store the order of traversals(level order traversal)
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0));

        //level order traversal
        while(!q.isEmpty()){
            // remove first inserted element from queue and do level order traversal
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int vertical= tuple.row;
            int level= tuple.col;

            if(!nodesMap.containsKey(vertical))
                nodesMap.put(vertical, new TreeMap<>());
            if(!nodesMap.get(vertical).containsKey(level))
                nodesMap.get(vertical).put(level, new PriorityQueue<>());
            
            //adding the node val into the priority queue
            nodesMap.get(vertical).get(level).offer(node.val);

            //if current node has left element then add it into the traversal queue
            if(node.left!=null)
                q.offer(new Tuple(node.left, vertical-1, level+1));
            
            //if current node has right element then add it into the traversal queue
            if(node.right!=null)
                q.offer(new Tuple(node.right, vertical+1, level+1));
        }

        //to add the result into list of list
        List<List<Integer>> result = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys: nodesMap.values()){
            result.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: ys.values()){
                while(!nodes.isEmpty()){
                    result.get(result.size()-1).add(nodes.poll());
                }
            }
        }

        return result;

    }
}
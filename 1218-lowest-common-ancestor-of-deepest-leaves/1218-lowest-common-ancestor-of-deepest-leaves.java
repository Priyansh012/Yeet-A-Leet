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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null)
            return null;
        
        Queue<Pair<TreeNode, TreeNode>> q = new LinkedList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        List<TreeNode> deepestNodes = new ArrayList<>();

        q.add(new Pair(root, root));
        map.put(root, root);

        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Pair<TreeNode, TreeNode> nodeData = q.poll();
                TreeNode node= nodeData.getKey();
                TreeNode parent=nodeData.getValue();
                deepestNodes.add(node);

                if(node.left!=null){
                    q.add(new Pair(node.left, node));
                    map.put(node.left, node);
                }
                    
                if(node.right!=null){
                    q.add(new Pair(node.right, node));
                    map.put(node.right, node);
                }
                    
            }
            if(!q.isEmpty())
                deepestNodes.clear();
        
        }

        //deepestNodes.forEach(System.out::println);
        // for(TreeNode n: map.keySet()){
        //     System.out.println(n.val + ":" + map.get(n).val);
        // }

        //Calculate LCA
        while (deepestNodes.size() > 1) {
            Set<TreeNode> parents = new HashSet<>();
            for (TreeNode node : deepestNodes) {
                parents.add(map.get(node));
            }
            deepestNodes.clear();
            deepestNodes.addAll(parents); 
        }
        
        return deepestNodes.get(0);
    }
}
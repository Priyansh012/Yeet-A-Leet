/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //BFS/level order traversal is easy to use for this problem
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder serializedResult = new StringBuilder();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                serializedResult.append("N"+";");
                //end current iteration
                continue;
            }
            serializedResult.append(node.val+";");
            q.offer(node.left);
            q.offer(node.right);
        }

        return serializedResult.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "")
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        String [] treeElements = data.split(";");
        TreeNode root = new TreeNode(Integer.parseInt(treeElements[0]));
        q.offer(root);
        for(int i=1;i<treeElements.length;i++){
            TreeNode node = q.poll();
            if(!treeElements[i].equals("N")){
                TreeNode left = new TreeNode(Integer.parseInt(treeElements[i]));
                node.left=left;
                q.offer(left);
            }
            if(!treeElements[++i].equals("N")){
                TreeNode right = new TreeNode(Integer.parseInt(treeElements[i]));
                node.right=right;
                q.offer(right);
            }
        }
        
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> postOrder = new ArrayList<>();
        if(root==null)
            return postOrder;
        return dfs(root, postOrder);
    }

    private List<Integer> dfs(Node node, List<Integer> list){
        if(node.children.isEmpty()){
            list.add(node.val);
            return list;
        }

        for(int i=0;i<node.children.size();i++){
            dfs(node.children.get(i), list);
        }

        list.add(node.val);
        return list;
    }
}
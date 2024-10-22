/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
            return root;
        Queue<Node> queue= new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Node> currentLevel = new ArrayList<>();
            for(int i=0;i<n;i++){
                Node current = queue.remove();
                currentLevel.add(current);
                if(current.left!= null)
                    queue.add(current.left);
                if(current.right!=null)
                    queue.add(current.right);
            }

            for(int i=0;i<currentLevel.size()-1;i++){
                currentLevel.get(i).next=currentLevel.get(i+1);
            }
        }
        return root;
    }
}
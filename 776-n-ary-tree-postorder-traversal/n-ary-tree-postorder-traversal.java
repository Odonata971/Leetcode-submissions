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
};
*/

class Solution {
    List<Integer> res = new ArrayList<>();

    private void postOrder(Node root) {
        if (root == null)
            return;
        for (Node child : root.children) {
            postOrder(child);
            res.add(child.val);
        }
    }

    public List<Integer> postorder(Node root) {
        if (root == null)
            return new ArrayList<>();
        postOrder(root);
        res.add(root.val);
        return res;
    }
}
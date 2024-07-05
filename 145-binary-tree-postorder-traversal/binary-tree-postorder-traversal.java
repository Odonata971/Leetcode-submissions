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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        postOrder(root, answer);
        return answer;
    }

    private void postOrder(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        postOrder(node.left, ans);
        postOrder(node.right, ans);
        ans.add(node.val);
    }
}
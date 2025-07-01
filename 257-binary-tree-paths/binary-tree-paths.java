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
    List<String> answer = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return answer;

        solver(root, "");
        return answer;
    }

    public void solver(TreeNode root, String str) {
        if (root == null) return;

        String path = str.isEmpty() ? "" + root.val : str + "->" + root.val;
        if (root.left == null && root.right == null) {
            answer.add(path);
            return;
        }
        
        solver(root.left, path);
        solver(root.right, path);
    }
}
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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathStart = new StringBuilder(), pathEnd = new StringBuilder();
        dfs(root, startValue, pathStart);
        dfs(root, destValue, pathEnd);

        int i = 0;
        int maxIndex = Math.min(pathStart.length(), pathEnd.length());
        while (i < maxIndex && pathStart.charAt(pathStart.length() - i - 1) == pathEnd.charAt(pathEnd.length() - i - 1)) {
            ++i;
        }
        return "U".repeat(pathStart.length() - i) + pathEnd.reverse().toString().substring(i);
    }

    private static boolean dfs(TreeNode root, int researchedValue, StringBuilder currentPath) {
        if (root.val == researchedValue) {
            return true;
        }
        if (root.left != null && dfs(root.left, researchedValue, currentPath)) {
            currentPath.append("L");
        } else if (root.right != null && dfs(root.right, researchedValue, currentPath)) {
            currentPath.append("R");
        }
        return currentPath.length() > 0;
    }
}
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int children = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < s.length && children < g.length; i++) {
            if (g[children] <= s[i]) {
                children++;
            }
        }
        return children;
    }
}
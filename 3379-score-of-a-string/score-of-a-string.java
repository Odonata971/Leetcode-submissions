class Solution {
    public int scoreOfString(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            int a = chars[i] - chars[i + 1];
            res += Math.abs(a); 
        }
        return res;
    }
}
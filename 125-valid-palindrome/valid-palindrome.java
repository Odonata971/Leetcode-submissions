class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z\\d]*","").toLowerCase();
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
        
    }
}
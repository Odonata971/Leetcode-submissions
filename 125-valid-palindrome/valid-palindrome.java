class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z\\d]*","").toLowerCase();
        StringBuilder reverse = new StringBuilder(s).reverse();
        return reverse.toString().equals(s);
    }
}
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder onlyLetters = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                onlyLetters.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return new String(onlyLetters).equals(new String(onlyLetters.reverse()));
        
    }
}
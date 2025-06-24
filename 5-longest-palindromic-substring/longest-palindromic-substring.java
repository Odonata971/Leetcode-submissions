class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int lengthOdd = expandFromCenter(s, i, i);
            int lengthEven = expandFromCenter(s, i, i + 1);
            
            int maxLength = Math.max(lengthOdd, lengthEven);
            if (maxLength > end - start) {
                start = i - (maxLength - 1) / 2;
                end = i + (maxLength / 2);
            }
            
        }
        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
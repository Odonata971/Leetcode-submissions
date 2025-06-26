class Solution {
    public int longestSubsequence(String s, int k) {
        if (s.isEmpty()) return 0;

        int n = s.length();
        int answer = 0;
        long value = 0;
        int i = n - 1;

        // Limit substring to max 63 bits to avoid overflow
        int bitCount = 0;

        while (i >= 0 && bitCount < 63) {
            if (s.charAt(i) == '1') {
                value += (1L << bitCount);
            }
            if (value <= k) {
                answer++;
            } else {
                break;
            }
            bitCount++;
            i--;
        }

        // Count remaining zeros
        while (i >= 0) {
            if (s.charAt(i) == '0') {
                answer++;
            }
            i--;
        }

        return answer;
    }
}
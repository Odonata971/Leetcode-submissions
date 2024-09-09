public class Solution {
    public int LengthOfLongestSubstring(string s) {
        int n = s.Length;
        int maxLength = 0;
        Dictionary<char, int> charMap = new Dictionary<char, int>();
        int left = 0;
        
        for (int right = 0; right < s.Length; right++) {
            if (charMap.TryGetValue(s[right], out int lastSeenIndex) && lastSeenIndex >= left) {
                left = lastSeenIndex + 1;
            }
            
            charMap[s[right]] = right;
            maxLength = Math.Max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
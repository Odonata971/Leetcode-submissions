class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];        
        for (char ch : s.toCharArray()) {
            freq[ch-'a']++;                     
        }
        int minEven = Integer.MAX_VALUE;
        int maxOdd = 0;
        for (int count : freq) {
            if (minEven > count && count %2 == 0 && count != 0) minEven = count;
            if (maxOdd < count && count %2 == 1) maxOdd = count;
        }
        return maxOdd - minEven;
    }
}
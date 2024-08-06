class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);

        int minPushes = 0;
        for (int i = 0; i < 26; i++) {
            int keyTaps = i / 8 + 1;

            minPushes += freq[26 - i - 1] * keyTaps;
        }

        return minPushes;
    }
}
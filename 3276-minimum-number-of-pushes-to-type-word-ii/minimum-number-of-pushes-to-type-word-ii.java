class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        Integer[] freqBoxed = Arrays.stream(freq).boxed().toArray(Integer[]::new);
        Arrays.sort(freqBoxed, Collections.reverseOrder());

        int minPushes = 0;
        for (int i = 0; i < 26; i++) {
            int keyTaps = i / 8 + 1;

            minPushes += freqBoxed[i] * keyTaps;
        }

        return minPushes;
    }
}
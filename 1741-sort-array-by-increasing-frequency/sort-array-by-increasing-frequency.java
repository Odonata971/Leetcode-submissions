class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Create a list of the keys (unique numbers)
        List<Integer> keys = new ArrayList<>(freq.keySet());
        
        // Step 3: Sort the keys based on frequency and value
        Collections.sort(keys, (a, b) -> {
            int freqCompare = freq.get(a).compareTo(freq.get(b));
            if (freqCompare != 0) {
                return freqCompare; // Sort by frequency (ascending)
            }
            // If frequencies are equal, sort by value (descending)
            return b.compareTo(a);
        });
        
        // Step 4: Build the result array
        int[] result = new int[nums.length];
        int index = 0;
        for (int key : keys) {
            int count = freq.get(key);
            for (int i = 0; i < count; i++) {
                result[index++] = key;
            }
        }
        return result;
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        
        /* Print debug for hashmaps
        for (Integer name: freq.keySet()) {
            String key = name.toString();
            String value = freq.get(name).toString();
            System.out.println(key + " " + value);
        }*/

        int max = nums[0];
        for (int key: freq.keySet()) {
            max = freq.get(max) < freq.get(key) ? key : max;
        }
        return max;
    }
}
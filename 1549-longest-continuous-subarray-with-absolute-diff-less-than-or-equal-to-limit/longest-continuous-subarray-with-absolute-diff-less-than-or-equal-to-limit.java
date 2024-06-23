class Solution {
    public int longestSubarray(int[] nums, int limit) {
        /*int n  = nums.length;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int j = i;
            while (j < n && Math.abs(nums[i] - nums[j]) <= limit) {
                count++;
                System.out.println("diff: " + Math.abs(nums[i] - nums[j]) + "\t maxCount: " + maxCount + "\t count: " + count + "\t nums[i]:" + nums[i] + "\t nums[j]:" + nums[j]);
                j++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;*/
        LinkedList<Integer> increase = new LinkedList<>();
        LinkedList<Integer> decrease = new LinkedList<>();

        int max = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            while (increase.size() > 0 && n < increase.getLast()) {
                increase.removeLast();
            }
            increase.add(n);

            while (decrease.size() > 0 && n > decrease.getLast()) {
                decrease.removeLast();
            }

            decrease.add(n);

            while (decrease.getFirst() - increase.getFirst() > limit) {
                if (nums[left] == decrease.getFirst()) {
                    decrease.removeFirst();
                }
                if (nums[left] == increase.getFirst()) {
                    increase.removeFirst();
                }
                left++;
            }

            int size = i - left + 1;
            max = Math.max(max, size);
        }

        return max;

    }
}
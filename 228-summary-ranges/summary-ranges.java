class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<String>();
        List<String> results = new ArrayList<>();
        int n = nums.length;
        StringBuilder ans = new StringBuilder().append(String.valueOf(nums[0]));
        boolean single = true;
        for (int i = 1; i < n; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                if (single) {
                    results.add(ans.toString());
                } else {
                    results.add(ans.append("->").append(String.valueOf(nums[i - 1])).toString());
                }
                ans.setLength(0);
                ans.append(nums[i]);
                single = true;
            } else {
                single = false;
            }
        }
        if (single) {
            results.add(ans.toString());
        } else {
            results.add(ans.append("->").append(String.valueOf(nums[n - 1])).toString());
        }
        return results;
    }
}
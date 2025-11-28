class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] frequencies = new int[nums.length + 1];

        for (int num : nums) {
            frequencies[num]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < frequencies.length; i++) {
            if (frequencies[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
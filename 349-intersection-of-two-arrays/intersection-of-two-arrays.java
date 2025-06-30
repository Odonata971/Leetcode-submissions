class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int k : nums1) {
            set.add(k);
        }
        List<Integer> answer = new ArrayList<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                answer.add(i);
                set.remove(i);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
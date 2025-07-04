class Solution {
    public int thirdMax(int[] nums) {
        List<Integer> distinctNums = new ArrayList<>();
        for (int num : nums) {
            if (!distinctNums.contains(num)) {
                distinctNums.add(num);
            }
        }
        distinctNums.sort((a,b) -> - a.compareTo(b));
        return distinctNums.size() >= 3 ? distinctNums.get(2) : distinctNums.get(0);
    }
}
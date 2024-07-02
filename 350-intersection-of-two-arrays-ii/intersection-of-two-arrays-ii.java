class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> temp = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                temp.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        
        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}
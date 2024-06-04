class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }

        int end = n + m - 1;
        while(n > 0 && m > 0){
            if(nums2[n - 1] >= nums1[m - 1]){
                nums1[end] = nums2[n - 1];
                n--;
            }else{
                nums1[end] = nums1[m - 1];
                m--;
            }
            end--;
        }
        while (n > 0) {
            nums1[end] = nums2[n - 1];
            n--;
            end--;
        }
    }
}
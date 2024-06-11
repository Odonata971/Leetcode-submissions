class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        
        for(int i = 0; i < arr1.length; i++) {
            freq[arr1[i]]++;
        }
        
        int[] ans = new int[arr1.length];

        int idx = 0;
        for(int num: arr2) {
            while(freq[num] > 0) {
                ans[idx++] = num;
                freq[num]--;
            }
        }
        
        for(int i = 0; i < freq.length; i++) {
            while(freq[i] > 0) {
                ans[idx++] = i;
                freq[i]--;
            }
        }
        
        return ans;
    }
}
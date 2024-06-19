class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start = Integer.MAX_VALUE;
        int end = 0;
        int n = bloomDay.length;
        int res = -1;

        for (int flower : bloomDay) {
            start = Math.min(flower, start);
            end = Math.max(flower, end);
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int adjacent = 0;
            int bouquets = 0;

            for (int i = 0; i < n; i++) {
                if (bloomDay[i] <= mid) {
                    adjacent++;
                    if (adjacent >= k) {
                        bouquets++;
                        adjacent = 0;
                    }
                } else {
                    adjacent = 0;
                }
            }

            if (bouquets >= m) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}
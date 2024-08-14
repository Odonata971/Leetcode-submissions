impl Solution {
    pub fn smallest_distance_pair(nums: Vec<i32>, k: i32) -> i32 {
        let mut nums = nums;
        nums.sort_unstable();
        let mut low = 0;
        let mut high = nums[nums.len() - 1] - nums[0];

        while low < high {
            let mid = low + (high - low) / 2;
            if Self::count_pairs(&nums, mid) < k {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        low
    }

    fn count_pairs(nums: &Vec<i32>, distance: i32) -> i32 {
        let mut count = 0;
        let mut left = 0;
        for right in 1..nums.len() {
            while nums[right] - nums[left] > distance {
                left += 1;
            }
            count += (right - left) as i32;
        }
        count
    }
}
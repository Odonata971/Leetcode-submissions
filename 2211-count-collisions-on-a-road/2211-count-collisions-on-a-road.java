class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0;
        int right = n - 1;
        
        // Skip leading 'L's - they move left and never collide
        while (left < n && directions.charAt(left) == 'L') {
            left++;
        }
        
        // Skip trailing 'R's - they move right and never collide
        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }
        
        // Count collisions: all 'L' and 'R' between left and right will collide
        int result = 0;
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                result++;
            }
        }
        
        return result;
    }
}
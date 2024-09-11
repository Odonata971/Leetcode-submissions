class Solution {
     public int reverse(int x) {
        double ans = 0;
        
        while (x != 0) {
            if (ans * 10 > Integer.MAX_VALUE || ans * 10 < Integer.MIN_VALUE) return 0;
            ans *= 10;
            ans += x % 10;
            x /= 10;
            
        }
        return (int) ans;
    }
}
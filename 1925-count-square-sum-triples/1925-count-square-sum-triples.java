class Solution {
    public int countTriples(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int iSquared = (int) Math.pow(i, 2);
                int jSquared = (int) Math.pow(j, 2);
                int c = (int) Math.sqrt(iSquared + jSquared);
                if (c <= n && c * c == iSquared + jSquared) {
                    res += 2;
                }
            }
        }
        return res;
    }
}
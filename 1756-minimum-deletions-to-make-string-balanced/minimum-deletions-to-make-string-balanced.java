class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] minDeletions = new int[n + 1];
        int bCounter = 0;
        for (int i = 1; i <= n; ++i) { 
            //System.out.println(s.charAt(i - 1) + "\t\t" + (i - 1));
            //System.out.println(s.charAt(i - 1) == 'bCounter');
            //System.out.println(Arrays.toString(minDeletions));
            if (s.charAt(i - 1) == 'b') {
                minDeletions[i] = minDeletions[i - 1];
                ++bCounter;
            } else {
                //System.out.println(Math.min(minDeletions[i - 1] + 1, bCounter));
                minDeletions[i] = Math.min(minDeletions[i - 1] + 1, bCounter);
            }
            //System.out.println();
        }
        return minDeletions[n];
    }
}
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] minDeletions = new int[n + 1];
        int countB = 0;
        for (int i = 0; i < n; i++) { 
            //System.out.println(s.charAt(i - 1) + "\t\t" + (i - 1));
            //System.out.println(s.charAt(i - 1) == 'countB');
            //System.out.println(Arrays.toString(minDeletions));
            if (s.charAt(i) == 'b') {
                minDeletions[i + 1] = minDeletions[i];
                ++countB;
            } else {
                //System.out.println(Math.min(minDeletions[i - 1] + 1, countB));
                minDeletions[i + 1] = Math.min(minDeletions[i] + 1, countB);
            }
            //System.out.println();
        }
        return minDeletions[n];
    }
}
class Solution {
    public int minDeletionSize(String[] strs) {
        int colToRemove = 0;
        for (int j = 0; j < strs[0].length(); j++) {
            boolean isFound = true;
            for (int i = 1; i < strs.length && isFound; i++) {
                if (strs[i - 1].charAt(j) > strs[i].charAt(j)) {
                    colToRemove++;
                    isFound = !isFound;
                }
            }
        }
        return colToRemove;
    }
}
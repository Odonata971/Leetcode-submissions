class Solution {
    public int minOperations(String[] logs) {
        int maxOperations = 0;

        for (int i = 0; i < logs.length; i++) {
            String operation = logs[i];
            if (operation.equals("../")) {
                if (maxOperations > 0) {
                    maxOperations--;
                }
            } else if (!operation.equals("./")) {
                maxOperations++;
            }
        }
        return maxOperations;
    }
}
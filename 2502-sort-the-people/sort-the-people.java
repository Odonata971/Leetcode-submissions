class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
         // Bubble sort both arrays simultaneously
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (heights[j] < heights[j + 1]) {
                    // Swap heights
                    int tempHeight = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = tempHeight;
                    
                    // Swap corresponding names
                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;
                }
            }
        }
        
        return names;
    }
}
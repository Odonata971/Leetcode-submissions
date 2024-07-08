class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int index = 0;
        for (char ch : columnTitle.toCharArray()) {
            result *= 26;
            result += (ch - 'A') + 1 ; 
        }
        return result;
    }
}
class Solution {
    public char findTheDifference(String s, String t) {
        char extraChar = 0;
        for (char c : s.toCharArray()) extraChar ^= c;
        for (char c : t.toCharArray()) extraChar ^= c;
        return extraChar;
    }
}
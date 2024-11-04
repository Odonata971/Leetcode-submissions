class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        int count = 1;
        for (int i = 1; i < word.length(); ++i) {
            if (count < 9 && word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                ans.append(count).append(word.charAt(i - 1));
                count = 1;
            }
        }
        ans.append(count).append(word.charAt(word.length() - 1));
        return ans.toString();
    }
}
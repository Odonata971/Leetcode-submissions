class Solution {
    public int possibleStringCount(String word) {
        int possibleSpellings = 0;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                possibleSpellings++;
            }
        }
        //We're adding one in case there is no misspelling
        return possibleSpellings + 1;
    }
}
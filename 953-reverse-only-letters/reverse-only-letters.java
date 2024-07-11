class Solution {
    public String reverseOnlyLetters(String s) {
        int start = 0, end = s.length() - 1;
        char[] reversed = s.toCharArray();

        while (start < end) {
            if (Character.isLetter(reversed[start]) && Character.isLetter(reversed[end])) {
                char temp = reversed[start];
                reversed[start] = reversed[end];
                reversed[end] = temp;
                start++;
                end--;
            } else if (!Character.isLetter(reversed[start])) {
                start++;
            } else {
                end--;
            }
        }
        return new String(reversed);
    }
}
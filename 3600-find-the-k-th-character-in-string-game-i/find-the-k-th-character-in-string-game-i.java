class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");
        int wordLength = 1;
        while (wordLength < k) {
            int addedCharsLength = 0;
            StringBuilder addedChars = new StringBuilder();

            for (char ch : word.toString().toCharArray()) {
                addedChars.append((char) ((ch - 'a' + 1) % 26 + 'a'));
                if (wordLength + ++addedCharsLength >= k) {
                    return (char) ((ch - 'a' + 1) % 26 + 'a');
                }
            }
            wordLength += addedCharsLength;
            word.append(addedChars);
        }
        return 'a';
    }
}
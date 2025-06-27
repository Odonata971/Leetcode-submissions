class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(
                Arrays.asList('a','e','i','o','u','A','E','I','O','U')
        );
        int left = 0, right = s.length() - 1;
        char[] str = s.toCharArray();

        while (left < right) {
            boolean l = vowels.contains(str[left]);
            boolean r = vowels.contains(str[right]);

            if (!l) {
                left++;
            }
            if (!r) {
                right--;
            }
            if (l && r) {
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            }
        }
        return new String(str);
    }
}
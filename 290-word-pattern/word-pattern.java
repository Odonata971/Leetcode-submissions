class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] patternArray = pattern.toCharArray();
        String[] sArray = s.split(" ");
        if (patternArray.length != sArray.length) return false;
        
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> usedWords = new HashSet<>();

        for (int i = 0; i < patternArray.length; i++) {
            char c = patternArray[i];
            String word = sArray[i];

            if (map.containsKey(c)) {
                // Check if the mapping is consistent
                if (!map.get(c).equals(word)) return false;
            } else {
                // Check if word is already used by another character
                if (usedWords.contains(word)) return false;
                map.put(c, word);
                usedWords.add(word);
            }
        }
        return true;
    }
}
class Solution {
    public List<String> commonChars(String[] words) {
        
        List<String> res = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int minCount = Integer.MAX_VALUE;

            for (String s : words) {
                int count = 0;
                for (char c : s.toCharArray()) {
                    if (c == ch) {
                        ++count;
                    }
                }
                minCount = Math.min(minCount, count);
            }

            for (int i = 0; i < minCount; i++) {
                res.add(String.valueOf(ch));
            }
        }
        return res;
    }

    /*
    public List<String> commonChars(String[] words) {
        /*int n = words.length;
        List<HashMap<Character, Integer>> dicts = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> dict = new HashMap<>();
            dicts.add(dict);
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = words[i];
            for (int j = 0; j < s.length(); j++) {
                dicts.get(i).getOrDefault(s.charAt(j), 0) + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int a = 'a';
            for (int j = 0; j < 26; j++) {

            }
        }
        return
    }
    */
}
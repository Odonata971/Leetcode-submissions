class Solution {
    public List<String> commonChars(String[] words) {
        
        // Count characters in the first word
        int[] last = count(words[0]);
        
        // Update the count array by intersecting with each subsequent word
        for (int i = 1; i < words.length; i++) {
            last = intersection(last, count(words[i]));
        }
        
        // Build the result list based on the final count array
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = (char) ('a' + i);
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    arr.add(s);
                    last[i]--;
                }
            }
        }
        return arr;
    }

    // Calculate the intersection of two count arrays
    private int[] intersection(int[] a, int[] b) {
        int[] t = new int[26];
        for (int i = 0; i < 26; i++) {
            t[i] = Math.min(a[i], b[i]);
        }
        return t;
    }

    // Count the frequency of each character in a word
    private int[] count(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray()) {
            t[c - 'a']++;
        }
        return t;
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
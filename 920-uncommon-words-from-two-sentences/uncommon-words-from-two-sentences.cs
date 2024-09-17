public class Solution {
    public string[] UncommonFromSentences(string s1, string s2) {
        Dictionary<string, int> wordCount = new Dictionary<string, int>();

        foreach (string word in s1.Split(" ")) {
            if (wordCount.ContainsKey(word)) {
                wordCount[word]++;
            } else {
                wordCount[word] = 1;
            }
        }

        foreach (string word in s2.Split(" ")) {
            if (wordCount.ContainsKey(word)) {
                wordCount[word]++;
            } else {
                wordCount[word] = 1;
            }
        }

        List<string> result = new List<string>();
        foreach (var entry in wordCount) {
            if (entry.Value == 1) {
                result.Add(entry.Key);
            }
        }

        return result.ToArray();
    }
}
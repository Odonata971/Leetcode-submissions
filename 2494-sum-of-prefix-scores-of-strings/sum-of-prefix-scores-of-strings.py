class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        # Build the trie structure from the list of words
        trie = self.buildTrie(words)
        # Calculate and return the prefix scores for each word
        return self.calculatePrefixScores(trie, words)

    def buildTrie(self, words: List[str]) -> Dict:
        trie = {}
        for word in words:
            node = trie
            for char in word:
                # Navigate through or create nodes in the trie
                node = node.setdefault(char, {})
                # Count occurrences of the prefix
                node['$'] = node.get('$', 0) + 1
        return trie

    def calculatePrefixScores(self, trie: Dict, words: List[str]) -> List[int]:
        scores = []
        for word in words:
            node = trie
            total_score = 0
            for char in word:
                # Move to the next node and accumulate the score
                node = node[char]
                total_score += node['$']
            scores.append(total_score)
        return scores
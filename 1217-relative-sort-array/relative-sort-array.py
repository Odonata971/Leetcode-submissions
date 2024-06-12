class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        freq = [0] * 1001
        for elt in arr1:
            freq[elt] += 1
        
        res = []

        for num in arr2:
            while freq[num] > 0:
                res.append(num)
                freq[num] -= 1
        
        for i in range(len(freq)):
            while freq[i] > 0:
                res.append(i)
                freq[i] -= 1
        return res
class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        final_xor: int = 0
        for x in nums:
            final_xor ^= x

        group0 = 0
        group1 = 0
        bit_pos_dif = 0
        while (final_xor >> bit_pos_dif) & 1 != 1:
            bit_pos_dif += 1
        
        for x in nums:
            if (x >> bit_pos_dif) & 1 == 1:
                group1 ^= x
            else:
                group0 ^= x
        return [group0, group1]




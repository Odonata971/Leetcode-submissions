class Solution:
    def reverse(self, x: int) -> int:
        is_negative: bool = False

        if x < 0:
            is_negative = True
            x *= -1
        
        res: int = 0
        while x > 0:
            res = (res * 10) + (x % 10)
            x //= 10
        
        if res > 2 ** 31 - 1:
            return 0
        
        return res * -1 if is_negative else res
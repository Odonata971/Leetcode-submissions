class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        if len(s) != len(goal):
            return False

        double_str: str = s + s
        interval: int = len(s)

        i: int = 0
        while i + interval < len(double_str):
            if double_str[i : i + interval] == goal:
                return True
            i += 1
        return False
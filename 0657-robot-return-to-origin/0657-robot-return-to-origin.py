class Solution:
    def judgeCircle(self, moves: str) -> bool:
        occurrences = [0, 0]
        for ch in moves :
            match ch:
                case "L":
                    occurrences[0] += 1
                case "R":
                    occurrences[0] -= 1
                case "U":
                    occurrences[1] += 1
                case "D":
                    occurrences[1] -= 1
        return occurrences[0] == 0 and occurrences[1] == 0
            
               
       
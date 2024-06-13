class Solution:
    def minMovesToSeat(self, seats: List[int], students: List[int]) -> int:
        seats = sorted(seats)
        students = sorted(students)
        res : int = 0
        for i in range(len(seats)):
            res += abs(seats[i] - students[i])
        return res
        
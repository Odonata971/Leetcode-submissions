class Solution {
    public int passThePillow(int n, int time) {
        int completedCycles = time / (n - 1);
        int remainder = time % (n - 1);
        return completedCycles % 2 != 0 ? n - remainder : remainder + 1;
    }
}
class Solution {
    public boolean judgeCircle(String moves) {
        int[] occurrences = new int[2];
        for (char ch : moves.toCharArray()) {
            switch (ch) {
                case 'L' -> occurrences[0]++;
                case 'R' -> occurrences[0]--;
                case 'U' -> occurrences[1]++;
                case 'D' -> occurrences[1]--;
            }
        }
        System.out.println(occurrences[0] + ", " + occurrences[1]);
        return occurrences[0] == 0 && occurrences[1] == 0;
    }
}
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1)));

        for (int row = 1; row < numRows; row++) {
            ArrayList<Integer> line = new ArrayList<>();
            line.add(1);
            List<Integer> previousLine = result.get(result.size() - 1);
            for (int num = 1; num < row; num++) {
                line.add(previousLine.get(num - 1) + previousLine.get(num));
            }
            line.add(1);
            result.add(line);
        }
        return result;

    }
}
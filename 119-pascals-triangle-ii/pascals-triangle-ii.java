class Solution {
    /* 
    Algorithme par Brute force (algo + efficace en dessous)

    public List<Integer> getRow(int rowIndex) {
        return generate(rowIndex + 1).get(rowIndex);
    }
    private List<List<Integer>> generate(int numRows) {
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
    }*/


    /* Formule de pascal pour calcul de ligne immédiat*/
    public List<Integer> getRow(int rowIndex) {
        List<Integer> line = new ArrayList<>();
        long num = 1;

        for (int i = 0; i <= rowIndex; i++) {
            line.add((int) num);
            num = num * (rowIndex - i);
            num = num / (i + 1);
        }
        return line;
    }
}
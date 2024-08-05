class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> distincts = new ArrayList<>();
        for (String s : arr) {
            if (map.get(s) == 1) {
                distincts.add(s);
            }
        }
        return distincts.size() < k ? "" : distincts.get(k - 1);
    }
}
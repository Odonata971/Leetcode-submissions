class Solution {
    public String largestNumber(int[] nums) {
        Integer[] boxedArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        
        Arrays.sort(boxedArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String order1 = a.toString() + b.toString();
                String order2 = b.toString() + a.toString();
                return order2.compareTo(order1);
            }
        });
        
        if (boxedArray[0] == 0) {
            return "0";
        }
        
        StringBuilder answer = new StringBuilder();
        for (int num : boxedArray) {
            answer.append(num);
        }
        return answer.toString();
    }
}
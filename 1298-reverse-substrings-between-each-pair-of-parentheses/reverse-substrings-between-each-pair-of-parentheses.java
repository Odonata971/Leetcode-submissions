class Solution {
    public String reverseParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> indexStack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                indexStack.push(result.length());
            } else if (ch == ')') {
                int start = indexStack.pop();
                StringBuilder reversed = new StringBuilder(result.substring(start)).reverse();
                result.replace(start, result.length(), reversed.toString());
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
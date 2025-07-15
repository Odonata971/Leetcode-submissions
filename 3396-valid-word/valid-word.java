class Solution {
    public boolean isValid(String word) {
        return word.matches("(?=.*[aeiouAEIOU])(?=.*[^aeiouAEIOU0-9])[a-zA-Z0-9]{3,}");
    }
}
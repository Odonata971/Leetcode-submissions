class Solution {
    fun isPalindrome(s: String): Boolean {
        val onlyLetters: StringBuilder = StringBuilder()
        val n: Int = s.length
        for (i in 0..n - 1) {
            if (s[i].isLetterOrDigit()) {
                onlyLetters.append(s[i].toLowerCase())
            }
        }
        return onlyLetters.contentEquals(onlyLetters.reversed())
    }
}
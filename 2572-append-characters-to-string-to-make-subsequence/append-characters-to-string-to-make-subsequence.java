class Solution {
    public int appendCharacters(String s, String t) {
        int ps = 0, pt = 0;
        int sL = s.length(), tL = t.length();
        while (ps < sL && pt < tL) {
            if (s.charAt(ps) == t.charAt(pt)) {
                pt++;
            }
            ps++;
        }
        return tL - pt;
    }
}
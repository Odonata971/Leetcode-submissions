class Solution {
    public int countSeniors(String[] details) {
        int oldPassengers = 0;

        for (int i = 0; i < details.length; i++) {
            if (Integer.valueOf(details[i].substring(11,13)) > 60) oldPassengers++;
        }
        return oldPassengers;
    }
}
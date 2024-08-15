class Solution {
    fun lemonadeChange(bills: IntArray): Boolean {
        var five_bills : Int = 0
        var ten_bills : Int = 0
        for (item: Int in bills) {
            
            if (item == 5) {
                five_bills++
            } else if (item == 10) {
                if (five_bills != 0) {
                    five_bills--
                    ten_bills++
                } else {
                    return false
                }
            } else {
                if (five_bills != 0 && ten_bills != 0) {
                    five_bills--
                    ten_bills--
                } else if (five_bills >= 3) {
                    five_bills -= 3
                } else {
                    return false
                }
            }
        }
        return true
    }
}
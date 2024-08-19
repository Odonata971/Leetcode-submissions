class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function minSteps($n) {
        if ($n == 1) return 0;

        $steps = 0;
        $factor = 2;

        while ($n > 1) {
            while ($n % $factor == 0) {
                $steps += $factor;
                $n /= $factor;
            }
            $factor++;
        }
        return $steps;
    }
}
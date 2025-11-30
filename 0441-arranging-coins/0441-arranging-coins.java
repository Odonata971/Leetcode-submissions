class Solution {
    public int arrangeCoins(int n) {
        // Use the formula x * (x + 1) / 2 = n => x² + x = 2n
        // => x² + x - 2n = 0 then solve this polynomial equation 
        // delta = 1 + 8n and positive solution = (-1 + sqrt(1 + 8n)) /2
        // finally, we have to floor by casting to int this result to have the final complete rows number
        return (int)((-1 + Math.sqrt(1 + 8 * (double) n)) / 2);
    }
}
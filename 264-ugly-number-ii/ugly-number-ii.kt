class Solution {
    fun nthUglyNumber(n: Int): Int {
    
       val factor : IntArray  = intArrayOf(2, 3, 5)
       val q: PriorityQueue<Long> = PriorityQueue<Long>()
       val set: MutableSet<Long> = HashSet<Long>();
       q.offer(1)
       set.add(1)
       var ans : Long = 0

       for (i in 1..n) {
            ans = q.poll()
            for (j in factor){
                if(!set.contains(ans * j)) {
                    q.offer(ans * j);
                    set.add(ans * j);
                }
            }
       }
       return ans.toInt();
    }
}
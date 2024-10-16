class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<CharCount> pq = new PriorityQueue<>();
        StringBuilder answer = new StringBuilder();

        if (a > 0) pq.add(new CharCount(a, 'a'));
        if (b > 0) pq.add(new CharCount(b, 'b'));
        if (c > 0) pq.add(new CharCount(c, 'c'));

        while (!pq.isEmpty()) {
            CharCount current = pq.poll();
            int n = answer.length();

            if (n >= 2 && answer.charAt(n - 1) == current.ch && answer.charAt(n - 2) == current.ch) {
                if (pq.isEmpty()) break;
                CharCount next = pq.poll();
                answer.append(next.ch);
                if (--next.count > 0) {
                    pq.offer(next);
                }
                pq.offer(current);
            } else {
                answer.append(current.ch);
                if (--current.count > 0) {
                    pq.offer(current);
                }
            }
        }

        return answer.toString();
    }

    public static class CharCount implements Comparable<CharCount> {
        int count;
        char ch;

        public CharCount(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }

        public int compareTo(CharCount other) {
            return Integer.compare(other.count, this.count);
        }
    }
}
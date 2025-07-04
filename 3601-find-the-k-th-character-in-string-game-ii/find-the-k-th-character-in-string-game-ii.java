class Solution {
    public char kthCharacter(long k, int[] operations) {
        int shift = 0; // total number of +1 (mod 26) operations
        List<Long> lengths = new ArrayList<>();
        long len = 1;

        for (int op : operations) {
            len *= 2;
            lengths.add(len);
            if (len >= k) break;
        }

        for (int i = lengths.size() - 1; i >= 0; i--) {
            long half = lengths.get(i) / 2;
            int op = operations[i];

            if (k > half) {
                k -= half;
                if (op == 1) shift++;
            }
            // else: k remains the same
        }

        // Apply total shift from 'a'
        return (char) ((('a' - 'a' + shift) % 26) + 'a');
    }
}
// First try not using bit manipulation 
//        public char kthCharacter(long k, int[] operations) {
//            StringBuilder word = new StringBuilder("a");
//            for (int operation : operations) {
//
//                if (operation == 0) {
//                    word.append(word);
//                } else {
//                    word.append(operationAddOnePerCharacter(word, k));
//                }
//                if (word.length() >= k) {
//                    //System.out.println(word.substring((int) (k/2), word.length()));
//                    return word.substring((int) (k/2), word.length()).charAt(k % 2 == 1 ? (int) (k/2) : (int) (k/2) - 1);
//                }
//                //System.out.println(word.toString());
//                //System.out.println(word.length());
//            }
//
//            return 'a';
//        }
//
//        private StringBuilder operationAddOnePerCharacter(StringBuilder word, long k) {
//            StringBuilder addedChars = new StringBuilder();
//
//            for (char ch : word.toString().toCharArray()) {
//                addedChars.append((char) ((ch - 'a' + 1) % 26 + 'a'));
//            }
//            return addedChars;
//        }
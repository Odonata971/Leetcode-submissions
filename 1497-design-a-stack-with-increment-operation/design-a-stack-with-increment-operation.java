class CustomStack {
    int[] stack;
    int size, capacity;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        size = 0;
        capacity = maxSize;
    }
    
    public void push(int x) {
        if (isFull()) return;

        stack[size++] = x; 
    }
    
    public int pop() {
        if (isEmpty()) return -1;
        return stack[--size];
    }
    
    public void increment(int k, int val) {
        int limit = Math.min(k, size);

        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
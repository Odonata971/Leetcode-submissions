class MyCalendarTwo {

    private TreeMap<Integer, Integer> events;

    public MyCalendarTwo() {
        events = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // Increment start by +1 (start of booking)
        events.put(start, events.getOrDefault(start, 0) + 1);
        // Decrement end by -1 (end of booking)
        events.put(end, events.getOrDefault(end, 0) - 1);
        
        int activeBookings = 0;
        
        // Sweep through the events in chronological order
        for (int count : events.values()) {
            activeBookings += count;
            
            // If we have 3 or more overlapping bookings, it's a triple booking
            if (activeBookings >= 3) {
                // Revert the changes, as the booking is not valid
                events.put(start, events.get(start) - 1);
                events.put(end, events.get(end) + 1);

                // Remove from map if count reaches zero
                if (events.get(start) == 0) {
                    events.remove(start);
                }
                if (events.get(end) == 0) {
                    events.remove(end);
                }
                
                return false; // Booking failed
            }

            if (events.higherKey(start) != null && events.higherKey(start) > end) {
                break; // No need to check further
            }
        }
        
        // Booking is successful if no triple booking is found
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
public class Event {

	private String name;
	private int capacity;

	// "sold" now means ACTIVE tickets currently sold (used for capacity checks).
	private int sold;

	// Seat numbers should NOT be generated from "sold" if cancellations are
	// allowed.
	// This is the next seat number to assign (monotonically increases).
	private int nextSeatNumber;
	

	private double price;


    public Event(String name, int capacity, double price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.sold = 0;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSold() {
        return sold;
    }

    public double getPrice() {
        return price;
    }

    // ---------
    // Behaviors
    // ---------

    // Returns how many seats are still available.
    public int ticketsRemaining() {
        // TODO: return remaining seats
    	int left = capacity - sold;
    	
        return left; // placeholder so the project runs
    }

    // Returns true if the event has no remaining seats.
    public boolean isFull() {
        // TODO: return true if all tickets are sold
    	if (capacity == sold) {
    		return true;
    	}
    	else {
    	return false;
    	} // placeholder
    }

    // Sells ONE ticket if possible.
    // If successful: increments sold, nextSeatNumber and returns a new EventTicket.
    // If not possible (full): return null.
    public EventTicket sellOneTicket() {
        // TODO: if event is full, return null
    	if(isFull()) {
    		return null;
    	}
        // TODO: otherwise increment sold, generate a NEW unique seat number, and return a new EventTicket
        else {
        	EventTicket theTicket = new EventTicket(name , nextSeatNumber);
    		sold++;
    		nextSeatNumber++;
    		return theTicket;
    		
    	}
        
    }

    // Cancels one ticket (decrements sold).
    // Returns true if cancellation succeeded; false otherwise.
    public boolean cancelOneTicket() {
        // TODO: decrement sold if possible and return true; otherwise return false
    	if(sold >0)  {
    		sold--;
    		return true; 
    	}
        return false;
    }
    
    // Formatted string for printing in "List events"
    @Override
    public String toString() {
        return null;
    }
}

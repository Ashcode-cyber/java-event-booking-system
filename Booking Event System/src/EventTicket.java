public class EventTicket {

	private String eventName;
	private int seatNumber;
	private boolean checkedIn;

	public EventTicket(String eventName, int seatNumber) {
		this.eventName = eventName;
		this.seatNumber = seatNumber;
		this.checkedIn = false;
	}

	public String getEventName() {
		return eventName;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public boolean isCheckedIn() {
		return checkedIn;
	}
	
	

	// ---------------------------
	// Behavior
	// ---------------------------

	// Marks this ticket as checked in.
	// Return true if the check-in happened now.
	// Return false if the ticket was already checked in.
	
	    
	public boolean checkIn() {
		// TODO: if already checked in, return false; else set checkedIn=true and return
		// true
		
		if (checkedIn) {
			return false;
		}
		else {
			checkedIn = true;
			return true;
		}
	}
	
	

	// Formatted string for printing Event Tickets
	@Override
	
	
	public String toString() {
		return null;
	}
}

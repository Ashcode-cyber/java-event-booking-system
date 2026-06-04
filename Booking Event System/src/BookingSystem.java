import java.util.Scanner;

public class BookingSystem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Event[] events = new Event[10];
		int eventCount = 0;

		EventTicket[] tickets = new EventTicket[200];
		int ticketCount = 0;

		// ---------------------------
		// Starter data (feel free to edit names/prices)
		// ---------------------------
		events[eventCount++] = new Event("Concert Night", 5, 25.00);
		events[eventCount++] = new Event("Comedy Show", 8, 18.50);
		events[eventCount++] = new Event("Movie Premiere", 10, 14.00);

		// ----
		// Menu
		// ----
		boolean running = true;
		while (running) {
			printMenu();
			System.out.print("Choose an option (1-6): ");

			int choice;
			if (sc.hasNextInt()) {
				choice = sc.nextInt();
				sc.nextLine(); // consume newline
			} else {
				sc.nextLine(); // discard invalid input
				System.out.println("Invalid menu choice.");
				continue;
			}

			switch (choice) {
			case 1:
				
				listEvents( events, eventCount);
				
				break;

			case 2:
				
				
				System.out.println("enter event number");
				int eventNum=sc.nextInt() ;
				while(eventNum<0 || eventNum>=eventCount ) {
					System.out.println("Invalid input. Try again:");
					eventNum=sc.nextInt() ;
					
				}
				System.out.println("Let's check");
				Event pickedEvent = events[eventNum];
				if ( pickedEvent.isFull()  ) {
					System.out.println("The Event is Full.");
				}else {
					EventTicket ticket= pickedEvent.sellOneTicket();
					tickets[ticketCount++]= ticket;
					System.out.println("Purchase Succesfull.");
					System.out.println("Your ticket: " + ticket + " for event: " + pickedEvent.getName() + 
							" seat number: " + ticket.getSeatNumber() + " price: $" + pickedEvent.getPrice() );
				}
				
				break;

			case 3:
				
				cancelTicket(sc, events, eventCount, tickets);
				
				break;

			case 4:
				
				checkInTicket(sc, events, eventCount, tickets);
				break;

			case 5:
				
				salesSummary(events, eventCount, tickets);
				break;

			case 6:
				running = false;
				System.out.println("Goodbye!");
				break;

			default:
				System.out.println("Invalid menu choice.");
			}

			System.out.println(); // blank line for readability
		}

		sc.close();
	}

	private static int nextLine() {
		// TODO Auto-generated method stub
		return 0;
	}

	private static void printMenu() {
		System.out.println("=== Event Booking Simulator ===");
		System.out.println("1. List events");
		System.out.println("2. Buy ticket");
		System.out.println("3. Cancel ticket");
		System.out.println("4. Check in ticket");
		System.out.println("5. View sales summary");
		System.out.println("6. Exit");
	}

	// -----------------------
	// Optional helper methods
	// -----------------------
	// TODO
	private static void listEvents(Event[] events, int eventCount) {
		for(int i=0; i<= eventCount-1; i++) {
			System.out.println( i + ". " + events[i].getName() + " - Price: $" + events[i].getPrice() + 
					", Capacity: " + events[i].getCapacity() + 
					", Sold: " + events[i].getSold() + 
					", Remaining: " + (events[i].getCapacity() - events[i].getSold()) );
		}

	}

	private static int buyTicket(Scanner sc, Event[] events, int eventCount, EventTicket[] tickets, int ticketCount) {
		return 0;
	}

	private static void cancelTicket(Scanner sc, Event[] events, int eventCount, EventTicket[] tickets) {
		System.out.println("enter event number");
		int eventNum=sc.nextInt() ;
		while(eventNum<0 || eventNum>=eventCount ) {
			System.out.println("Invalid input. Try again:");
			eventNum=sc.nextInt() ;
		}
		System.out.println("enter seat number");
		int seatNum=sc.nextInt() ;
		int ticketIndex= findTicketIndex(tickets, events[eventNum].getName(), seatNum);
		if (ticketIndex==-1) {// not found
			System.out.println("Ticket not found.");
			}else {
				EventTicket ticket = tickets[ticketIndex];
				if (ticket.isCheckedIn()) {
					System.out.println("Cannot cancel. Ticket already checked in.");
				}else {
					// cancel the ticket: update event and tickets array
					tickets[ticketIndex]= null; // remove from tickets array
					events[eventNum].cancelOneTicket(); // update event's sold count
					System.out.println("Ticket cancelled successfully.");
				}
		}

	}

	private static void checkInTicket(Scanner sc, Event[] events, int eventCount, EventTicket[] tickets) {
		
			System.out.println("enter event number");
			int eventNum=sc.nextInt() ;
			while(eventNum<0 || eventNum>=eventCount ) {
				System.out.println("Invalid input. Try again:");
				eventNum=sc.nextInt() ;
			}
			System.out.println("enter seat number");
			int seatNum=sc.nextInt() ;
			int ticketIndex= findTicketIndex(tickets, events[eventNum].getName(), seatNum);
			if (ticketIndex==-1) {// not found
				System.out.println("Ticket not found.");
				}else {
					EventTicket ticket = tickets[ticketIndex];
					if (ticket.isCheckedIn()) {
						System.out.println("Ticket already checked in.");
					}else {
						ticket.checkIn();
						System.out.println("Check-in successful.");
					}
			}
	}

	private static void salesSummary(Event[] events, int eventCount, EventTicket[] tickets) {
			int totalSold = 0;
			double totalRevenue = 0.0;
			int totalCheckedIn = 0;

			for (int i = 0; i < eventCount; i++) {
				totalSold += events[i].getSold();
				totalRevenue += events[i].getSold() * events[i].getPrice();
			}

			for (EventTicket ticket : tickets) {
				if (ticket != null && ticket.isCheckedIn()) {
					totalCheckedIn++;
				}
			}

			System.out.println("Total tickets sold: " + totalSold);
			System.out.println("Total revenue: $" + totalRevenue);
			System.out.println("Total checked in: " + totalCheckedIn);

	}

	private static int findTicketIndex(EventTicket[] tickets, String eventName, int seatNumber) {
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i] != null && tickets[i].getEventName().equals(eventName) && tickets[i].getSeatNumber() == seatNumber) {
				return i;
			}
		}
		return -1; // not found
	}

}

package com.train.booking;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TrainMain {

	public static void main(String[] args) 
	{
		System.out.println("Now Searching For Trains.......");

	TrainService.searchTrainsBetweenStations("Hyderabad", "Bangalore", LocalDate.now(), 10);	
	
	BankAccount b1 = new BankAccount();
	b1.setActNumber(999);
	b1.setActBalance(10000);
	
	Passenger p1 = new Passenger(10,"Ravi",30,b1);
	Passenger p2 = new Passenger(20,"Scott",32,b1);
	Passenger p3 = new Passenger(10,"Smith",33,b1);
	
	int initialBalance = b1.getActBalance();
	List<Passenger> passengerList = new LinkedList<>();
	
	
	passengerList.add(p1);
	passengerList.add(p2);
	passengerList.add(p3);
	
	System.out.println("Now Booking Tickets For 3 Passenger in Train Number 101....");
	
	TrainService.bookTickets(101,passengerList);
	
	System.out.println("Now Printing the Ticket Details......");
		
		TicketService.showTicketDetails(1);
		
		System.out.println("\n\n");
		TrainService.searchTrainsBetweenStations("Hyderabad", "Bangalore", LocalDate.now(), 10);	
		
		int balanceAfterBookingTickets = b1.getActBalance();
		
		System.out.println("Intial Balance = " +initialBalance);
		System.out.println("Balance After Booking ="+ balanceAfterBookingTickets );
		
	}

}

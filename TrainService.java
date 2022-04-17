package com.train.booking;
import java.util.List;
import java.time.LocalDate;
import java.util.LinkedList;

//creating service class to provide various method such as finding train bet 2 specific station etc.

public class TrainService {

//store the train details inside the linked list
private static List<Train> allTrains = new LinkedList<>();
static
{
//add the train detail to allTrains
allTrains.add(new Train(101,"Train-One","Hyderabad","Bangalore",100,800,LocalDate.now()));
allTrains.add(new Train(102,"Train-Two","Bangalore","Hyderabad",100,800,LocalDate.now()));
allTrains.add(new Train(103,"Train-Three","Hyderabad","Bangalore",80,600,LocalDate.now()));
allTrains.add(new Train(104,"Train-Four","Bangalore","Hyderabad",80,600,LocalDate.now()));
allTrains.add(new Train(105,"Train-Five","Hyderabad","Chennai",100,900,LocalDate.now()));
allTrains.add(new Train(106,"Train-Six","Chennai","Hyderabad",100,900,LocalDate.now()));
}
//create a constructor
public TrainService() {
super();
// TODO Auto-generated constructor stub
}

public static Train findTrain(int trainNumber)
{
Train temp = null;
for(Train t : allTrains) {
if(t.getTrainNumber()==trainNumber)
{
temp = t;
break;
}
}
return temp;
}
public static void searchTrainsBetweenStations(String fromStation,String toStation,LocalDate doj,int numOfSeats) {

List<Train> searchTrainList = new LinkedList<>();

for(Train t : allTrains) {
if(t.getFromStation().equals(fromStation) &&
t.getToStation().equals(toStation) &&
t.getDoj().equals(doj) &&
t.getSeatAvailability() > numOfSeats) {
searchTrainList.add(t);
}
}

if(searchTrainList.size()==0) {
System.out.println("Sorry,no matching train available for the search criteria...");
}
else {
System.out.println("Tr.No\tTrain Name\tFrom Station\tTo Station\tDOJ\tSeats Availabitity\tFare");
System.out.println();
for(Train t : searchTrainList ) {
System.out.printf("%4d%20s%15s%15s%12s%4d%5d\n",t.getTrainNumber(),t.getTrainName(),t.getFromStation(),t.getToStation(),t.getDoj(),t.getSeatAvailability(),t.getFare());
}
}
}

public static void bookTickets(int trainNumber, List<Passenger> passengerList) {

// step 1: we need to subtract the train fare for all passengers together from the bank account object.

int numOfSeats = passengerList.size();
/*Passenger tempPassenger = passengerList.get(0);
BankAccount account = tempPassenger.getBankAccount();*/

BankAccount account = passengerList.get(0).getBankAccount();
Train tempTrain = findTrain(trainNumber);
int fare = tempTrain.getFare();
int totalFare = fare * numOfSeats;
account.withdraw(totalFare);

//step 2: we need to substract the number of seats that are being booked,from the actual available no of seats
tempTrain.setSeatAvailability(tempTrain.getSeatAvailability()-numOfSeats);

//setp 3: we need to add one entry(one record) into ticket collection

TicketService.addNewTicket(trainNumber,passengerList);


}




}
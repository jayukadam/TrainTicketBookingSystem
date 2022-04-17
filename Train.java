package com.train.booking;
import java.time.LocalDate;

public class Train
{
//Variable Declaration

    private int trainNumber;
    private String trainName;
    private String fromStation;
    private String toStation;
    private int seatAvailability;
    private int fare;
    private  LocalDate doj; //LocalDate.now provide the system date

   //Creating constructor
    public Train() {
super();
// TODO Auto-generated constructor stub
}
public Train(int trainNumber, String trainName, String fromStation, String toStation, int seatAvailability,
int fare, LocalDate doj) {
super();
this.trainNumber = trainNumber;
this.trainName = trainName;
this.fromStation = fromStation;
this.toStation = toStation;
this.seatAvailability = seatAvailability;
this.fare = fare;
this.doj = doj;
}

//creating getters and setters
public int getTrainNumber() {
return trainNumber;
}
public String getTrainName() {
return trainName;
}
public String getFromStation() {
return fromStation;
}
public String getToStation() {
return toStation;
}
public int getSeatAvailability() {
return seatAvailability;
}
public int getFare() {
return fare;
}
public LocalDate getDoj() {
return doj;
}
public void setSeatAvailability(int i) {
// TODO Auto-generated method stub

}

   
   
   
}




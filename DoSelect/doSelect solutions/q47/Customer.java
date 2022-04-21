package q47;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	String name;
    int numberOfRooms;
	public Customer(String name, int numberOfRooms) {
		super();
		this.name = name;
		this.numberOfRooms = numberOfRooms;
	}
	public String getName() {
		return name;
	}
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
    public static void main(String[] args) {
    	Customer cust=new Customer("Doselect", 4);
    	Hotel hotel=new Hotel();
    	System.out.println(hotel.checkIn(cust));
    	System.out.println(hotel.checkRooms(cust));

	}
}
class Hotel{
	List<String> customerName=new ArrayList<>();
    int roomsBooked = 0;
    public String checkIn(Customer customer) {
    	if(roomsBooked+customer.numberOfRooms<=10) {
    		roomsBooked+=customer.numberOfRooms;
    		return "Checked in";
    	}
		return "No rooms available";
    	
    }
    public String checkRooms(Customer customer) {
    	if(roomsBooked+customer.numberOfRooms<=10) {
    		return "Yes";
    	}
		return "No";    	
    }
}
package q21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Car {
	public int carId;
	public int speed;
	
	public Car(int carId,int speed) {
		this.carId=carId;
		this.speed=speed;
	}
	public int getCarId() {
		return carId;
	}
	public int getSpeed() {
		return speed;
	}
	public static void main(String[] args) {
    	Car car = new Car(1,80);
    	Car car1 = new Car(2,80);
    	Car car2 = new Car(3,100);
    	Car car3 = new Car(4,100);
    	CarRacing carRacing = new CarRacing(4);
    	System.out.println(carRacing.carEntry(car));
    	System.out.println(carRacing.carEntry(car1));
    	System.out.println(carRacing.carEntry(car2));
    	System.out.println(carRacing.carEntry(car3));
    	System.out.println(carRacing.getWinner(1000));

    }
}
class CarRacing{
	public ArrayList<Car> cars=new ArrayList<>();
    public int trackCount;
	public CarRacing(int trackCount) {
		this.trackCount = trackCount;
	}
	public String carEntry(Car car) {
		for(int i=0;i<cars.size();i++) {
			if(cars.get(i).getCarId()==car.getCarId())
				return "Already exists";
		}			
		if(trackCount>cars.size()) {
			cars.add(car);
			return "Start practicing";
		}
		if(trackCount==cars.size())
			return "No Space";
		
		return "";
	}
    public int getWinner(int trackLength) {
    	if(cars.size()==0)
    		return -1;
		Collections.sort(cars, Comparator.comparing(Car::getSpeed));
		for(int i=0;i<cars.size()-1;i++) {
			if(cars.get(i).getSpeed()==cars.get(cars.size()-1).getSpeed())
				return cars.get(i).getCarId();
		}
		return cars.get(cars.size()-1).getCarId();
    }
    
}

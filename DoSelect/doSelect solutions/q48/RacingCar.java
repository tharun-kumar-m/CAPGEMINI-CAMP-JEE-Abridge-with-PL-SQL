package q48;

public class RacingCar {
	public int speed;
	public int distance;
	public int petrolRate;
	public RacingCar(int speed, int distance, int petrolRate) {
		super();
		this.speed = speed;
		this.distance = distance;
		this.petrolRate = petrolRate;
	}
	public int validateCar(int time) throws Exception{
		if(Math.ceil(distance/speed)>time)
			throw new LowSpeedException("Upgrade Car");
		if(Math.ceil(distance/speed)<time)
			throw new LowSpeedException("Accident Chances");
		return calculateprice();
	}
	public int calculateprice(){
		return (int) Math.ceil(distance/petrolRate);
	}
	public static void main(String[] args) throws Exception {
		RacingCar car = new RacingCar(100,1000,11);
		System.out.println(car.validateCar(50));
	}
}
@SuppressWarnings("serial")
class LowSpeedException extends Exception{
	public LowSpeedException(String msg) {
		super(msg);
	}
}
@SuppressWarnings("serial")
class HighSpeedException extends Exception{
	public HighSpeedException(String msg) {
		super(msg);
	}
}

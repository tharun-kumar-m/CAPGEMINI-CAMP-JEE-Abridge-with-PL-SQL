package q42;

public class Laptop {
	int price;
	String details;

	public Laptop(String details,int price) {
		this.price = price;
		this.details = details;
	}
	public int getPrice() {
		return price;
	}
	public String getDetails() {
		return details;
	}
	public static void main(String[] args) {
		Laptop laptop=new Laptop("8/512/SSD",58000);
		Afford af=new Afford(); 
		String s;
		try {
			s = af.checkConfiguration(laptop);
		} catch (Exception e) {
			s=e.getMessage();
		}
		String t;
		try {
			t = af.purchaseLaptop(laptop);
		} catch (Exception e) {
			t=e.getMessage();
		}
		System.out.println(s.toLowerCase());
		System.out.println(t.toLowerCase());

	}

}

class Afford {
	public String checkConfiguration(Laptop laptop) throws Exception{
		if(laptop.getPrice()>70000) {
			throw new LaptopException("Price is too high");
		}
		
		String[] spec=laptop.getDetails().split("/");
		if(Integer.valueOf(spec[0])<8) {
			throw new LaptopException("Minimum 8 RAM required");
		}
		if(Integer.valueOf(spec[1])<256) {
			throw new LaptopException("Minimum 256 space required");
		}
		if(spec[2].equals("HDD")) {
			throw new LaptopException("SSD required");
		}
		return "Can be purchased";
	}
	
	public String purchaseLaptop(Laptop laptop) throws Exception{
		try {
			checkConfiguration(laptop);
		}
		catch(LaptopException e) {
			return "Change configuration";
		}
		catch(Exception e) {
			return "other Exception";
		}
		return "Perfect configuration";
	}
}
@SuppressWarnings("serial")
class LaptopException extends Exception{
	public LaptopException(String msg) {
		super(msg);
	}
}
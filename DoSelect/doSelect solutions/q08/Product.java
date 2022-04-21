package q08;

public class Product {
	public String name;
	public double price;
	public String coupon;
	Product(String name,double price,String coupon){
		this.name=name;
		this.price=price;
		this.coupon=coupon;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getCoupon() {
		return coupon;
	}
	
	public static void main(String[] args) throws Exception  {
		Product obj = new Product("IPhone",25000,"IPhone-10");
		Validator val = new Validator();
		String valCop = val.validateCoupon(obj);
		double price = val.netPrice(obj);

		System.out.println(valCop);
		System.out.println(price);
		
		/*try {
			Product obj = new Product("IPhone",25000,"IPhone-10");
			Validator val = new Validator();
			System.out.println(val.validateCoupon(obj));
			System.out.println(val.netPrice(obj));
		}
		catch(InvalidCouponException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}*/
	}
}

class Validator {
	
	public String validateCoupon(Product p) throws Exception {
		
	if(p.getCoupon().contains("-")){
		
		String[] s=p.getCoupon().split("-");
		int discountPriceInt=Integer.valueOf(s[1]);	
		if(discountPriceInt<10 || discountPriceInt>25)
			throw new InvalidCouponException("Invalid Coupon");
		
		if(!(s[0].equals(p.getName())))
			throw new InvalidCouponException("Invalid Coupon");
		
		return "Valid Coupon";
	}
	else 
		throw new InvalidCouponException("Invalid Coupon");
	}
	
	public double netPrice(Product p) {
		String[] s=p.getCoupon().split("-");
		try{
			validateCoupon(p);
		} 
		catch(InvalidCouponException e) {
			return p.getPrice();
		} 
		catch (Exception e) {
			return p.getPrice();
		}
		double price=p.getPrice();
		int discountPriceInt=Integer.valueOf(s[1]);
		double discountPrice=(price*discountPriceInt)/100;
		return price-discountPrice;
		
		
	}
}
@SuppressWarnings("serial")
class InvalidCouponException extends Exception{
	public InvalidCouponException(String msg) {
		super(msg);
	}
}


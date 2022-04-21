package q09;
import java.util.regex.*;

public class Customer {
	public String name;
	public String mobileNo;
	public String cId;
	public Customer(String name,String mobileNo,String cId) {
		this.name=name;
		this.mobileNo=mobileNo;
		this.cId=cId;
	}
	public String getName() {
		return name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public String getCId() {
		return cId;
	}
	public static void main(String[] args) throws Exception {
		Customer obj = new Customer("Steve","9898111111","9898ve"); 
		Validator val = new Validator();
		String CID = val.validateCId(obj);
		String mob = val.validateMobileNo(obj);
		System.out.println(CID);
		System.out.println(mob);

	}
}

class Validator {
	public String validateCId(Customer c) throws Exception {
		String cId=c.getCId();
		String name=c.getName();
		if(cId.substring(cId.length()-2,cId.length()).equals(name.substring(name.length()-2,name.length()))
				&& cId.length()==6 && c.getMobileNo().substring(0,4).equals(cId.substring(0,4)))
			
			return "Valid CId";
		else
			throw new InvalidCIdException("Invalid CId");
		
	}
	
	public String validateMobileNo(Customer c) throws Exception {
		
		Pattern.compile("^[9876]").matcher(c.getMobileNo());
		if(Pattern.compile("^[9876]").matcher(c.getMobileNo()).find() && c.getMobileNo().length()==10)
			
			return "Valid MobileNo";
		else
			throw new InvalidMobileNoException("Invalid MobileNo");
	}
}
@SuppressWarnings("serial")
class InvalidCIdException extends Exception{
	public InvalidCIdException(String str){
		super(str);
	}
}
@SuppressWarnings("serial")
class InvalidMobileNoException extends Exception{
	public InvalidMobileNoException(String str){
		super(str);
	}

}

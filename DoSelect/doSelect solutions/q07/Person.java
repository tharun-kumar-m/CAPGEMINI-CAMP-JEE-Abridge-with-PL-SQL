package q07;

import java.text.SimpleDateFormat;

public class Person {
	public String name;
	public String dateOfBirth;
	public String email;
	
	public Person(String name,String dateOfBirth,String email) {
		this.name=name;
		this.dateOfBirth=dateOfBirth;
		this.email=email;
	}
		public String getName() {
			return name;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public String getEmail() {
			return email;
		}
	
	public static void main(String[] args) throws Exception {
		Person data = new Person("Steve", "12-02-1998", "Steve12@doselect.com");
		Implementation obj = new Implementation();
		
		/*try {
		System.out.println(obj.validator(data));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
		System.out.println(obj.submitDetails(data));
		}*/
		
		String a=obj.validator(data);
		String b=obj.submitDetails(data);
		System.out.println(a+"\n"+b);

	}
}

class Implementation {
	public String validator(Person p) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		
		try {
		sdf.parse(p.getDateOfBirth());
		} 
		
		catch (Exception e) {
			throw new InvalidDateException("Invalid date format");
		}
		
		String[] dob=p.getDateOfBirth().split("-");
		if(Integer.valueOf(dob[2])>2000)
			throw new InvalidDateException("date year must be less than 2000");
		
			
		String domain=p.getEmail().substring(p.getEmail().length()-13,p.getEmail().length());
		if(!domain.equals("@doselect.com"))
			throw new InvalidEmailException("only @doselect.com domain email are accepted");

		return "valid details"; 
	}
	
	public String submitDetails(Person p) {
		try {
			validator(p);
		}
		catch(InvalidDateException | InvalidEmailException e) {
			return "invalid details";
		}
		catch (Exception e) {
			return "other exception";
		}
		return "details submitted successfully";
	}
}
class InvalidDateException extends Exception{
	
	private static final long serialVersionUID = 1180670468593134066L;

	public InvalidDateException(String str) {
		super(str);
	}
}
class InvalidEmailException extends Exception{
	
	private static final long serialVersionUID = 5607077752146178021L;

	public InvalidEmailException(String str) {
		super(str);
	}
}


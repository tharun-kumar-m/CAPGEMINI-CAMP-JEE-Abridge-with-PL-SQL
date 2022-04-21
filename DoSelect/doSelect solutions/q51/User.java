package q51;

public class User {
	private String name;
	private String city;
	private String state;
	private String pincode;
	private String dob;
	public User(String name, String city, String state, String pincode, String dob) {
		this.name = name;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public static void main(String[] args) {
		User user = new User("doselect","d","delhi","400001","22/04/2002");
		EmployeeID employeeID = new EmployeeID(user);
		System.out.println(employeeID.generateId());
	}
}
class EmployeeID{
	public User user;

	public EmployeeID(User user) {
		this.user = user;
	}
	public String generateId() {
		
		if(!pincodeValidator())
			return "NA";
		if(pincodeValidator() && dobValidator()) {
			String tempId="";
			tempId+=user.getName().substring(0, 3);
			tempId+=user.getCity().substring(0,1);
			tempId+=user.getState().substring(0,1);
			tempId+=user.getDob().substring(0,2);
			return tempId;
		}
		if(pincodeValidator()) {
			if(!dobValidator()) {
				String tempId="";
				tempId+=user.getName().substring(0, 3);
				tempId+=user.getCity().substring(0,1);
				tempId+=user.getState().substring(0,1);
				return tempId;
			}
		}
		return "";
	}
	public boolean pincodeValidator() {
		String tempPincode=user.getPincode();
		if(tempPincode.length()==6) {
			for(int i=0;i<6;i++) {
				if(!Character.isDigit(tempPincode.charAt(i)))
					return false;
			}
		}
			return true;
	}
	public boolean dobValidator() {
		String tempDob=user.getDob();
		int n=tempDob.length();
		int count=0;
		int digCount=0;
		for (int i=0; i<n; i++){
            if (tempDob.charAt(i) =='/')
            count++;
            if (Character.isDigit(tempDob.charAt(i)))
                digCount++;
        }
		if(user.getDob().length()==10 && count==2 && digCount==8)
			return true;
		return false;
	}
}
package q45;

public class Customer {
	String name;
	long mobile;
	char key;
	public Customer(String name, long mobile, char key) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public long getMobile() {
		return mobile;
	}
	public char getKey() {
		return key;
	}
	public String encrypt() {
		if(name.contains(""+key))
			return "Already Encrypted";
		String newName=""+name;
		int firstDigit = Integer.parseInt(String.valueOf(mobile).substring(0,1)); 
		for(int i=0;i<firstDigit;i++)
			newName=newName+key;	
		return newName;
	}
	public long minCount() {
		long num = mobile;
	    long reminder, smallest=num%10;
	    while (num>0){
	        reminder=num%10;
	        if(smallest>reminder) 
	            smallest= reminder;
	        num = num / 10;
	    }
		return smallest;
	}
	public static void main(String[] args) {
		Customer customer = new Customer("Doselect", 299999992, '#');
		System.out.println(customer.encrypt());
		System.out.println(customer.minCount());
	}
}
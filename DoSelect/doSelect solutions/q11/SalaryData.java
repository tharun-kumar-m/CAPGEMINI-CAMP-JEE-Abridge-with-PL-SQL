package q11;

public class SalaryData {
	public String name;
	public int daysInMonth;
	public double salary;
	public SalaryData(String name, int daysInMonth, double salary) {
		super();
		this.name = name;
		this.daysInMonth = daysInMonth;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public int getDaysInMonth() {
		return daysInMonth;
	}
	public double getSalary() {
		return salary;
	}
	public static void main(String[] args) throws Exception {
		SalaryData s=new SalaryData("Steve",30,10000);
		Validator val = new Validator();
		String ans = val.ValidSalaryData(s);
		double sal=val.totalSalary(s);
		System.out.println(ans+"\n"+sal);

	}
	

}
class Validator {
	
	public String ValidSalaryData(SalaryData s) throws Exception{
		if(s.getDaysInMonth()!=28 && s.getDaysInMonth()!=30 && s.getDaysInMonth()!=31)
			throw new InvalidDaysException("Invalid Days");
		
		if(s.getSalary()<0 || s.getSalary()>1000000)
			throw new InvalidSalaryException("Invalid Salary");
		
		return "Valid Data";
	}
		
	public double totalSalary(SalaryData s) {
		
		try {
			ValidSalaryData(s); 
			return s.getSalary()*s.getDaysInMonth();
		}
		
		catch (Exception e) {
			return 0.0;
		}
	}
	
}

@SuppressWarnings("serial")
class InvalidDaysException extends Exception{
	public InvalidDaysException(String str) {
		super(str);
	}
}
@SuppressWarnings("serial")
class InvalidSalaryException extends Exception{
	public InvalidSalaryException(String str) {
		super(str);
	}
}

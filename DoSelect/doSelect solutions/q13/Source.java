package q13;

public class Source {

	public String handleException(Activity a) throws Exception {
		try {
			int l1=a.getString1().length();
			int l2=a.getString2().length();
			if(l1==0 || l2==0) {
				throw new NullPointerException("Null values found");
			}
			
		}catch(NullPointerException e) {
			return e.getMessage();
		}
		
		try {
			if(!(a.getOperator().equals("+")) && !(a.getOperator().equals("-"))) 
				throw new Exception(a.getOperator());
		}
		catch(Exception e) {
			return e.getMessage();
		}
		return "No exception found";
	}
	
	public String operate(Activity a) {
		
		switch(a.getOperator()) {
		case "+":
			return a.getString1()+a.getString2();
			
		case "-":
			return a.getString1().replaceAll(a.getString2(), " ").trim();
			
		default:
			return "";
			
		}
		
	}
	public static void main(String[] args) throws Exception {
			
		Activity act=new Activity("Helloworld","world","-");
		Source s=new Source();
			
		System.out.println(s.handleException(act));
		System.out.println(s.operate(act));
	
		}

}

class Activity {
	String string1;
	String string2;
	String operator;

	public Activity(String string1, String string2, String operator) {
		this.string1 = string1;
		this.string2 = string2;
		this.operator = operator;
	}

	public String getString1() {
		return string1;
	}

	public String getString2() {
		return string2;
	}

	public String getOperator() {
		return operator;
	}

}
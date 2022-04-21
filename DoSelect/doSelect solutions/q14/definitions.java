package q14;

 class definitions {
	 public definitions() {
	}
	public definitions(double d, double e, char c) {
	}

	public String checkExceptions(double n1, double n2, char op) throws Exception{
		try {
			if(op == '*' && (n1 == 0 || n2==0))
				throw new MultiplyByZeroException("Multiplication with zero results in zero");
			if(op =='/' && n2 ==0)
				throw new DivideByZeroException("Division by zero results in infinity");
			else if(op != '+' && op != '-' && op != '*' && op != '/' )
				System.out.println(op + " is not a valid operator");
			else
				return "No Exception found";
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "";
	}
	
	public String calculate(double v1, double v2, char op) throws Exception{
		
		double res =0.0;
		
			String str = checkExceptions(v1,v2,op);
			if(str.equals("No Exception found"))
				System.out.println("No Exception found");
			
		if(op == '+') {
			 res = v1+v2;
			System.out.println(res);
		}
		else if(op == '-') {
			res = v1-v2;
			System.out.println(res);
		}
		else if(op == '*') {
			res = v1*v2;
			System.out.println(res);
		}
		else if(op == '/') {
			res = v1 / v2;
			System.out.println(res);
		}
		return "";
		
	}
	public static void main(String[] args)throws Exception {
		definitions def = new definitions();
		def.calculate(10, 12,',');
		def.calculate(10,12, '+');
		def.checkExceptions(1,0, '/');
	}
}

@SuppressWarnings("serial")
class MultiplyByZeroException extends Exception {
	public MultiplyByZeroException(String str) {
		super(str);
	}
}

@SuppressWarnings("serial")
class DivideByZeroException extends Exception {

	public DivideByZeroException(String str) {
		super(str);
	}
}
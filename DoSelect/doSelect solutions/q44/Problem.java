package q44;

public class Problem {
	int credits;
    String type;
	public Problem(int credits, String type) {
		super();
		this.credits = credits;
		this.type = type;
	}
	public int getCredits() {
		return credits;
	}
	public String getType() {
		return type;
	}
	public static void main(String[] args) throws Exception {
		Problem p=new Problem(41,"Exception");
		Checker c=new Checker();
		String s = c.checkProblem(p);
		String t=c.approveProblem(p);
		System.out.println(s+"\n"+t);
	}
}
class Checker{
	public String checkProblem(Problem p) throws Exception{
		if(p.getCredits()<10)
			return "Insufficient credits";
		if(p.getType().equals("String"))
			return "String problem found";
		if(p.getType().equals("Generic"))
			return "Generic problem found";
		if(p.getType().equals("I/O"))
			return "I/O problem found";
		return "Exception problem found";
		
	}
	public String approveProblem(Problem p) throws Exception{
		try {
			checkProblem(p);
		}
		catch(ProblemException e) {
			return "Not approved";
		}
		catch(Exception e) {
			return "Other exception";
		}
		return "Problem approved";
	}
}
@SuppressWarnings("serial")
class ProblemException extends Exception{
	public ProblemException(String msg) {
		super(msg);
	}
}
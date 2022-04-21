package q03;

public class Problem {
	public int credits;
    public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String type;
    
    public Problem (int credits, String type) {
    	this.credits=credits;
    	this.type=type;
    }
    public static void main(String[] args) throws Exception {
    	Problem p=new Problem(41,"Exception");
    	Checker c=new Checker();
    	String s = c.checkProblem(p);
    	String t=c.approveProblem(p);
        System.out.println(s+"\n"+t);
	}
}
class Checker {
	public String checkProblem(Problem p) throws Exception{
		if(p.getCredits()<10)
			throw new ProblemException("Insufficient credits");
		if(p.getType().equals("String"))
			throw new ProblemException("String problem found");
		if(p.getType().equals("Generic"))
			throw new ProblemException("Generic problem found");
		if(p.getType().equals("I/O"))
			throw new ProblemException("I/O problem found");
		else
			return "Exception problem found";
	}
	public String approveProblem(Problem p) {
		try{
			checkProblem(p);
		}
		catch (ProblemException e){
			return "Not approved";
		} 
		catch (Exception e) {
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
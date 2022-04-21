package q10;

public class Student {
	public String name;
	public int[] score;
	public String status;
	
	
	public void setStatus(String status) {
		this.status = status;
	}

	public Student(String name, int[] score){
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public int[] getScore() {
		return score;
	}
	public String getStatus() {
		return status;
	}
	
	public static void main(String[] args) throws Exception{
		
		/*int score[] = {50,40,80,67,69};
		Student s = new Student("Aman",score);
		Validator val = new Validator();
		try {
			System.out.println("ans = " + val.validateScore(s));
		}
		catch(Exception e){
			System.out.println("ans = " + e.getMessage());
		}
	
		finally{
			System.out.println("per = " +val.getPercentage(s));
		}*/
		
		int score[]= {50,40,80,67,69};
		Student s=new Student("Aman",score);
		Validator val=new Validator();
		String ans=val.validateScore(s);
		double per=val.getPercentage(s);
		System.out.println(ans);
		System.out.println(per);

	}

}
class Validator {

	public String validateScore(Student s) throws Exception{
		int[] score = s.getScore();
		int l=score.length;
		
		for(int i=0;i<l;i++) {
		if(score[i] <= 0 || score[i] >= 100 )
			throw new InvalidScoreException("Invalid score");
		}
		return "Valid score";
		
	}

	public double getPercentage(Student s){
		 
		int[] score = s.getScore();
		int l=score.length;
		double sum = 0;
		for(int i=0;i<l;i++)
			sum+=score[i];
	     double percentage = sum / score.length;
	     if(percentage>=33)
				s.setStatus("pass");
			else
				s.setStatus("fail");
		try {
			validateScore(s);
		}
		catch(InvalidScoreException e) {
			return 0.0;
		} catch (Exception e) {
			return 0.0;
		}
		
		return percentage;
		
	} 
}
@SuppressWarnings("serial")
class InvalidScoreException extends Exception {
	 public InvalidScoreException(String str) {
		 super(str);
	 }
}

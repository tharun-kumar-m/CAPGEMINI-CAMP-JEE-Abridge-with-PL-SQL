package q59;

import java.util.ArrayList;

public class Student {
	public String name;
	public String branch;
	public int age;
	public int score;
	
	public Student(String name, String branch, int age, int score) {
		super();
		this.name = name;
		this.branch = branch;
		this.age = age;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public static void main(String[] args) {
		Student s1=new Student("Elizabeth Saltzman","CSE",23,24);
		Company c1=new Company("Doselect","CSE",false,23);
		Company c2=new Company("Doselect","ECE",false,22);
		Company c3=new Company("Doselect1","CSE",false,22);
		Company c4=new Company("Doselect2","CSE",false,22);

		Recruitment rec=new Recruitment();
		System.out.println(rec.addStudent("Elizabeth Saltzman","CSE",23,24));
		System.out.println(rec.addStudent("Josette Saltzman","CSE",23,24));
		System.out.println(rec.addCompany(c1));
		System.out.println(rec.addCompany(c2));
		System.out.println(rec.addCompany(c3));
		System.out.println(rec.addCompany(c4));
		System.out.println(rec.eligibleCompanies(s1));
		System.out.println(rec.passedOnlineTest(23));
		System.out.println(rec.laggingScores(21, c3));

		


	}
}
class Company{
	public String name;
	public String type;
	public boolean drive;
    public int cutoff;
	public Company(String name, String type, boolean drive, int cutoff) {
		super();
		this.name = name;
		this.type = type;
		this.drive = drive;
		this.cutoff = cutoff;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isDrive() {
		return drive;
	}
	public void setDrive(boolean drive) {
		this.drive = drive;
	}
	public int getCutoff() {
		return cutoff;
	}
	public void setCutoff(int cutoff) {
		this.cutoff = cutoff;
	}
}
class Recruitment{
	public ArrayList<Company>companies=new ArrayList<>();
    public Student student = null;
    public String addStudent(String name, String branch, int age, int score) {
		char [] tempName=name.toCharArray();
		int n=tempName.length;
		for(int i=0;i<n-1;i++) {
			if(tempName[i]==' ' && tempName[i+1]==' ')
				return "Invalid name";
		}
		if(!(branch.equals("CSE")||branch.equals("IT")||branch.equals("ME")||branch.equals("CE")||branch.equals("EEE")||branch.equals("ECE")))
			return "Invalid branch";
		student=new Student(name.strip(),branch,age,score);
    	return "Student added";
    }
    public String addCompany(Company company) {
    	for(Company c:companies) {
    		if(c.getName().equals(company.getName())) {
        		if(company.drive==true)
        			return "Already Recruited";
        		c.setCutoff(company.getCutoff());
        		c.setType(company.getType());
        		return "Details modified";
        	}
    	}
    	companies.add(company);
		return "Recruiting";
    }
    public String eligibleCompanies(Student student) {
    	String tempCompanies="";
    	for(Company c:companies) {
    		if(c.getType().equals(student.getBranch()))
    			tempCompanies=tempCompanies+c.getName()+" ";
    	}
    	if(tempCompanies!="") {
    		tempCompanies=tempCompanies.strip().replace(" ",",");
    		return tempCompanies;
    	}
		return "Not eligible in any company";
    }
    public int passedOnlineTest(int score) {
    	int count=0;
    	for(Company c:companies) {
    		if(c.getCutoff()<student.getScore())
    			count++;
    	}
    	return count;
    }
    public int laggingScores(int value,Company c) {
    	return c.getCutoff()-value;
    }
}
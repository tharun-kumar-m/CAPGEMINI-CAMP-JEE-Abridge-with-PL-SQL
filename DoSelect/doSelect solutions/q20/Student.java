package q20;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
	String stu_name;
	public String getStu_name() {
		return stu_name;
	}
	public int getScore() {
		return score;
	}
	int score;
	public Student(String stu_name, int score){
		this.stu_name=stu_name;
		this.score=score;
	}
	public static void main(String[] args) {
		Merit obj = new Merit();
		Student s1=new Student("s1",100);
		System.out.println(obj.newEntry(s1,"IIT BOMBAY"));
		Student s2=new Student("s2",100);
		System.out.println(obj.newEntry(s2,"IIT BOMBAY"));
		Student s3=new Student("s2",100);
		System.out.println(obj.newEntry(s3,"IIT BOMBAY"));
		System.out.println(obj.getStudents("IIT BOMBAY"));
	}
}
class Merit{
	HashMap<String, ArrayList<Student>> mlist= new HashMap<>();
	ArrayList<Student> students =new ArrayList<>();
	public String newEntry(Student s, String university) {
		students.add(s);
		if(mlist.containsKey(university)) {
			
			mlist.put(university,students);
			return "Student added";
		}
		mlist.put(university, students);
		return "University added";
	}
	public ArrayList<String> getStudents(String university) {
		ArrayList<String> arr=new ArrayList<>();
		ArrayList<Student> stu1=new ArrayList<>();

		if(mlist.containsKey(university)) {
			stu1=mlist.get(university);
			int l=stu1.size();
			for(int i=0;i<l;i++) 
				arr.add(stu1.get(i).getStu_name());
			
			return arr;
		}
		else
			return null;
	}
}
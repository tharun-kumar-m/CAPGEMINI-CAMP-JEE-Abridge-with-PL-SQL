package q57;

import java.util.ArrayList;
import java.util.List;

public class Lecturer {
	private String lecturerFirstName;
	private String lecturerLastName;
	private int salary;
	public Lecturer(String lecturerFirstName, String lecturerLastName, int salary) {
		super();
		this.lecturerFirstName = lecturerFirstName;
		this.lecturerLastName = lecturerLastName;
		this.salary = salary;
	}
	public String getLecturerFirstName() {
		return lecturerFirstName;
	}
	public void setLecturerFirstName(String lecturerFirstName) {
		this.lecturerFirstName = lecturerFirstName;
	}
	public String getLecturerLastName() {
		return lecturerLastName;
	}
	public void setLecturerLastName(String lecturerLastName) {
		this.lecturerLastName = lecturerLastName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public static void main(String[] args) {
		Implementation i = new Implementation();
		List<Lecturer> list = new ArrayList<Lecturer>();
		list.add(new Lecturer("Alan", "D'costa", 500000));
		list.add(new Lecturer("Tom", "Sal", 1000000));
		list.add(new Lecturer("John", "Mirra", 360000));
		System.out.println(i.getFirstName(list));
		System.out.println(i.getMaxSalary(list));
	}
}
class Implementation{
	public List<String> getFirstName(List<Lecturer> list){
		List<String> tempList = new ArrayList<>();
		for(Lecturer l:list) {
			tempList.add(l.getLecturerFirstName());
		}
		return tempList;
	}
	public double getMaxSalary(List<Lecturer> lecturerList){
		double max=Double.MIN_VALUE;
		for(Lecturer l:lecturerList) {
			if(l.getSalary()>max)
				max=l.getSalary();
		}
		return max;
	}
}
package q25;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

enum Specialty{
	ENGINEER,
	MANAGER,
	DEVOPS;
}

public class Specialist {
	private String name;
	private BigDecimal salary;
	private Specialty specialty;

	public Specialist(String name, BigDecimal salary, Specialty specialty) {
		this.name = name;
		this.salary = salary;
		this.specialty = specialty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	@Override
	public String toString() {
		return "Specialist {name='" + name +"', salary="+salary+ ", specialty=" + specialty + "}\n";
	}

	public static void main(String[] args) {
		List<Specialist> list = Arrays.asList(
				new Specialist("Ivan Ivanov", new BigDecimal(5000), Specialty.ENGINEER),
				new Specialist("Sergey Sergeev", new BigDecimal(3000), Specialty.DEVOPS),
				new Specialist("Petr Petrov", new BigDecimal(10000), Specialty.MANAGER));
		Implementation implementation=new Implementation();
		System.out.println(implementation.filterBySpeciality(list,Specialty.ENGINEER));
		System.out.println(implementation.sortSpecialistsByNameAsc(list));

	}

}
class Implementation {
	
	public List<Specialist> filterBySpeciality(List<Specialist> specialists, Specialty specialty){
		int n=specialists.size();
		List<Specialist> list = new ArrayList<Specialist>();
		for(int i=0;i<n;i++) {
			if(specialists.get(i).getSpecialty()==specialty)
				list.add(specialists.get(i));
		}
		return list;
	}
	public List<Specialist> sortSpecialistsByNameAsc(List<Specialist> specialist){
		Collections.sort(specialist, Comparator.comparing(Specialist::getName));		

		return specialist;
	}
}
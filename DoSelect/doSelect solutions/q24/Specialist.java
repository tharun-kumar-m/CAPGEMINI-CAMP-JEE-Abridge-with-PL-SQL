package q24;

import java.math.BigDecimal;
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
		return "Specialist {name='" + name +"', salary="+salary+ ", specialty=" + specialty + "}";
	}

	public static void main(String[] args) {
		List<Specialist> list = Arrays.asList(
				new Specialist("Ivan Ivanov", new BigDecimal(5000), Specialty.ENGINEER),
				new Specialist("Sergey Sergeev", new BigDecimal(3000), Specialty.DEVOPS),
				new Specialist("Petr Petrov", new BigDecimal(10000), Specialty.MANAGER));
		Implementation implementation=new Implementation();
		System.out.println(implementation.findWithMaxSalary(list));
		System.out.println(implementation.matchAllEngineers(list));

	}

}
class Implementation {
	
	public Specialist findWithMaxSalary(List<Specialist> specialists){
		Collections.sort(specialists, Comparator.comparing(Specialist::getSalary));		
		return specialists.get(specialists.size()-1);
	}
	public boolean matchAllEngineers(List<Specialist> specialists){
		int n=specialists.size();
		Specialty a = specialists.get(n-1).getSpecialty();
		for(int i=0;i<n;i++) {
			if(specialists.get(i).getSpecialty()!=a)
				return false;
		}
		return true;
	}
	
}
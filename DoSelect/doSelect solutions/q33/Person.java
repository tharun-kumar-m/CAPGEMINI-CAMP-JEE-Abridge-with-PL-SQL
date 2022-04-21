package q33;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {
	private Integer id;
	private String name;
	private LocalDate birthDate;
	public Person(Integer id, String name, LocalDate birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "Product{id="+id+" name='" + name +"', birthDate="+birthDate+"}";
	}
	public static void main(String[] args) {
		Person p1 = new Person(1, "Mito", LocalDate.of(1991, 1, 21));
		Person p2 = new Person(2, "Code", LocalDate.of(1990, 2, 21));
		Person p3 = new Person(3, "Jaime", LocalDate.of(1980, 6, 23));
		Person p4 = new Person(4, "Duke", LocalDate.of(2019, 5, 15));
		Person p5 = new Person(5, "James", LocalDate.of(2010, 1, 4));
		List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5);
		Implementation imp=new Implementation();
		System.out.println(imp.filterListByBirth(persons));
		System.out.println(imp.limitSkipAndReturn(persons, 1, 2));
	}
}
class Implementation{
	public List<Person> filterListByBirth(List<Person> persons){
		List<Person> persons1=new ArrayList<>(persons);
		Collections.sort(persons1, Comparator.comparing(Person::getBirthDate));
		return persons1;
	}
	public List<Person> limitSkipAndReturn(List<Person> persons,int pageNumber,int pageSize){
		List<Person> list=new ArrayList<>();
		int temp1=pageNumber*pageSize;
		int temp2=0;
		for(int i=temp1;i<persons.size();i++) {
			if(temp2==temp1)
				return list;
			list.add(persons.get(i));
			temp2++;
		}
		return list;
	}
}
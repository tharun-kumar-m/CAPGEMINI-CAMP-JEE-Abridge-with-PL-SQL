package q31;
import java.util.ArrayList;
import java.util.List;

public class Dog {
	String name;
	int age;
	int weight;
	public Dog(String name, int age, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Dog{name='" + name +"', age="+age+ ", weight=" + weight + "}";
	}
	public static void main(String[] args) {
		List<Dog> list = new ArrayList<Dog>();
		list.add(new Dog("German Shepherd ", 20, 35));
		list.add(new Dog("Labrador ", 5, 40));
		list.add(new Dog("Pitbull ", 29, 100));
		list.add(new Dog("Poodle", 10, 45));
		Implementation implementation=new Implementation();
		System.out.println(implementation.filterByAgeAndWeight(list));
		System.out.println(implementation.separateWithDelimeter(list));
	}
}
class Implementation{
    public List<Dog> filterByAgeAndWeight(List<Dog> listDog){
    	int i=0;
    	List<Dog> list=new ArrayList<>();
    	for(Dog d:listDog) {
    		if(listDog.get(i).getAge()>10 && listDog.get(i).getWeight()>25) {
    			list.add(d);
    		}
    		i++;
    	}
    	return list;
    }
    public String separateWithDelimeter(List<Dog> listDog){
    	StringBuffer sb=new StringBuffer();  
		int n=listDog.size();
		sb.append(listDog.get(0));
		for(int i=1;i<n;i++) {
			sb.append("$~$~");
			sb.append(listDog.get(i));
		}
		return sb.toString();
    }
}
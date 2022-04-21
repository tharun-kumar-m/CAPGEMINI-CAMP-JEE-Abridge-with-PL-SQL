package q01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

enum FoodType{
	VEG,
	NONVEG;
}

public class Consumer {
	private final String name;
	private final int age;
	private final FoodType foodtype;

	public Consumer(String name, int age, FoodType foodtype) {
		this.name = name;
		this.age = age;
		this.foodtype = foodtype;
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public FoodType getFoodtype() {
		return foodtype;
	}

	@Override
	public String toString() {
		return "Consumer {name=" + name + ", age=" + age + ", foodtype=" + foodtype + "}"+","+"\n";
	}
	public static void main(String args[]) {
		
		Implementation imp =new Implementation();
		Consumer p=new Consumer("Sarah",45,FoodType.VEG);
		Consumer p1=new Consumer("John",26,FoodType.NONVEG);
		Consumer p2=new Consumer("Mirra",7,FoodType.NONVEG);
		
		List<Consumer> consumers=Arrays.asList(p,p1,p2);
		
		System.out.println(imp.getNonVegetarianList(consumers));
		//for(Consumer i:c1)
		//	System.out.println(i);
		
		System.out.println(imp.sortConsumersByAge(consumers));
		//for(Consumer i:c2) {
		//	System.out.println(i);
		
	}
}

class Implementation {
	
	public List<Consumer> getNonVegetarianList(List<Consumer> consumer){
		List<Consumer> c=new ArrayList<>();
		for(Consumer con:consumer) {
			if(con.getFoodtype()==FoodType.NONVEG)
				c.add(con);
		}
		return c;
	}
	
	public List<Consumer> sortConsumersByAge(List<Consumer> consumer){
		
		Collections.sort(consumer, Comparator.comparing(Consumer::getAge));
		return consumer;
	}
}
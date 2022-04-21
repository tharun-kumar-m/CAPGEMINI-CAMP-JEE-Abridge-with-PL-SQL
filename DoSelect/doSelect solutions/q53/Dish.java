package q53;

import java.util.ArrayList;
import java.util.List;

public class Dish {
	String dishName;

	public Dish(String dishName) {
		this.dishName = dishName;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	@Override
	public String toString() {
		return "Dish{dishName='"+dishName+"'}";
	}
	public static void main(String[] args) {
		DishTest dt = new DishTest();
		List<Dish> list = new ArrayList<Dish>();
		list.add(new Dish("Gazpacho"));
		list.add(new Dish("Jamon"));
		list.add(new Dish("Tortilla"));
		list.add(new Dish("Churros"));
		System.out.println(dt.addYummyToName(list));
		System.out.println(dt.count(list, "S"));
	}
}
class DishTest{
	public List<Dish> addYummyToName(List<Dish> list){
		List<Dish> tempList = new ArrayList<Dish>();
		for(Dish d:list) {
			d.dishName="Yummy: "+d.getDishName();
			//System.out.println(d.dishName);
			tempList.add(d); 
		}
		return tempList;
	}
	public long count(List<Dish> list, String s) {
		long sCount=0;
		for(Dish d:list) {
			if(d.getDishName().toLowerCase().startsWith("s"))
				sCount++;
		}
		return sCount;
	}
}
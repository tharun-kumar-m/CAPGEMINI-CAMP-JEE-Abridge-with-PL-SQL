package q56;

import java.util.ArrayList;
import java.util.List;

public class Implementation {
	
	public int count(List<String> products) {
		long count=products.stream().count();
		return (int)count;
	}
	
	public String match(List<String> products) {
		int count=0;
		for(String s:products) {
			
			if(s.indexOf("z")!=-1) {
				count++;
			}
		}
		if(count==0)
			return "Great Job that sentence does not contain z";
		else
			return "Cant fool the system, that sentence contain z";
	}

	public static void main(String[] args) {
		Implementation i = new Implementation();
		List<String> list = new ArrayList<String>();
		list.add("Gadgets");
		list.add("FoodItem");
		list.add("Pets");
		list.add("Appliances");
		
		System.out.println(i.count(list));
		System.out.println(i.match(list));
	}
}
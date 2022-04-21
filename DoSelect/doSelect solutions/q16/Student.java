package q16;

import java.util.HashMap;
import java.util.Map;

public class Student {
	Map<String,String> dataList = new HashMap<String,String>();
	public String addStudentDetails(String name, String id) {
		if(dataList.containsKey(name))
			return "Id generation Failed, name is already present in the database";

		dataList.put(name, id);
		return "Id Generated";
	}
	public String deleteId(String name) {
		if(!dataList.containsKey(name))
			return "Id not found";
	dataList.remove(name);
	return "Id deleted successfully";
	}
	public String searchId(String name) {
		if(!dataList.containsKey(name))
			return "Id not found";
		String temp=dataList.get(name);
		dataList.remove(name);
		return temp;
		
	}
	public static void main(String[] args) {
		Student obj=new Student();
		String s1,s2,s3,s4;
		s1 = obj.addStudentDetails("Sarah","99889");
		s2 = obj.addStudentDetails("John","78985");
		s3 = obj.deleteId("Sarah");
		s4 = obj.searchId("Steve");
		System.out.println(s1+"\n"+s2+"\n"+s3+"\n"+s4);

	}
}

package q29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
	
	String name;
	boolean value;
	ArrayList<String> tags;

	public Program(String name, boolean value, ArrayList<String> tags) {
		super();
		this.name = name;
		this.value = value;
		this.tags = tags;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public String getName() {
		return name;
	}

	public boolean isValue() {
		return value;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public static void main(String[] args) {
		Program p = new Program("reconcile program", true, new ArrayList<String>(Arrays.asList("C","D")));
		Menu m = new Menu(p);
		System.out.println(m.addProgram());
		System.out.println(m.runQuery("C,B"));
		System.out.println(p.getName());
		System.out.println(p.getTags());

	}

}
class Menu {
	
	public Program prog;

	public Menu(Program prog) {
		this.prog = prog;
	}
	
	public String addProgram() {
		if(prog.isValue()==false) {
			prog.setValue(true);
			return "Boolean changed";
		}
		String words[]=prog.getName().split("\\s");  
	    String capitalizeWord="";  
	    for(String w:words){  
	        String first=w.substring(0,1);  
	        String afterfirst=w.substring(1);  
	        capitalizeWord+=first.toUpperCase()+afterfirst+" ";  
	    }
		prog.setName(String.valueOf(capitalizeWord));

		return "Program ready";
	}
	public String runQuery(String query) {
		List<String> l=new ArrayList<>();
		
			String[] s=query.split(",");
			for(int i=0;i<s.length;i++) {
				l.add(s[i]);
			}
		int count=0;
		for(String i:l) {
			if(!prog.getTags().contains(i)) {
				prog.getTags().add(i);
				count++;
			}
		}
		if(count==0) {
			return "No changes";
		}else
		return count+" tags added";
	}

}
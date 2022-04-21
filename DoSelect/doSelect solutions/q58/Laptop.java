package q58;

public class Laptop {
	String name;
    String model;
    String date;
	public Laptop(String name, String model, String date) {
		super();
		this.name = name;
		this.model = model;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public String getModel() {
		return model;
	}
	public String getDate() {
		return date;
	}
	public static void main(String[] args) {
		//Laptop l=new Laptop("Acer Quad","@#","12/12/2018");
		Purchase p=new Purchase();
		System.out.println(p.purchaseLaptop("Dell Quad","@#","12/12/2018"));
		System.out.println("Octa");
		System.out.println(p.purchaseLaptop("Dell Quad","A!aA1aA2a@","12/12/2018"));
	}
}
class Purchase{
	Laptop laptop;
	public String purchaseLaptop(String name,String model,String date) {
		String[] temp;
		char[] tempModel= model.toCharArray();
		int digitcount=0,uppercount=0,lowercount=0,specialcount=0;
		int n=model.length();
		for(int i=0;i<n;i++) {
			if(Character.isDigit(tempModel[i]))
				digitcount++;
			else if(Character.isUpperCase(tempModel[i]))
				uppercount++;
			else if(Character.isLowerCase(tempModel[i]))
				lowercount++;
			else
				specialcount++;
		}
		temp=name.split("\\s+");
		if(!(temp[0].equals("Dell")||temp[0].equals("Acer")||temp[0].equals("HP")))
			return "Invalid brand name";
		if(!(temp[1].equals("Single")||temp[1].equals("Double")||temp[1].equals("Quad")||temp[1].equals("Octa")))
			return "Invalid processor";
		if(!(model.length()>=9 && uppercount==3 && lowercount==3 && digitcount==2 && specialcount==2 ))
        	return "Invalid model number";
		return "Laptop purchased";
	}
	public String findGeneration(String processor) {
		if(processor.equals("Octa"))
			return "Gen 11";
		if(processor.equals("Quad"))
			return "Gen 10";
		if(processor.equals("Double"))
			return "Gen 9";
		return "Lower than 9";
	}
}
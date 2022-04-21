package q02;

public class Material {
	public int mass;
	public int temperature;
	
	public Material(int mass,int temperature) {
		this.mass=mass;
		this.temperature=temperature;
	}
	
	public int getMass() {
		return mass;
	}
	public int getTemperature() {
		return temperature;
	}
	
	public String checkMaterial() throws Exception{
		
		if(mass<0)
			throw new MaterialException("Mass cannot be negative");
		if(mass==0)
			throw new MaterialException("Mass cannot be zero");
		
		return "Valid material";
	}
	
	public String flowOfHeat() throws Exception{
		try {
			checkMaterial(); 
		}
		
		catch (MaterialException e) {
			return "Invalid Material";
		}
		catch(Exception e) {
			return "Other Exception";
		}
		return "Both in equilibrium";
	}
	
	public static void main(String[] args) throws Exception {
		Material m = new Material(12,32);
		String s=m.flowOfHeat();
		System.out.println(s);
	}
}

@SuppressWarnings("serial")
class MaterialException extends Exception {
	
	public MaterialException(String msg) {
		super(msg);
	}
}


package q34;

public class Bomb {
	public int time;
	public String color;
	public Bomb(int time, String color) {
		super();
		this.time = time;
		this.color = color;
	}
	public int getTime() {
		return time;
	}
	public String getColor() {
		return color;
	}
	public static void main(String[] args) throws Exception {
		Bomb b=new Bomb(10,"red");
		Suicide sc=new Suicide(b);
		String s = sc.diffuseIt(5,"red");
		String t = sc.checkSafety(8,"blue");
		System.out.println(s.toLowerCase());
		System.out.println(t.toLowerCase());
	}
}
class Suicide{
	public Bomb bomb;

	public Suicide(Bomb bomb) {
		this.bomb = bomb;
	}
	public String diffuseIt(int time, String color) throws Exception{
		if(time>bomb.getTime())
			throw new SuicideException("Time exceeded");
		if(!color.equals(bomb.color))
			throw new SuicideException("Wrong color");
		return "Hope is there";
	}
	public String checkSafety(int time, String color) throws Exception{
		try{
			diffuseIt(time,color);
		}
		catch(SuicideException e) {
			return "Bomb exploded";
		}
		catch(Exception e) {
			return "Other exception";
		}
		return "Take a bow";
	}
}
@SuppressWarnings("serial")
class SuicideException extends Exception{
	public SuicideException(String str) {
		super(str);
	}
}
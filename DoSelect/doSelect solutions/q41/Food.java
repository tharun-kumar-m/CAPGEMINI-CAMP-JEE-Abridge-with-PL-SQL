package q41;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Food {
	
	String plate;
	int numberOfSoldiers;

	public Food(String plate, int numberOfSoldiers) {
		this.plate = plate;
		this.numberOfSoldiers = numberOfSoldiers;
	}
	public String getPlate() {
		return plate;
	}
	public int getNumberOfSoldiers() {
		return numberOfSoldiers;
	}
	public static void main(String[] args) {
		Food f = new Food("1234", 70000);
		KhumbhKaran v = new KhumbhKaran();
		String s = null;
		try {
			s = v.getReadyToFight(f);
		} 
		catch (Exception e) {
			s=e.getMessage();
		}
		String t = null;
		try {
			t = v.winTheWar(f);
		}
		catch (Exception e) {
			t=e.getMessage();
		}
		System.out.println(s.toLowerCase());
		System.out.println(t.toLowerCase());

	}

}
class KhumbhKaran {
	public String getReadyToFight(Food food) throws Exception{
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(food.getPlate());
        
        if(matcher.find()) {
        	throw new FoodException("Insect found in the food");
        }
        String f=food.getPlate();
        for(int i=0;i<f.length();i++) {
        	if(Character.isLetter(f.charAt(i))) {
        		throw new FoodException("Not edible");
        	}
        }
        if(food.getNumberOfSoldiers()<1000) {
        	throw new FoodException("Food was not sufficient");
        }
		return "Ready for the war";
	}
	
	public String winTheWar(Food food) throws Exception{
		try {
			getReadyToFight(food);
		}
		catch(FoodException e) {
			return "No war";
		}
		catch(Exception e) {
			return "Other exception";
		}
		return "Here the battle starts";
	}

}
@SuppressWarnings("serial")
class FoodException extends Exception{
	public FoodException(String s) {
		super(s);
	}

}
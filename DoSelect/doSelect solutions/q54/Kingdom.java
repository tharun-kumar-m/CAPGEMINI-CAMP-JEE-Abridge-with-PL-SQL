package q54;

import java.util.ArrayList;
import java.util.List;

public class Kingdom {
	String life;
	String nonLife;
	int lifeSpan;

	public Kingdom(String life, String nonLife, int lifeSpan) {
		super();
		this.life = life;
		this.nonLife = nonLife;
		this.lifeSpan = lifeSpan;
	}

	public String getLife() {
		return life;
	}
	public String getNonLife() {
		return nonLife;
	}
	public int getLifeSpan() {
		return lifeSpan;
	}
	@Override
	public String toString() {
		return "Kingdom{life='" + life + "', nonLife='" + nonLife + "', lifeSpan=" + lifeSpan + "}";
	}

	public static void main(String[] args) {
		KingdomClassification k = new KingdomClassification();
		List<Kingdom> list1=new ArrayList<Kingdom>();
		list1.add(new Kingdom("Protista", "Regnum", 3));
		list1.add(new Kingdom("Plantae", "Lapideum", 5));
		
		System.out.println(k.getKingdom(list1));
		System.out.println(k.findNameWithValidity(list1, "Lapideum", 5));
	}
}
class KingdomClassification {
	public List<String> getKingdom(List<Kingdom> list){
		List<String> l=new ArrayList<String>();
		for(Kingdom k:list) {
			l.add(k.getLife());
		}
		return l;
	}
	public Kingdom findNameWithValidity(List<Kingdom> list, String name, int lifeSpan) {
		for(Kingdom k:list) {
			if(k.getNonLife().equals(name) && k.getLifeSpan()==lifeSpan)
				return k;
		}
		return null;
	}
}
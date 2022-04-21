package q55;

import java.util.ArrayList;
import java.util.List;

public class Fish {
	String species;
	int weight;

	public Fish(String species, int weight) {
		this.species = species;
		this.weight = weight;
	}
	public String getSpecies() {
		return species;
	}
	public int getWeight() {
		return weight;
	}
	@Override
	public String toString() {
		return "[Fish{species='"+species+"', weight="+weight+"}]";
	}
	public static void main(String[] args) {
		FishClass f = new FishClass();
		
		List<Fish> list = new ArrayList<Fish>();
		list.add(new Fish("BlobFish", 20));
		list.add(new Fish("Guppy", 15));
		list.add(new Fish("Oscar", 60));
		list.add(new Fish("GoldFish", 5));
		
		System.out.println(f.getFishWithLowestWeight(list));
		System.out.println(f.mapFishWeight(list));

	}
}
class FishClass {
	
	public Fish getFishWithLowestWeight(List<Fish> list){
		int min=Integer.MAX_VALUE;
		for(Fish i:list) {
			int weight=i.getWeight();
			if(weight<min)
				min=weight;
		}
		for(Fish i:list) {
			if(i.getWeight()==min)
				return i;
		}
		return null;
	}
	public List<Integer> mapFishWeight(List<Fish> list){
		List<Integer> l=new ArrayList<>();
		for(Fish i:list) {
			l.add(i.getWeight());
		}
		return l;
	}
}
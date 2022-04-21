package q52;

import java.util.ArrayList;

public class Box {
	private int id;
    private int volume;
	public Box(int id, int volume) {
		super();
		this.id = id;
		this.volume = volume;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
    public static void main(String[] args) {
    	Box box = new Box(1,200);
    	ContainerBox containerBox = new ContainerBox();
    	containerBox.addBox(box);
    	System.out.println(containerBox.addWater(1,100));
    	System.out.println(containerBox.getBoxes(200,4));
	}
}
class ContainerBox{
	public ArrayList<Box> boxes=new ArrayList<Box>();
	public void addBox(Box box) {
		boxes.add(box);		
	}
	public String addWater(int id,int liter) {
		for(Box b:boxes) {
			if(b.getId()==id) {
				if(b.getVolume()>=liter) {
					b.setVolume(b.getVolume()-liter);
					return "Water filled";
				}
				if(b.getVolume()<liter) {
					b.setVolume(b.getVolume()-liter);
					return "Water filled";
				}
			}
		}
		return "No Box found";
	}
	public ArrayList<Box> getBoxes(int volume, int comparator) {
		ArrayList<Box> tempBoxes=new ArrayList<Box>();
		if(comparator==1) {
			for(Box b:boxes) {
				if(b.getVolume()<volume) {
					tempBoxes.add(b);
				}
			}
			return tempBoxes;
		}
		if(comparator==2) {
			for(Box b:boxes) {
				if(b.getVolume()>volume) {
					tempBoxes.add(b);
				}
			}
			return tempBoxes;
		}
		return null;
	}
}
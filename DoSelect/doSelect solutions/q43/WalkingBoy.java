package q43;

import java.util.*;

public class WalkingBoy {
	public int stepSize;
	public int blockSize;

	public WalkingBoy(int stepSize, int blockSize) {
		this.stepSize = stepSize;
		this.blockSize = blockSize;
	}
	public int getStepSize() {
		return stepSize;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public String targetHit(String platform) throws Exception{
		List<String> blocks=new ArrayList<String>();
		String temp="";
		int n=platform.length();
		for(int i=0;i<n;i++) {
			temp+=platform.charAt(i);
			if(temp.length()==blockSize) {
				blocks.add(temp);
				temp="";
			}
		}
		
		for(String i:blocks) {
			String a=i.substring(0,stepSize);
			if(a.contains("x")) {
				throw new BombBlast("You hit the target");
			}
		}
		return "Win";
	}

	public static void main(String[] args) {
		WalkingBoy boy = new WalkingBoy(2,3);
		try {
			System.out.println(boy.targetHit("1212121x212"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
@SuppressWarnings("serial")
class BombBlast extends Exception{
	public BombBlast(String s) {
		super(s);
	}
}
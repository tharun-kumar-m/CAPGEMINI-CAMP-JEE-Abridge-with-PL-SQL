package q19;

public class Cue {
	int pieces;
	boolean retain;
	public Cue(int pieces,boolean retain) {
		this.pieces=pieces;
		this.retain=retain;
	}
	public int getPieces() {
		return pieces;
	}
	public boolean isRetain() {
		return retain;
	}
	public static void main(String[] args) throws Exception {
		Cue c=new Cue(13,true);
		Retention r= new Retention(c);
		String ans = r.playGame(5);
		System.out.println(ans);
	}
	
}
class Retention{
	Cue cue=null;
	public Retention(Cue c) {
		this.cue=c;
	}
	
	public String checkCue(int p) throws Exception{
		if(!cue.isRetain())
			throw new CueException("Cue not retained");
		if(cue.getPieces()>p)
			throw new CueException("More pieces required");
		if(cue.getPieces()<p)
			throw new CueException("Update required");
		return "Cue updated";
	}
	public String playGame(int p) throws Exception{
		try{
			checkCue(p);
		}
		catch (CueException e) {
			return "Cannot use this cue";
		}
		catch (Exception e) {
			return "Other exception"; 
		}
		return "Welcome to the game";
	}
}
@SuppressWarnings("serial")
class CueException extends Exception{
	public CueException(String s) {
		super(s);
	}
}

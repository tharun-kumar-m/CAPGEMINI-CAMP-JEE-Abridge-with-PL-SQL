package q37;

public class Player {
	int requiredRuns;
	String summary;
	
    Player(int requiredRuns, String summary){
    	this.requiredRuns = requiredRuns;
    	this.summary = summary;
    }
    public void setRequiredRuns(int requiredRuns) {
    	this.requiredRuns = requiredRuns;
    }
    public void setSummary(String summary) {
    	this.summary = summary;
    }
    public int getRequiredRuns() {
    	return this.requiredRuns;
    }
    public String getSummary(){
    	return this.summary; 
    }
    public static void main(String[] args) throws Exception {
    	Player p=new Player(12,"123461");
		Match m=new Match();
		System.out.println(m.checkTarget(p).toLowerCase());
		System.out.println(m.results(p).toLowerCase());
	}
}
 class Match{
	int requiredRuns;
 	char[] summary;	
    public String checkTarget(Player player) throws Exception{
    	requiredRuns = player.getRequiredRuns();
    	summary= player.getSummary().toCharArray();	
    	int totalruns=0;
    	for (char c:summary){
			if (Character.isDigit(c))
	            totalruns += Integer.parseInt(String.valueOf(c));;
			if(c=='W')
				throw new MatchException("Out");
		}
		if(totalruns<requiredRuns)
			throw new MatchException("Lost by runs");

		return "We may win"; 		
    }
    public String results(Player player) throws Exception
    {
    	try {
    		checkTarget(player);
    		return "We won";
    	}
    	catch(MatchException e){
    		return "We lost";
    	}
    	catch(Exception e) {
    		return "Other exception";
    	}
    }
 }
@SuppressWarnings("serial")
class MatchException extends Exception{
    public MatchException(String msg ) {
    	super(msg);
    }
}
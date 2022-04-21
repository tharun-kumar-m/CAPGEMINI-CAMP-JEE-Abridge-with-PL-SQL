package q23;

public class Racer {
	public String action;
	public int runScore;
	public int jumpScore;
	public int crawlScore;
	public Racer(String action, int runScore, int jumpScore, int crawlScore) {
		super();
		this.action = action;
		this.runScore = runScore;
		this.jumpScore = jumpScore;
		this.crawlScore = crawlScore;
	}
	
	//long countJ = action.chars().filter(ch -> ch == 'j').count();
	//long countC = action.chars().filter(ch -> ch == 'c').count();
	//long countR = action.chars().filter(ch -> ch == 'r').count();
	
	public String goodAt() {
		int countJ = 0,countC = 0;
		for (int i = 0; i < action.length(); i++) {
		    if (action.charAt(i) == 'j') {
		        countJ++;
		    }
		    if (action.charAt(i) == 'c') {
		        countC++;
		    }
		}
		if(countJ==countC)
			return "Perfect";
		else if(countJ>countC)
			return "Jumper";
		else 
			return "Crawler";
	}

	public int finalScore() {
		int countJ = 0,countC = 0,countR = 0;
		for (int i = 0; i < action.length(); i++) {
		    if (action.charAt(i) == 'j') {
		        countJ++;
		    }
		    if (action.charAt(i) == 'c') {
		        countC++;
		    }
		    if (action.charAt(i) == 'r') {
		        countR++;
		    }
		}
		return (int) ((countJ*jumpScore)+(countC*crawlScore)+(countR*runScore));
	}
	public static void main(String[] args) {
		Racer racer = new Racer("jjcr",20,30,5);
		System.out.println(racer.goodAt());
		System.out.println(racer.finalScore());
	}
}

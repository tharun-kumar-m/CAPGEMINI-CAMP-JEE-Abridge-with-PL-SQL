package q04;

public class Rating {
	public int imdbRating;
	public int nominee;
	
	public Rating(int imdbRating,int nominee) {
		this.imdbRating=imdbRating;
		this.nominee=nominee;
	}
	
	public int getImdbRating() {
		return imdbRating;
	}
	public int getNominee() {
		return nominee;
	}
	
	public static void main(String[] args) throws Exception  {
		Rating rating=new Rating(9,7);
		Validator v=new Validator();
		String s = v.canBeConsideredForTheAward(rating);
		String t = v.sendInvite(rating);
		s.toLowerCase();
		t.toLowerCase();
		
		System.out.println(s);
		System.out.println(t);
	}
}
class Validator {
public String canBeConsideredForTheAward(Rating rating) throws Exception{
		
		if(rating.getImdbRating()<7)
			throw new MovieRatingException("Movie not eligible for Filmfare award");
		
		if(rating.getNominee()<4)
			throw new MovieRatingException("Minimum 4 nominee required");
		
		return "Considered for the award";
	}
	public String sendInvite(Rating rating) throws Exception{
		
		try{
			canBeConsideredForTheAward(rating);
		}
		catch(MovieRatingException e) {
			return "Not invited";
		}
		catch(Exception e) {
			return "other exception";
		}
		
		return "Actors and Directors Invited";
	}
}
class MovieRatingException extends Exception{
	
	private static final long serialVersionUID = -7923763689250416728L;

	public MovieRatingException(String msg) {
		super(msg);
	}
}
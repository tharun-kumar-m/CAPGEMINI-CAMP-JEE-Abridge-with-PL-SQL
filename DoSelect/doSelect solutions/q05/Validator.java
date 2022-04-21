package q05;

import java.util.ArrayList;
import java.util.Arrays;

public class Validator {
	public String checkComment(String comment) throws Exception{
		
		String[] strSplit = comment.split(" ");
		ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strSplit));
		ArrayList<String> spamList = new ArrayList<String>();
		
		for(String s : strList) {
			if(s.equals("abcde")||s.equals("lmno")||s.equals("pqrst")||s.equals("wxyz")) {
				spamList.add(s);
			}
		}
		if(spamList.size()==1||spamList.size()==2)
			throw new SpamCommentException("spam comment");

		if(spamList.size()>2)
			throw new SpamCommentException("account ban due to spam comment");
		return "comment is not spam";
		
	}
	
	public String commentTheString(String comment) throws Exception{
		try {
			checkComment(comment);
		}
		catch(SpamCommentException e) {
			return e.getMessage();
		}
		catch(Exception e) {
			return "other exception";
		}
		return "comment posted";
		
	}
	
	public static void main(String[] args) throws Exception {
		Validator obj = new Validator();
		try {
		System.out.println(obj.checkComment("hello my name is steve"));
		System.out.println(obj.commentTheString("my comment is safe to post"));
		}
		catch(SpamCommentException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());	
		}
	}
}
@SuppressWarnings("serial")
class SpamCommentException extends Exception{
	public SpamCommentException(String msg) {
		super(msg);
	}
}
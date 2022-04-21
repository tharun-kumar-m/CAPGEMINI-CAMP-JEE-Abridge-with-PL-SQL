package q40;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
	String username;
	String domain;
	
	Email(String username, String domain){
		this.username = username;
		this.domain= domain;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setDomain(String domain) {
		this.domain= domain;
	}
	public String getUsername() {
		return this.username;
	}
	public String getDomain() {
		return this.domain;
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Email e=new Email("Shoyab@","gmail");
		Validator v = new Validator();
		System.out.println(v.checkEmail(e).toLowerCase());
		System.out.println(v.signIn(e).toLowerCase());
	}
}
class Validator{
	public String checkEmail(Email email) throws Exception{
		String domain = email.getDomain();
		Pattern pattern =Pattern.compile ("[!#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher matcher = pattern.matcher(email.getUsername());
        boolean check = matcher.find();

		if(check)
			throw new EmailException("Invalid username");
		else if(!(domain == "outlook" || domain =="gmail" ||domain == "hotmail" || domain =="godaddy" ))
			throw new EmailException("Invalid domain");
		
		return "Continue";
	}
	public String signIn(Email email) throws Exception{
		try {
			checkEmail(email);
		}
		catch(EmailException e) {
			return "Failed";
		}
		catch(Exception e) {
			return "Other exception";
		}
		return "Signed in";
	}
}
@SuppressWarnings("serial")
class EmailException extends Exception{
	public EmailException(String msg) {
		super(msg);
	}
}
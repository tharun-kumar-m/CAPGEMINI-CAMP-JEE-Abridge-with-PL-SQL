package q46;

public class Register {
	public String checkCredentials(String email, String pass, String cpass) throws Exception{
		if(!(email.contains("@")&&email.contains(".")))
			throw new InvalidEmailException("Invalid Email");
		if(pass.length()<6)
			throw new InvalidPasswordException("Invalid Password");
		if(!(pass.equals(cpass)))
			throw new PasswordNotMatchException("Password not match");
		return "Registered";
		
	}
	public static void main(String[] args) throws Exception {
		Register user = new Register();
		System.out.println(user.checkCredentials("tushar@gmailcom","hiiiiii","hiiiiii"));
	}
}
@SuppressWarnings("serial")
class InvalidEmailException extends Exception{
	public InvalidEmailException(String msg) {
		super(msg);
	}
}
@SuppressWarnings("serial")
class InvalidPasswordException extends Exception{
	public InvalidPasswordException(String msg) {
		super(msg);
	}
}
@SuppressWarnings("serial")
class PasswordNotMatchException extends Exception{
	public PasswordNotMatchException(String msg) {
		super(msg);
	}
}
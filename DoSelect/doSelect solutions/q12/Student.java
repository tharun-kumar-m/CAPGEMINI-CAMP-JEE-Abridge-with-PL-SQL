package q12;

public class Student {
	public String StudentID;
	public String StudentName;
	public Student(String studentID, String studentName) {
		StudentID = studentID;
		StudentName = studentName;
	}
	public String getStudentID() {
		return StudentID;
	}
	public void setStudentID(String studentID) {
		StudentID = studentID;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentName() {
		return StudentName;
	}
	public static void main(String[] args) throws Exception {
        Student student=new Student("A1011","Elizabeth Saltzman");
        Source s=new Source();
        String res=s.ValidateStudent(student);
        System.out.println(res);
        String res1=s.ValidateUserId(student);
        System.out.println(res1);
    }
}
@SuppressWarnings("serial")
class InvalidStudentNameException extends Exception{
	public InvalidStudentNameException(String s) {
		super(s);
	}
}
class Source{
    public String ValidateStudent(Student std) throws InvalidStudentNameException {
        if(!(Character.isUpperCase(std.StudentName.charAt(0)) && std.StudentName.substring(1).equals(std.StudentName.substring(1).toLowerCase()))) {
            try{
                throw new InvalidStudentNameException("Invalid Name");
            }
            catch(Exception e){
                std.StudentName="Invalid";
                return e.toString();
            }
        }
        else{
            std.StudentName="Valid";
            return std.StudentName;
        }
    }
    public String ValidateUserId(Student std) throws InvalidStudentNameException {
        
        if(!(std.StudentID.matches("^[A-Z]\\w{4,20}$") && 
                std.StudentID.substring(1).equals(std.StudentID.substring(1).toLowerCase()))) {
            try{
                throw new InvalidStudentNameException("Invalid Name");
            }
            catch(Exception e){
                std.StudentID="Invalid";
                 return e.toString();
            }
        }
        else{
        	std.StudentID="Valid";
            return std.StudentID;
        }
    }
}
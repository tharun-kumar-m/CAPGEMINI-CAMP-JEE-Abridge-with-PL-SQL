package q35;

import java.util.ArrayList;
import java.util.List;

public class Task {
	String name;
	int hours;
	public Task(String name, int hours) {
		this.name = name;
		this.hours = hours;
	}
	public String getName() {
		return name;
	}
	public int getHours() {
		return hours;
	}
	public static void main(String[] args) throws Exception {
		Task t= new Task("Gym",12);
		ToDoList lst=new ToDoList();
		String t1=lst.addTask(t);
        System.out.println(t1.toLowerCase());
        System.out.println(lst.completeTask(t));
	}
}
class ToDoList{
	List<Task> tasks=new ArrayList<>();
	public String addTask(Task t) throws Exception{
		if(t.getHours()<1||t.getHours()>24)
			throw new TaskException("Invalid time");
		 
		if(tasks.contains(t))
			throw new TaskException("Already present");
		tasks.add(t);
		return "Task will be completed";
	}
	public String completeTask(Task t) throws Exception{
		try {
			addTask(t);
		}
		catch(TaskException e) {
			return "Task incomplete";
		}
		catch(Exception e) {
			return "Other exception";
		}
		return "Task completed";
	}
}
@SuppressWarnings("serial")
class TaskException extends Exception{
	public TaskException(String msg) {
		super(msg);
	}
}
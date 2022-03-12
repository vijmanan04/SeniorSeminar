import java.util.ArrayList;
import java.util.Arrays;
public class Class {

	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<ArrayList<String>> sessions = new ArrayList<ArrayList<String>>();

	public void addStudent(Student s1){ // adds a student to the class
		students.add(s1);
	}

	public void addSession(ArrayList<String> s1){
		sessions.add(s1);
	}

	public void showClass(){ // prints all Students in the student arrayList to show how many students are in the arrayList
		for (Student student : students){
			System.out.println(student.toString());
		}
	}

	public void showSessions(){ // prints all Sessions in the session arrayList to show how many sessions are in the arrayList
		for (ArrayList<String> session : sessions){
			System.out.println(session);
		}
	}
}
